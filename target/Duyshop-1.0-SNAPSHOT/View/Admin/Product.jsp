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
        <div class="content">
            <div class="col-md-12 my-1">
                <table class="table table-warning table-hover table-sm">
                    <tr style="background-color: deeppink">
                        <th style="color: white">STT</th>
                        <th style="color: white">Tên sản phẩm</th>
                        <th style="color: white">Hình ảnh</th>
                        <th style="color: white">Giá gốc</th>
                        <th style="color: white">Khuyến mại</th>
                        <th style="color: white">Lượt xem</th>
                        <th style="color: white">Lượt mua</th>
                        <th style="background-color: greenyellow;text-align: center"><a href="<c:url value="/admin/newproduct"/>" style="color: red;font-size: medium">Tạo mới</a></th>
                    </tr>
                    <tbody>
                    <c:forEach var="pro" items="${lstpro}">
                        <tr>
                            <td>
                                    ${index= index+1}
                            </td>
                            <td>${pro.name}</td>
                            <td><img height="80px" src="<c:url value="/image/${pro.img1}"/>"/></td>
                            <td>${pro.price}</td>
                            <td>${pro.discount}</td>
                            <td>${pro.view}</td>
                            <td>${pro.sold}</td>
                            <td style="text-align: center">
                                   <form method="post">
                                         <a href="<c:url value="/admin/editproduct/?id=${pro.id}"/>"><button type="button"  class="bg-primary">sửa</button></a>
                                         <button value="${id}" id="delete" name="delete" type="submit"  class="bg-danger">xóa</button>
                                  </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tr>
                        <td></td>
                        <td>
                            <a href="<c:url value="/admin/product?cataId=${idcata}&page=${page-1}"/>">
                                <button class="rounded bg-info">Prew</button>
                            </a>
                            <label className="page">${page}</label>
                            <a href="<c:url value="/admin/product?cataId=${idcata}&page=${page+1}"/>">
                                <button class="rounded bg-info">Prew</button>
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="/Component/Admin/Adminscrift.jsp"%>
</body>
</html>
