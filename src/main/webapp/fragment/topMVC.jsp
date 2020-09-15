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
<link rel="shortcut icon" href="${pageContext.request.contextPath}/data/Image/removebg.ico" type="image/x-icon" />
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
<!-- 	wow.js -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/data/css/animate.css">

</head>
<body>
	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-light bg-pink fixed-top">
		<div class="container">
			<img
				src="${pageContext.request.contextPath}/data/Image/removebg.png"
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
					<li class="nav-item"><a class="nav-link  wow fadeInLeft" href="#">婚禮佈置</a></li>
					<li class="nav-item"><a class="nav-link  wow fadeInLeft" href="#">婚禮攝影</a></li>
					<li class="nav-item"><a class="nav-link  wow fadeInLeft" href="#">新娘秘書</a></li>
					<li class="nav-item"><a class="nav-link  wow fadeInLeft" href="#">婚禮主持</a></li>
					<li class="nav-item "><a class="nav-link wow fadeInLeft"
						href="<c:url value='/_03_listProducts/DisplayPageProducts' />">
							小物商城 </a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle wow fadeInLeft" href="#" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							社群分享 </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="#">分享討論區</a> <a
								class="dropdown-item" href="#">商家評價</a>
						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle wow fadeInLeft" href="#" id="navbarDropdownPages"
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
					<c:if test="${empty LoginOK}">
						<li class="nav-item wow fadeInLeft">
							<!--                 如果沒登入才會顯示會員登入按鈕 --> <a class="nav-link"
							href="<c:url value='/ch02_login/login.jsp' />">會員登入</a>
						</li>
						<li class="nav-item wow fadeInLeft">
							<!--        如果沒登入才會顯示註冊按鈕 --> <a class="nav-link"
							href="<c:url value='/ch01_register/quickReg.jsp' />">註冊</a>
						</li>
					</c:if>
					<c:if test="${!empty LoginOK}">
						<c:if test="${LoginOK.m_Code == 0}">
							<li class="nav-item "><a class="nav-link wow fadeInLeft"
								href="${pageContext.request.contextPath}/_newlyWed/newlywed.jsp">新人頁面</a>
							</li>
						</c:if>
						<c:if test="${LoginOK.m_Code == 1}">
							<li class="nav-item"><a class="nav-link wow fadeInLeft"
								href="${pageContext.request.contextPath}/displayPartnerInfo.do">商家頁面</a>
							</li>
						</c:if>
						<c:if test="${LoginOK.m_Code == 2}">
							<li class="nav-item"><a class="nav-link wow fadeInLeft" href="<c:url value='/support/bgMain.jsp' />">管理頁面</a></li>
						</c:if>
						<li class="nav-item"><a class="nav-link wow fadeInLeft"
							href="<c:url value='/_02_login/logout.jsp' />"> 登出 </a></li>

						<li class="nav-item"><img height='40px' width='40px'
							src='${pageContext.request.contextPath}/_00_init/getMemberImage?id=${LoginOK.m_No}'>
						</li>
					</c:if>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
	   <script src="${pageContext.request.contextPath}/data/js/wow.min.js"></script>
    <script>
    new WOW().init();
    </script>
</body>
</html>