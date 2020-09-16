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
	href="${pageContext.request.contextPath}/support/css/bgMain.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/support/css/bgMall.css">
</head>
<body>

	<!-- onLoad="setFocusToUserId()"不知道是什麼 -->
	<c:set var="funcName" value="REG" scope="session" />
	<jsp:include page="/fragment/topMVC.jsp" />
	<h1 class="mt-4 mb-3">
		後台 <small>商城管理</small>
	</h1>
	<!-- container -->
	<div class="bgMallAllDiv container ">
		<!-- 	asasaas -->
		<!-- 	選擇紐 -->
		<div class="bgMallNavDiv d-flex justify-content-end ">
			<div class=" bd-highlight ">
				<div class="bgMallSearchNavDiv nav ">
					<div class="SearchDiv1 nav-item text-center border border-primary">
						<a class="nav-link " href="#">Active</a>
					</div>
					<div
						class="SearchDiv2 nav-item text-center border border-primary border-left-0">
						<a class="nav-link " href="#">篩選</a>
					</div>
					<div
						class="SearchDiv3 nav-item text-center border border-primary border-left-0">
						<a class="nav-link " href="#">新增</a>
					</div>
					<div
						class="SearchDiv4 nav-item text-center border border-primary border-left-0">
						<a class="nav-link " href="${pageContext.request.contextPath}/support/bgMall/bgMallAdd.jsp">新增</a>
					</div>
				</div>
			</div>
			<div class="SearchDiv5 bd-highlight">
				<form class="form-inline my-2 my-lg-0 ">
					<input class="form-control mr-sm-2" type="search"
						placeholder="品名/種類/金額" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</div>
		<!-- 	選擇紐結束 -->
		<!-- 		<hr> -->
		<!-- 引入共同的頁首 -->
		<div class="bgMainDiv container ">
			<jsp:include page="/support/supFragment/bgNavbar.jsp" />
			<div class="bgMainGalleryDiv row ">
				<!-- 		內容建立位置-------------- -->
				<div
					class="bgMainGalleryDivIn container my-2 d-flex align-items-center justify-content-around ">
					<div class="bgMainGalleryDivIn1 border border-primary d-flex align-items-center row">
						<div>標籤號碼</div>
						<div>銷售數量</div>
					</div>
					<div
						class="bgMainGalleryDivIn2 border border-primary border-left-0 d-flex align-items-center row">
						<img src="https://loremflickr.com/80/80" />
					</div>
					<div
						class="bgMainGalleryDivIn3 border border-primary border-left-0 d-flex align-items-center row">
						<div>標題</div>
						<div>內容(擷取20字)</div>
					</div>
					<div
						class="bgMainGalleryDivIn4 border border-primary border-left-0  d-flex align-items-center row">
						<div>創建日期</div>
						<div>最後修改日期</div>
					</div>

				</div>

				<!-- 		內容結束---------------- -->
			</div>
		</div>

		<!-- 	尾端選擇按鈕 -->
		<div class="bgEndNav mt-auto p-2 bd-highlight">
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