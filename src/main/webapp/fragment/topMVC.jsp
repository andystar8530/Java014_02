<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>姻緣聚繪</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/data/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css ">

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/data/css/modern-business.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/data/css/marryMa.css">

</head>
<body>
	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-light bg-pink fixed-top">
		<div class="container">
			<img
				src="${pageContext.request.contextPath}/data/Image/2020-08-11/2020-08-11_v1.0.png"
				width="50" style="display: inline;"> <a class="navbar-brand"
				href="/Java014_02/index.jsp">姻緣聚繪</a>
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
					<li class="nav-item "><a class="nav-link "
						href="<c:url value='/_03_listProducts/DisplayPageProducts' />"> 小物商城 </a></li>
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
					<li class="nav-item"><c:if test="${empty LoginOK}">
							<!--                 如果沒登入才會顯示會員登入按鈕 -->
							<a class="nav-link" href="<c:url value='/_02_login/login.jsp' />">會員登入</a>
						</c:if></li>
					<li class="nav-item"><c:if test="${empty LoginOK}">
							<!--        如果沒登入才會顯示註冊按鈕 -->
							<a class="nav-link"
								href="<c:url value='/_01_register/register.jsp' />">註冊</a>
						</c:if></li>
					<li class="nav-item"><c:if test="${!empty LoginOK}">
							<a class="nav-link"
								href="${pageContext.request.contextPath}/displayPartnerInfo.do">商家頁面</a>
						</c:if></li>

					<li class="nav-item"><c:if test="${ ! empty LoginOK }">
							<a class="nav-link"
								href="<c:url value='/_02_login/logout.jsp' />"> 登出 </a>
						</c:if></li>

					<li class="nav-item"><c:if test="${! empty LoginOK }">
							<img height='40px' width='40px'
								src='${pageContext.request.contextPath}/_00_init/getMemberImage?id=${LoginOK.m_No}'>

						</c:if></li>
				</ul>
			</div>
		</div>
	</nav>



	<!-- Bootstrap core JavaScript -->
	<script src="${pageContext.request.contextPath}/data/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/data/js/bootstrap.bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/data/js/marry.js"></script>
	<script src="${pageContext.request.contextPath}/data/js/partner.js"></script>
</body>
</html>