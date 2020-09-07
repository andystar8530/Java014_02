<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="memberService" class="ch01_h_register.service.MemberService" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<c:if test="${empty LoginOK}">
		<c:set var="target" value="${pageContext.request.servletPath}" scope="session"/>
		<c:redirect url="/ch02_login/login.jsp"/>
	</c:if>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>合作商管理頁面</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/modern-business.css" rel="stylesheet">
<link rel="stylesheet" href="css/marryMa.css">
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js'></script>
<script src="js/partner.js"></script>
</head>

<body>

	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-light bg-pink fixed-top">
		<div class="container">
			<img src="./Image/2020-08-11/2020-08-11_v1.0.png" width="50"
				style="display: inline;"> <a class="navbar-brand"
				href="index.html">姻緣聚繪</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">婚禮佈置</a></li>
					<li class="nav-item"><a class="nav-link" href="#">婚禮攝影</a></li>
					<li class="nav-item"><a class="nav-link" href="#">新娘秘書</a></li>
					<li class="nav-item"><a class="nav-link" href="#">婚禮主持</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownCart"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							小物商城 </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="#">商品列表</a> <a
								class="dropdown-item" href="#">喜愛商品</a> <a class="dropdown-item"
								href="blog-post.html">購物車</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							社群分享 </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="#">分享討論區</a> <a
								class="dropdown-item" href="#">商家評價</a>
						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownPages"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							平台說明 </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownPages">
							<a class="dropdown-item" href="#">關於本站</a> <a
								class="dropdown-item" href="#">最新公告</a> <a class="dropdown-item"
								href="#">服務條款</a> <a class="dropdown-item" href="#">隱私權說明</a> <a
								class="dropdown-item" href="#">免責聲明</a> <a class="dropdown-item"
								href="#">問題回報</a>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="#">會員登入</a></li>
					<li class="nav-item"><a class="nav-link" href="#">註冊</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">
			新人 <small>管理頁面</small>
		</h1>

		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="index.html">首頁</a></li>
			<li class="breadcrumb-item active">新人資料</li>
		</ol>

		<!-- Content Row -->
		<div class="row">
			<!-- Sidebar Column -->
			<div class="col-lg-3 mb-4">
				<div class="list-group">
					<div class="list-group-item href="#" >
						<img src="./Image/duck.jpg" width="80" style="border-radius: 50%;"
							id="partner-icon">
						<div>會員-可達鴨</div>

					</div>
					<a href="./partner.htmlM,O99L" class="list-group-item"><img
						src="icon/3253474-wedding/png/007-house.png">基本資料 <a
						class="list-group-item"><img
							src="icon/3253474-wedding/png/015-picture.png">我的婚禮</a> <a
						class="list-group-item"><img
							src="icon/3253474-wedding/png/034-marriage certification.png">我要詢價

					</a> <a class="list-group-item list-group-1"><img
							src="icon/3253474-wedding/png/001-clipboard.png">我的討論區 </a> <a
						class="list-group-item list-group-2"><img
							src="icon/3253474-wedding/png/027-wedding invitation.png">我的收藏
							> </a> <a class="list-group-item" href="index.html"><img
							src="icon/3253474-wedding/png/025-calendar.png">回首頁</a>
				</div>
			</div>
			<!-- Content Column -->
			<div class="col-lg-9 mb-4">
				<h2>基本資料&nbsp</h2>
				<a href="newlywedInfo.jsp"><img src="icon/document.png"
					width="30" class="editInfo"></a>
				<div class="newlyWed">會員號碼 :  <span>${LoginOK.m_NO}</span></div>
				<div class="newlyWed">Email(信箱) :  <span>${LoginOK.m_ID}</span></div>
				<div class="newlyWed">手機號碼 :  <span>${LoginOK.m_PHONE}</span></div>
				<div class="newlyWed">真實姓名 :  <span>${LoginOK.m_NAME}</span></div>
				<div class="newlyWed">聯絡時間 :  <span>${LoginOK.m_AVAILABLETIME}</span></div>

			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-pink">
		<div class="container">
			<p class="m-0 text-center text-dark">Copyright &copy; Your
				Website 2020</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>

</body>

</html>
