<%--
  Created by IntelliJ IDEA.
  User: Duy Duc
  Date: 7/25/2021
  Time: 2:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>product</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta content="Responsive bootstrap 4 admin template" name="description">
  <meta content="Coderthemes" name="author">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- App favicon -->
  <!-- App css -->

  <link href="<c:url value="/Template/Admin/assets/libs/sweetalert2/sweetalert2.min.css"/>" rel="stylesheet" type="text/css">
  <link href="<c:url value="/Template/Admin/assets/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" id="bootstrap-stylesheet">
  <link href="<c:url value="/Template/Admin/assets/css/icons.min.css"/>" rel="stylesheet" type="text/css">
  <link href="<c:url value="/Template/Admin/assets/css/app.min.css"/>" rel="stylesheet" type="text/css" id="app-stylesheet">
</head>
<body>
<div id="wrapper">
  <%@include file="/Component/Admin/Navbar.jsp"%>
  <%@include file="/Component/Admin/Sidebar.jsp"%>
  <div class="content-page">
    <div class="content mx-2 my-5">
      <div class="col-md-12">
        <div>
          <table class="table table-warning table-hover table-sm">
            <tr>
              <th>STT</th>
              <th>Tên khách hàng</th>
              <th>Nhân viên</th>
              <th>Địa chỉ</th>
              <th>Số điện thoại</th>
              <th>Giá tiền</th>
              <th>Trạng thái</th>
              <th>Chi tiết</th>
            </tr>
            <tbody>
            <c:forEach var="item" items="${lst}">
              <tr>
                <td>${a =a +1}</td>
                <td>${item.customerName}</td>
                <td>${item.staff.name}</td>
                <td>${item.customerAddress}</td>
                <td>${item.customerPhone}</td>
                <td>${item.amouttotal}</td>
                <td>Đã xác nhận</td>
                <td><a href="<c:url value="/admin/infortrans?id=${item.id}"/>">Chia tiết</a></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>

<%@include file="/Component/Admin/Adminscrift.jsp"%>
</body>
</html>
