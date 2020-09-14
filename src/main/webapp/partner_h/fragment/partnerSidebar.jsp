<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/data/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/data/css/modern-business.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/data/css/marryMa.css">
<%--   <link rel="stylesheet" href="${pageContext.request.contextPath}/data/css/animate.css"> --%>
 
</head>
<body>
<!-- Page Content -->
  <div class="container">
    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">店家
      <small>管理頁面</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}">首頁</a>
      </li>
      <li class="breadcrumb-item active">店家管理</li>
    </ol>

    <!-- Content Row -->
    <div class="row">
      <!-- Sidebar Column -->
      <div class="col-lg-3 mb-4">
        <div class="list-group" >
          <div class="list-group-item href="#" >
              <img src="${pageContext.request.contextPath}/_00_init/getMemberImage?id=${LoginOK.m_No}" width="80" style="border-radius: 50%;" id="partner-icon">
              <div>${partnerBean.p_storeName}</div>

          </div>
          <a  class="list-group-item"><img src="${pageContext.request.contextPath}/data/icon/3253474-wedding/png/007-house.png" >基本資料</a>

          <a  class="list-group-item"><img src="${pageContext.request.contextPath}/data/icon/3253474-wedding/png/015-picture.png" >作品集</a>

          <a  class="list-group-item"><img src="${pageContext.request.contextPath}/data/icon/3253474-wedding/png/034-marriage certification.png" >方案管理</a>
            
        
          <a  class="list-group-item list-group-1"><img src="${pageContext.request.contextPath}/data/icon/3253474-wedding/png/001-clipboard.png" >報價合約
           <a class="sidebar-item list-group-open1 wow  bounce"  data-wow-duration="1s"  > 合約範本</a>
            <a class="sidebar-item list-group-open1 wow  bounce" data-wow-duration="1s" >已簽約</a>
            <a class="sidebar-item list-group-open1 wow  bounce" data-wow-duration="1s" >未簽約</a>
          </a>
          <a  class="list-group-item list-group-2  "><img src="${pageContext.request.contextPath}/data/icon/3253474-wedding/png/027-wedding invitation.png" >訂單管理
            <a class="sidebar-item list-group-open2 wow bounce" data-wow-duration="1s"  href="#">我的訂單</a>
            <a class="sidebar-item list-group-open2 wow bounce" data-wow-duration="1s"  href="#">專案成本表</a>
          </a>
          <a  class="list-group-item"><img src="${pageContext.request.contextPath}/data/icon/3253474-wedding/png/025-calendar.png" >行程管理</a>
          <a  class="list-group-item"><img src="${pageContext.request.contextPath}/data/icon/3253474-wedding/png/011-love.png" >來聊聊  &nbsp <span class="badge badge-primary badge-pill" >14</span></a></a>
          <a  class="list-group-item"><img src="${pageContext.request.contextPath}/data/icon/3253474-wedding/png/026-magnifying glass.png" >經營報表</a>
         
        </div>
      </div>
   <script src='https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js'></script>
<%--   <script src="${pageContext.request.contextPath}/data/js/partner.js"></script> --%>
   <script src="${pageContext.request.contextPath}/data/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/data/js/bootstrap.bundle.min.js"></script>
<%--    <script src="${pageContext.request.contextPath}/data/js/wow.min.js"></script> --%>
<!--     <script> -->
<!--      new WOW().init(); -->
<!--     </script> -->
</body>
</html>