<%--
  Created by IntelliJ IDEA.
  User: Duy Duc
  Date: 7/25/2021
  Time: 2:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div class="right-bar">
<div class="rightbar-title">
  <a href="javascript:void(0);" class="right-bar-toggle float-right">
    <i class="mdi mdi-close"></i>
  </a>
  <h4 class="font-17 m-0 text-white">Theme Customizer</h4>
</div>
<div class="slimscroll-menu">

<div class="p-4">
<div class="alert alert-warning" role="alert">
  <strong>Customize </strong> the overall color scheme, layout, etc.
</div>
<div class="mb-2">
  <img src="assets\images\layouts\light.png" class="img-fluid img-thumbnail" alt="">
</div>
<div class="custom-control custom-switch mb-3">
  <input type="checkbox" class="custom-control-input theme-choice" id="light-mode-switch" checked="">
  <label class="custom-control-label" for="light-mode-switch">Light Mode</label>
</div>

<div class="mb-2">
<img src="<c:url value="/View/Admin/assets/images/logo-dark.png">" class="img-fluid img-thumbnail" alt="">
  </div>
  <div class="custom-control custom-switch mb-3">
  <input type="checkbox" class="custom-control-input theme-choice" id="dark-mode-switch"
  data-bsstyle="assets/css/bootstrap-dark.min.css" data-appstyle="assets/css/app-dark.min.css">
  <label class="custom-control-label" for="dark-mode-switch">Dark Mode</label>
  </div>

  <div class="mb-2">
  <img src="assets\images\layouts\rtl.png" class="img-fluid img-thumbnail" alt="">
  </div>
  <div class="custom-control custom-switch mb-5">
  <input type="checkbox" class="custom-control-input theme-choice" id="rtl-mode-switch"
  data-appstyle="assets/css/app-rtl.min.css">
  <label class="custom-control-label" for="rtl-mode-switch">RTL Mode</label>
  </div>

  </div>
  </div> <!-- end slimscroll-menu-->
  </div>
</body>
