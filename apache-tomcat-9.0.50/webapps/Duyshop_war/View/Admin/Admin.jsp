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
                <jsp:include page="/Component/Admin/Container_index.jsp">
                    <jsp:param name="view" value="${view}"/>
                </jsp:include>
            </div>
        </div>
    </div>
    <%@include file="/Component/Admin/Adminscrift.jsp"%>
    </body>
</html>