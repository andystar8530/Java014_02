<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商城</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/data/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css ">
<!-- Custom styles for this template -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/data/css/bgMain.css">

</head>
<body>

	<!-- onLoad="setFocusToUserId()"不知道是什麼 -->
	<c:set var="funcName" value="REG" scope="session" />
	<jsp:include page="/fragment/topMVC.jsp" />
	<h1 class="mt-4 mb-3">
		後台 <small>商城管理</small>
	</h1>
	<div class="RGB">
		<!-- 	選擇紐 -->
		<div>
			<!-- 		<ol class="breadcrumb"> -->
			<!-- 			<li class="breadcrumb-item"><a -->
			<%-- 				href="${pageContext.request.contextPath}/">首頁</a></li> --%>
			<!-- 			<li class="breadcrumb-item active">商城管理</li> -->
			<!-- 			<li>商城管理</li> -->
			<!-- 			<li>商城管理</li> -->
			<!-- 			<li>商城管理</li> -->
			<!-- 			<div>asdasdas</div> -->
			<!-- 			<a>1111111111111</a> -->
			<!-- 		</ol> -->

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarTogglerDemo02"
					aria-controls="navbarTogglerDemo02" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link" href="#">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item"><a class="nav-link disabled" href="#"
							tabindex="-1" aria-disabled="true">Disabled</a></li>
					</ul>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
				</div>
			</nav>
		</div>
		<!-- 	選擇紐結束 -->
		<!-- 引入共同的頁首 -->
		<div class="bgMainDiv container">
			<jsp:include page="/support/supFragment/bgNavbar.jsp" />
			<div class="bgMainGalleryDiv">
				<!-- 		內容建立位置-------------- -->
				<div class="list-group-item">sadasd</div>
				<div class="list-group-item">sadasd</div>
				<div class="list-group-item">sadasd</div>
				<div class="list-group-item">sadasd</div>
				<div class="list-group-item">sadasd</div>
				<div class="list-group-item">sadasd</div>
				<div class="list-group-item">sadasd</div>
				<div class="list-group-item">sadasd</div>
				<!-- 		內容結束---------------- -->
			</div>
		</div>
		<!-- 	尾端選擇按鈕 -->
		<div>
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-end">
					<li class="page-item disabled"><a class="page-link" href="#"
						tabindex="-1" aria-disabled="true">Previous</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<!-- 	尾端選擇按鈕結束 -->
	<jsp:include page="/support/supFragment/bgFooter.jsp" />
	<script src="${pageContext.request.contextPath}/data/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/data/js/bootstrap.bundle.min.js"></script>
</body>
</html>