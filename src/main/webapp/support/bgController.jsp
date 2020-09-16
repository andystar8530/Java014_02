<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員設定</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/data/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css ">
<!-- Custom styles for this template -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/support/css/bgMain.css">

</head>
<body>

	<!-- onLoad="setFocusToUserId()"不知道是什麼 -->
	<c:set var="funcName" value="REG" scope="session" />
	<jsp:include page="/fragment/topMVC.jsp" />
	<h1 class="mt-4 mb-3">
		後台 <small>管理員設定</small>
	</h1>

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a
			href="${pageContext.request.contextPath}/">首頁</a></li>
		<li class="breadcrumb-item active">設定</li>
	</ol>
	<!-- 引入共同的頁首 -->
	<div class="bgMainDiv container">
		<jsp:include page="/support/supFragment/bgNavbar.jsp" />
		<div class="bgMainGalleryDiv">
			<!-- 		方案內容建立位置-------------- -->
			<div class="list-group-item">sadasd</div>
			<div class="list-group-item">sadasd</div>
			<div class="list-group-item">sadasd</div>
			<div class="list-group-item">sadasd</div>
			<div class="list-group-item">sadasd</div>
			<div class="list-group-item">sadasd</div>
			<div class="list-group-item">sadasd</div>
			<div class="list-group-item">sadasd</div>
			<!-- 		方案內容結束---------------- -->
		</div>
	</div>

	<jsp:include page="/support/supFragment/bgFooter.jsp" />
	<script src="${pageContext.request.contextPath}/data/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/data/js/bootstrap.bundle.min.js"></script>
</body>
</html>