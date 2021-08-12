package com.example.Duyshop.Controller.Website;

import com.example.Duyshop.Dao.DaoCustomer;
import com.example.Duyshop.Dao.DaoStaff;
import com.example.Duyshop.Mode.Customer;
import com.example.Duyshop.Mode.Staff;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@WebServlet("/signup")
public class Signup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/View/Website/Signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           List<Staff> lststaff = new DaoStaff().findall();
           List<Customer> lstcus = new DaoCustomer().findall();
           DateTimeConverter dtc = new DateConverter(new Date());
           dtc.setPattern("dd/MM/yyyy");
           ConvertUtils.register(dtc, Date.class);//gi a oi
           HttpSession session = req.getSession();
           if (!req.getParameter("repassword").equals(req.getParameter("password"))){
               req.setAttribute("messengeError","Mật khẩu không trùng khớp");
               req.getRequestDispatcher("/View/Website/Signup.jsp").forward(req, resp);
               return;
           }

           if (req.getParameter("checkadmin")!=null){
               for (Staff staff:lststaff){
                   if (staff.getEmail().equals(req.getParameter("email"))){
                       req.setAttribute("messengeError","email đã đăng kí rồi");
                       req.getRequestDispatcher("/View/Website/Signup.jsp").forward(req, resp);
                       return;
                   }
               }
               Staff staff = new Staff();
               BeanUtils.populate(staff,req.getParameterMap());
               staff.setRole(false);
               staff.setPhone("");
               staff.setImage("");
               session.setAttribute("staff",staff);
               System.out.println(staff.getEmail());
               int code = sendmail(staff.getEmail());
               session.setAttribute("code",code+"");
               resp.sendRedirect(req.getContextPath()+"/signup/check?who=staff");
           }else {
               for (Customer cus:lstcus){
                   if (cus.getEmail().equals(req.getParameter("email"))){
                       req.setAttribute("messengeError","email đã đăng kí rồi");
                       req.getRequestDispatcher("/View/Website/Signup.jsp").forward(req, resp);
                       return;
                   }
               }
               Customer customer = new Customer();
               BeanUtils.populate(customer,req.getParameterMap());
               customer.setPhone("");
               customer.setImage("");
               customer.setAddress("");
               customer.setRank(1);
               session.setAttribute("customer",customer);
               System.out.println(customer.getEmail());
               int code = sendmail(customer.getEmail());
               session.setAttribute("code",code+"");
               resp.sendRedirect(req.getContextPath()+"/signup/check?who=customer");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    private Integer sendmail(String mail){
        System.out.println("batdau");
        final String username = "nguyenducduy96tn@gmail.com";

        Properties prop = new Properties();

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "*");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2"); //bừa1
//        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//bừa2
        Session sess = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                String username = "nguyenducduy96tn@gmail.com";
                String password = "Ducduy@96";
                return new PasswordAuthentication(username, password);
            }
        } );

        //Gui mail
        String mailTo = mail;
        String subject = "Confirm?";
        int Random = (int) (Math.random() * 100000000);
        String content =  "code :"+ Random;
        System.out.println("cc");
        try {
            Message mess = new MimeMessage(sess);
            mess.setFrom(new InternetAddress(username));
            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
            mess.setSubject(subject);
            mess.setText(content);
            Transport.send(mess);
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return Random;
    }
}
