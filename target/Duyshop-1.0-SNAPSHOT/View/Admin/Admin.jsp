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
            <div class="content mx-2 my-5">
                <div class="container-fluid">

                    <!-- start page title -->
                    <div class="row">
                        <div class="col-12">
                            <div class="page-title-box">
                                <h4 class="page-title">Welcome !</h4>
                                <div class="page-title-right">
                                    <ol class="breadcrumb p-0 m-0">
                                        <li class="breadcrumb-item"><a href="#">Velonic</a></li>
                                        <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Dashboard 1</li>
                                    </ol>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <!-- end page title -->

                    <div class="row">
                        <div class="col-xl-3 col-sm-6">
                            <div class="card bg-pink">
                                <div class="card-body widget-style-2">
                                    <div class="text-white media">
                                        <div class="media-body align-self-center">
                                            <h2 class="my-0 text-white"><span data-plugin="counterup">${view}</span></h2>
                                            <p class="mb-0">Lượt truy cập</p>
                                        </div>
                                        <i class="ion-md-eye"></i>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-3 col-sm-6">
                            <div class="card bg-purple">
                                <div class="card-body widget-style-2">
                                    <div class="text-white media">
                                        <div class="media-body align-self-center">
                                            <h2 class="my-0 text-white"><span data-plugin="counterup">${trans}</span></h2>
                                            <p class="mb-0">Số đơn hàng</p>
                                        </div>
                                        <i class="ion-md-paper-plane"></i>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-3 col-sm-6">
                            <div class="card bg-info">
                                <div class="card-body widget-style-2">
                                    <div class="text-white media">
                                        <div class="media-body align-self-center">
                                            <h2 class="my-0 text-white"><span data-plugin="counterup">${cus}</span></h2>
                                            <p class="mb-0">Số khách hàng</p>
                                        </div>
                                        <i class="ion-ios-pricetag"></i>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-3 col-sm-6">
                            <div class="card bg-primary">
                                <div class="card-body widget-style-2">
                                    <div class="text-white media">
                                        <div class="media-body align-self-center">
                                            <h2 class="my-0 text-white"><span data-plugin="counterup">${pro}</span></h2>
                                            <p class="mb-0">Số sản phẩm</p>
                                        </div>
                                        <i class="mdi mdi-comment-multiple"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            <h2>Top 5 sản phẩm view cao nhất</h2>
                            <table class="table table-warning table-hover table-sm">
                                <tr style="background-color: lightblue">
                                    <th>STT</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Loại sản phẩm</th>
                                    <th>Giá tiền</th>
                                    <th>View</th>
                                </tr>
                                <tbody>
                                    <c:forEach var="pro" items="${lstview}">
                                        <tr>
                                            <td>${a = a+1}</td>
                                            <td>${pro.name}</td>
                                            <td>${pro.catalog.name}</td>
                                            <td>${pro.price}</td>
                                            <th>${pro.view}</th>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="col">
                            <h2>Top 5 sản phẩm bán nhiều nhất</h2>
                            <table class="table table-warning table-hover table-sm">
                                <tr style="background-color: lightblue">
                                    <th>STT</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Loại sản phẩm</th>
                                    <th>Giá tiền</th>
                                    <th>Đã bán</th>
                                </tr>
                                <tbody>
                                <c:forEach var="pro" items="${lstsold}">
                                    <tr>
                                        <td>${b = b+1}</td>
                                        <td>${pro.name}</td>
                                        <td>${pro.catalog.name}</td>
                                        <td>${pro.price}</td>
                                        <th>${pro.sold}</th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
    <%@include file="/Component/Admin/Adminscrift.jsp"%>
    </body>
</html>