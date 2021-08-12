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
  <jsp:include page="/Component/Admin/Sidebar.jsp">
    <jsp:param name="lstcata" value="${lstcata}"/>
  </jsp:include>
  <div class="content-page">
    <div class="content mx-2 my-5">
      <div class="col-md-12">
        <form enctype="multipart/form-data" action="" method="post">
          <div class="row">
            <div class="col">
              <div class="form-group">
                <label>Tên sản phẩm</label>
                <input value="${bean.name}" type="text" required name="name" class="form-control" placeholder="">
              </div>
              <div class="form-group">
                <label>Loại sản phẩm</label>
                <select name="cataid" class="form-control">
                  <c:forEach var="cata" items="${lstcatalog}">
                    <option value="${cata.id}">${cata.name}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="form-group">
                <label>Nội dung</label>
                <textarea value="${bean.content}" name="content" class="form-control"></textarea>
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label>Giá gốc</label>
                <input value="${bean.price}" type="number" required min="1" name="price" class="form-control" placeholder="">
              </div>
              <div class="form-group">
                <label>Khuyến mại</label>
                <input value="${bean.discount}" type="number" required  min="0" name="discount" class="form-control" placeholder="">
              </div>
              <div class="form-group">
                <label>Số lượng</label>
                <input value="${bean.quanlity}" type="number" required  min="0" name="quanlity" class="form-control" placeholder="">
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label>Hình ảnh 1</label>
                <input type="file"  name="img1" class="form-control">
              </div>
              <div class="form-group">
                <label>Hình ảnh 2</label>
                <input  type="file"   name="img2" class="form-control">
              </div>
              <div class="form-group">
                <label>Hình ảnh 3</label>
                <input type="file"   name="img3" class="form-control">
              </div>
            </div>
          </div>
          <div class="col-md-12 py-2 m-auto" style="text-align: center">
            <div class="form-group">
              <button type="submit" class= "rounded bg-success text-light px-3 py1">Thay đổi</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

<%@include file="/Component/Admin/Adminscrift.jsp"%>
</body>
</html>
