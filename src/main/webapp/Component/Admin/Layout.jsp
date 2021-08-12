<%--
  Created by IntelliJ IDEA.
  User: Duy Duc
  Date: 7/25/2021
  Time: 2:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<!-- Begin page -->
<div id="wrapper">


  <!-- Topbar Start -->

  <!-- end Topbar --> <!-- ========== Left Sidebar Start ========== -->
  <%@include file="Sub/Sidebar.jsp"%>
  <!-- Left Sidebar End -->
  <%@include file="Sub/Navbar.jsp"%>
  <!-- ============================================================== -->
  <!-- Start Page Content here -->
  <!-- ============================================================== -->

  <div class="content-page">
    <div class="content">

      <!-- Start Content-->
      <!-- end container-fluid -->

    </div>

  </div>


</div>
<!-- END wrapper -->


<!-- Right Sidebar -->


<!-- Vendor js -->
<script src="<c:url value="/View/Admin/assets/js/vendor.min.js"/>"></script>
<script src="<c:url value="/View/Admin/assets/libs/moment/moment.min.js"/>"></script>
<script src="<c:url value="/View/Admin/assets/libs/jquery-scrollto/jquery.scrollTo.min.js"/>"></script>
<script src="<c:url value="/View/Admin/assets/libs/sweetalert2/sweetalert2.min.css"/>"></script>
<script src="<c:url value="/View/Admin/assets/js/pages/jquery.chat.js"/>"></script>
<!-- Todo app -->
<script src="<c:url value="/View/Admin/assets/js/pages/jquery.todo.js"/>"></script>
<!--Morris Chart-->
<script src="<c:url value="/View/Admin/assets/libs/morris-js/morris.min.js"/>"></script>
<script src="<c:url value="/View/Admin/assets/libs/raphael/raphael.min.js"/>"></script>
<!-- Sparkline charts -->
<script src="<c:url value="/View/Admin/assets/js/pages/sparkline.init.js"/>"></script>
<!-- Dashboard init JS -->
<script src="<c:url value="/View/Admin/assets/js/pages/dashboard.init.js"/>"></script>
<script src="<c:url value="/View/Admin/assets/js/app.min.js"/>"></script>
</body>
