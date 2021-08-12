<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html lang="zxx">
<head>
    <!-- Meta Tag -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name='copyright' content='pavilan'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title Tag  -->
    <title>DuyShop Thương hiệu đồng hồ hàng đầu Việt nam</title>

    <!-- Favicon -->
    <link rel="icon" type="image/favicon.png" href="data:image/png;base64,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">

    <!-- Web Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
        .label{
            font-weight: bold;
        }
    </style>
    <!-- Bizwheel Plugins CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/Template/Website/css/bootstrap.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/Template/Website/css/animate.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/Template/Website/style.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/Template/Website/css/cubeportfolio.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/Template/Website/css/font-awesome.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/Template/Website/css/jquery.fancybox.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/Template/Website/css/magnific-popup.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/Template/Website/css/owl-carousel.min.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/Template/Website/css/responsive.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/Template/Website/css/reset.css"/> ">
</head>
<body id="bg">
<!-- Boxed Layout -->
<div id="page" class="site boxed-layout">

    <!-- Preloader -->
    <div class="preeloader">
        <div class="preloader-spinner"></div>
    </div>
    <!--/ End Preloader -->
    <jsp:include page="/Component/Website/Header.jsp">
        <jsp:param name="name" value="${cus.name}"/>
        <jsp:param name="img" value="${cus.image}"/>
    </jsp:include>

    <div class="container rounded" style="background-color: lavender">
        <form method="post" enctype="multipart/form-data" class="row mx-auto my-5">
            <div class="col-md-4 my-4">
                <div style="background-color: lavender" class="col-md-12 mx-2 py-2">
                    <c:if test="${bean.image==null}">
                        <img width="300px" src="https://nhadatnhontrach.vn/no-avatar.jpg"/>
                    </c:if>
                    <c:if test="${bean.image!=null}">
                        <img src="<c:url value="/image/${bean.image}"/>"/>
                    </c:if>
                    <input type="file" name="images" class="form-control my-3">
                    <label class="form-control">Rank ${showrank}: </label>
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
                            <label  class="col-sm-2 col-form-label font-weight-bold">Địa chỉ:</label>
                            <div class="col-sm-10">
                                <input type="text" name="address" value="${bean.address}" class="form-control" >
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
                        <div class="form-group row" style="display: none" id="oldpass">
                            <label  class="col-sm-2 col-form-label font-weight-bold">Mật khẩu cũ:</label>
                            <div class="col-sm-9">
                                <input type="password" name="opass" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group row" style="display: none" id="newpass">
                            <label  class="col-sm-2 col-form-label font-weight-bold">Mật khẩu mới:</label>
                            <div class="col-sm-9">
                                <input type="password" name="newpass" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group row" style="display: none" id="repass">
                            <label  class="col-sm-2 col-form-label font-weight-bold">Nhập lại:</label>
                            <div class="col-sm-9">
                                <input type="password" name="repass" class="form-control" >
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

    <%@include file="/Component/Website/Footer.jsp"%>
</div>
    <script>
        var x =1;
        function openSetpass(){
            if (x==1){
                x=0;
                console.log("cc")
                document.getElementById("repass").style.display = "block"
                document.getElementById("newpass").style.display = "block"
                document.getElementById("oldpass").style.display = "block"
            }else {
                x=1;
                console.log("shit")
                document.getElementById("repass").style.display = "none"
                document.getElementById("newpass").style.display = "none"
                document.getElementById("oldpass").style.display = "none"
            }
        }
    </script>
<!-- Jquery JS -->
<script src="<c:url value="/Template/Website/js/waypoints.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/jquery.counterup.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/jquery.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/jquery-migrate-3.0.0.js"/>"></script>
<script src="<c:url value="/Template/Website/js/popper.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/modernizr.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/jquery-fancybox.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/scrollup.js"/>"></script>
<script src="<c:url value="/Template/Website/js/cubeportfolio.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/slicknav.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/owl-carousel.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/easing.js"/>"></script>
<script src="<c:url value="/Template/Website/js/magnific-popup.min.js"/>"></script>
<script src="<c:url value="/Template/Website/js/active.js"/>"></script>
<script src="<c:url value="/Component/Alert/sweetalert2.all.min.js"/>"></script>
<script src="<c:url value="/Component/Alert/sweetalert2.min.js"/>"></script>
</body>
</html>