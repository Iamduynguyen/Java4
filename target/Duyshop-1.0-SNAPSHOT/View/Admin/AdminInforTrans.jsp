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
    <h2 class="mx-auto mt-5">Chi tiết hóa đơn</h2>
    <div class="content mx-2 my-5 py-3 row">
      <div class="col row rounded" style="background-color: white">
        <c:forEach var="pro" items="${lst}">
          <div class="col mx-2 rounded px-1 py-1 mx-3 my-3" style="width: 120px;height: 150px">
            <a href="<c:url value="/infor/?id=${pro.id}"/>">
              <div class="row">
                <img width="100" src="<c:url value="/image/${pro.product.img1}"/>"/>
              </div>
              <div>
                <p  style="color: #ff0080">${pro.product.name}</p>
                <p style="color: blue">${pro.product.price-pro.product.discount} vnd</p>
                <p style="color: blue">Số lượng :${pro.quanlity}</p>
              </div>
            </a>
          </div>
        </c:forEach>
      </div>
      <div class="col rounded" style="background-color: white">
        <form method="post" class="m-3">
          <div class="row form-group">
            <label class="col-md-4">Khách hàng</label>
            <label class="col-md-8">${trans.customerName}</label>
          </div>
          <div class="row form-group">
            <label class="col-md-4">Địa chỉ</label>
            <label class="col-md-8">${trans.customerAddress}</label>
          </div>
          <div class="row form-group">
            <label class="col-md-4">Số điện thoại</label>
            <label class="col-md-8">${trans.customerPhone}</label>
          </div>
          <div class="row form-group">
            <label class="col-md-4">Giá tiền</label>
            <label class="col-md-8">${trans.amouttotal}</label>
          </div>
          <div class="row form-group">
            <label class="col-md-4">Trạng thái</label>
            <c:if test="${trans.status==2}">
              <label class="col-md-4">Chờ xác nhận</label>
            </c:if>
            <c:if test="${trans.status==3}">
              <label class="col-md-4">Đã xác nhận</label>
            </c:if>
          </div>
          <div class="row form-group">
            <c:if test="${trans.status==2}">
              <button type="submit" name="confirm" value="yes" class="col-md-6 bg-primary">Xác nhân</button>
              <button type="submit" name="confirm" value="no" class="col-md-6 bg-danger">Hủy</button>
            </c:if>
            <c:if test="${trans.status==3}">
              <label class="col-md-4">Nhân viên</label>
              <label class="col-md-8">${trans.staff.name}</label>
            </c:if>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="/Component/Admin/Adminscrift.jsp"%>
</body>
</html>