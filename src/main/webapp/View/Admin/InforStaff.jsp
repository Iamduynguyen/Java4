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
      <div class="container rounded" style="background-color: lavender">
        <form method="post" enctype="multipart/form-data" class="row mx-auto my-5">
          <div class="col-md-4 my-4">
            <div style="background-color: lavender" class="col-md-12 mx-2 py-2">
              <c:if test="${bean.image==null}">
                <img width="230px" src="https://nhadatnhontrach.vn/no-avatar.jpg"/>
              </c:if>
              <c:if test="${bean.image!=null}">
                <img width="230px" src="<c:url value="/image/${bean.image}"/>"/>
              </c:if>
              <input type="file" name="images" class="form-control my-3">
            </div>
          </div>
          <div class="col-md-8">
            <div class="" style="background-color: lavender">
              <div  class="my-4">
                <div class="form-group row">
                  <label for="staticEmail" class="col-sm-2 col-form-label font-weight-bold">Email:</label>
                  <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext w-100" id="staticEmail" value="${bean.email}">
                  </div>
                </div>
                <div class="form-group row">
                  <label  class="col-sm-2 col-form-label font-weight-bold">Họ và tên:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" value="${bean.name}">
                  </div>
                </div>
                <div class="form-group row">
                  <label  class="col-sm-2 col-form-label font-weight-bold">Số điện thoại:</label>
                  <div class="col-sm-10">
                    <input type="text" name="phone" value="${bean.phone}" class="form-control" >
                  </div>
                </div>
                <div class="form-group row">
                  <label  class="col-sm-2 col-form-label font-weight-bold">Đối mật khẩu:</label>
                  <div class="col-sm-10">
                    <input onclick="openSetpass()" name="checksetpass" style="width: 20px;height: 20px;margin-top: 20px" type="checkbox" >
                  </div>
                </div>
                <div class="row" id="pass" style="display: none">
                  <div class="col-md-3">
                    <label >Mật khẩu cũ:</label>
                      <input type="password" name="oldpass" class="form-control" >
                  </div>
                  <div class="col-md-3">
                    <label >Mật khẩu mới:</label>
                      <input type="password" name="newpass" class="form-control" >
                  </div>
                </div>
                <div class="row">
                  <button type="submit" class="form-group bg-info col-md-4 mx-2 py-2"> Cập nhật</button>
                </div>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<script>
  var x =1;
  function openSetpass(){
    if (x==1){
      x=0;
      console.log("cc")
      document.getElementById("pass").style.display = "block"
    }else {
      x=1;
      console.log("shit")
      document.getElementById("pass").style.display = "none"
    }
  }
</script>
<%@include file="/Component/Admin/Adminscrift.jsp"%>
</body>
</html>
