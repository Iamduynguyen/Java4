<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Quản lý Duyshop</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta content="Responsive bootstrap 4 admin template" name="description">
  <meta content="Coderthemes" name="author">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- App favicon -->
  <link rel="shortcut icon" href="assets\images\favicon.ico">

  <!-- Plugins css-->
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
    <div class="content mx-2 my-5 py-3 row">
      <div class="col" style="background-color: lavender">
        <h2 class="mx-auto">Danh sách nhân viên</h2>
        <table class="table table-warning table-hover table-sm">
          <tr>
            <th>STT</th>
            <th>Họ và tên</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Hình ảnh</th>
            <th></th>
          </tr>
          <tbody>
            <c:forEach var="staff" items="${lststaff}">
                <tr>
                  <td>${index=index+1}</td>
                  <td>${staff.name}</td>
                  <td>${staff.email}</td>
                  <td>${staff.phone}</td>
                  <td><img width="50px" src="<c:url value="/image/${staff.image}"/>"></td>
                  <td><a href="<c:url value="/admin/staff?lock=${staff.id}"/>">Khóa</a></td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="col" style="background-color: lavender">
        <h2 class="mx-auto">Thêm nhân viên mới</h2>
        <table class="table table-warning table-hover table-sm">
          <tr>
            <th>STT</th>
            <th>Họ và tên</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Hình ảnh</th>
            <th></th>
          </tr>
          <tbody>
          <c:forEach var="staff" items="${lstno}">
            <tr>
              <td>${index=index+1}</td>
              <td>${staff.name}</td>
              <td>${staff.email}</td>
              <td>${staff.phone}</td>
              <td><img width="50px" src="<c:url value="/image/${staff.image}"/>"></td>
              <td><a href="<c:url value="/admin/staff?active=${staff.id}"/>">Thêm</a></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<%@include file="/Component/Admin/Adminscrift.jsp"%>
</body>
</html>