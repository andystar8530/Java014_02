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

<title>後台管理頁面</title>

<!-- Bootstrap core CSS -->
<link href="../_newlyWed/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../_newlyWed/css/modern-business.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/support/css/bgNavbar.css"
	rel="stylesheet">
</head>

<body>
	<!-- Content Row -->
	<!-- 	mb-4 list-group -->
	<div class="bgbar row col-md-auto list-group ">
		<a class="list-group-item "
			href="${pageContext.request.contextPath}/support/bgController.jsp">
			<img src="./Image/duck.jpg" width="80" style="border-radius: 50%;"
			id="partner-icon">
			後台-可達鴨 尼好

		</a> <a class="list-group-item"
			href="${pageContext.request.contextPath}/support/bgMain.jsp"> <img
			src="icon/3253474-wedding/png/007-house.png">方案/作品
		</a> <a class="list-group-item"
			href="${pageContext.request.contextPath}/support/bgReport.jsp"> <img
			src="icon/3253474-wedding/png/015-picture.png">會員/文章
		</a> <a class="list-group-item"
			href="${pageContext.request.contextPath}/support/bgMall/bgMall.jsp">
			<img src="icon/3253474-wedding/png/034-marriage certification.png">商城商品

		</a> <a class="list-group-item list-group-1"
			href="${pageContext.request.contextPath}/support/bgArticleEdit.jsp">
			<img src="icon/3253474-wedding/png/001-clipboard.png">公版文管理
		</a>
	</div>


	<!-- Bootstrap core JavaScript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>

</body>

</html>
