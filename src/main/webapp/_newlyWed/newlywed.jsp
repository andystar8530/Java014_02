<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="memberService"
	class="ch01_h_register.service.MemberService" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${empty LoginOK}">
	<c:set var="target" value="${pageContext.request.servletPath}"
		scope="session" />
	<c:redirect url="/ch02_login/login.jsp" />
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
<!-- <link rel="stylesheet" href="css/marryMa.css"> -->
<!-- <script -->
<!-- 	src='https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js'></script> -->
<!-- <script src="js/partner.js"></script> -->
</head>

<body>

	<!-- Navigation -->
	<!-- 引入共同的頁首 -->
	<jsp:include page="/fragment/topMVC.jsp" />

	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">
			新人 <small>管理頁面</small>
		</h1>

		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a
				href="${pageContext.request.contextPath}/">首頁</a></li>
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
					<a href="newlywed.jsp" class="list-group-item"><img
						src="icon/3253474-wedding/png/007-house.png">基本資料 <a
						class="list-group-item"><img
							src="icon/3253474-wedding/png/015-picture.png">我的婚禮</a> <a
						class="list-group-item"><img
							src="icon/3253474-wedding/png/034-marriage certification.png">我要詢價

					</a> <a class="list-group-item list-group-1"><img
							src="icon/3253474-wedding/png/001-clipboard.png">我的討論區 </a> <a
						class="list-group-item list-group-2"><img
							src="icon/3253474-wedding/png/027-wedding invitation.png">我的收藏
							> </a> <a class="list-group-item"
						href="${pageContext.request.contextPath}/"><img
							src="icon/3253474-wedding/png/025-calendar.png">回首頁</a>
				</div>
			</div>
			<!-- Content Column -->
			<div class="col-lg-9 mb-4">
				<h2>基本資料&nbsp</h2>
				<a href="newlywedInfo.jsp"><img src="icon/document.png"
					width="30" class="editInfo"></a>
				<div class="newlyWed">
					會員號碼 : <span>${LoginOK.m_No}</span>
				</div>
				<div class="newlyWed">
					Email(信箱) : <span>${LoginOK.m_Id}</span>
				</div>
				<div class="newlyWed">
					手機號碼 : <span>${LoginOK.m_Phone}</span>
				</div>
				<div class="newlyWed">
					真實姓名 : <span>${LoginOK.m_Name}</span>
				</div>
				<div class="newlyWed">
					聯絡時間 : <span>${LoginOK.m_Availabletime}</span>
				</div>

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
