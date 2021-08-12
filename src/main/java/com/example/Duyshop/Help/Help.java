package com.example.Duyshop.Help;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Part;
import java.io.File;
import java.util.Properties;

public class Help {
    public static boolean writefile(Part part,String realpart){
        try {
            File file = new File(realpart);
            if(!file.exists()) {
                file.mkdirs();
            }
            File photofile = new File(file,part.getSubmittedFileName());
            part.write(photofile.getAbsolutePath());
            System.out.println("ghi xong");
            return true;
        }catch (Exception e){
            System.out.println("lol: " +e);
            e.printStackTrace();
            return false;
        }
    }
//    public static boolean sendmail(){
//        Properties properties = new Properties();
//        properties.setProperty("mail.smtp.auth", "true");
//        properties.setProperty("mail.smtp.starttls.enable", "true");
//        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//        properties.setProperty("mail.smtp.port", "587");
//        // kết nối session
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                String username = "thutamxd@gmail.com";
//                String password = "thutam123";
//                return new PasswordAuthentication(username, password);
//            }
//        });
//        // tạo message
//        MimeMessage mimeMessage = new MimeMessage(session);
//        mimeMessage.setFrom(new InternetAddress("thutamxd@gmail.com"));
//        mimeMessage.setRecipients(Message.RecipientType.TO, emailTo);
//        mimeMessage.setSubject(titleMail, "utf-8");
//        mimeMessage.setText(body, "utf-8", "html");
//        mimeMessage.setReplyTo(mimeMessage.getFrom());
//        // gửi mail
//        Transport.send(mimeMessage);
//        return true;
//    }
}
