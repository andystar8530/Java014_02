
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>


<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>合作商管理頁面</title>

<!-- Bootstrap core CSS -->
<link href="../data/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../data/css/modern-business.css" rel="stylesheet">
<link rel="stylesheet" href="../data/css/marryMa.css">
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js'></script>
<script src="../data/js/partner.js"></script>
</head>

<body>

	<!-- Navigation -->
	<jsp:include page="../fragment/topMVC.jsp" />

	
	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<h1 class="mt-4 mb-3">
			新人 <small>管理頁面</small>
		</h1>

		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="../">首頁</a></li>
			<li class="breadcrumb-item active">新人資料</li>
		</ol>

		<!-- Content Row -->
		<div class="row">
			<!-- Sidebar Column -->
			<div class="col-lg-3 mb-4">
				<div class="list-group">
					<div class="list-group-item href="#" >
						<img src="../data/Image/duck.jpg" width="80" style="border-radius: 50%;"
							id="partner-icon">
						<div>會員-可達鴨</div>

					</div>
					<a href="newlywedInfo.jsp" class="list-group-item"><img
						src="../data/icon/3253474-wedding/png/007-house.png">基本資料 <a
						class="list-group-item"><img
							src="../data/icon/3253474-wedding/png/015-picture.png">我的婚禮</a> <a
						class="list-group-item"><img
							src="../data/icon/3253474-wedding/png/034-marriage certification.png">我要詢價

					</a> <a class="list-group-item list-group-1"><img
							src="../data/icon/3253474-wedding/png/001-clipboard.png">我的討論區 </a> <a
						class="list-group-item list-group-2"><img
							src="../dataicon/3253474-wedding/png/027-wedding invitation.png">我的收藏
							> </a> <a class="list-group-item" href="index.html"><img
							src="../data/icon/3253474-wedding/png/025-calendar.png">回首頁</a>
				</div>
			</div>
			<!-- Content Column -->
			<div class="col-lg-9 mb-4">
				<h2>基本資料&nbsp</h2>
				<form>
					<div class="form-group">
						<label for="formGroupExampleInput">Email(信箱)</label> <input
							type="text" class="form-control" id="formGroupExampleInput"
							placeholder="Your email">
					</div>
					<div class="form-group">
						<label for="formGroupExampleInput">密碼</label> <input type="text"
							class="form-control" id="formGroupExampleInput"
							placeholder="Your password">
					</div>
					<div class="form-group">
						<label for="formGroupExampleInput">身分證</label> <input type="text"
							class="form-control" id="formGroupExampleInput"
							placeholder="Your IDnumber">
					</div>
					<div class="form-group">
						<label for="formGroupExampleInput2">手機號碼</label> <input
							type="text" class="form-control" id="formGroupExampleInput2"
							placeholder="Telephone">
					</div>
					<div class="form-group">
						<label for="formGroupExampleInput2">真實姓名</label> <input
							type="text" class="form-control" id="formGroupExampleInput2"
							placeholder="Name">
					</div>
					<div class="form-group">
						<label for="formGroupExampleInput">您的性別</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox"
							id="inlineCheckbox1" value="option1"> <label
							class="form-check-label" for="inlineCheckbox1">男</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox"
							id="inlineCheckbox2" value="option2"> <label
							class="form-check-label" for="inlineCheckbox2">女</label>
					</div>
					<div class="form-group">
						<label for="formGroupExampleInput2">聯絡時間</label> <select
							class="form-control">
							<option>早上9點到中午12點</option>
							<option>下午1點到晚上6點</option>
							<option>晚上六點到晚上10點</option>
						</select>
					</div>
				</form>


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
	<script src="../data/js/jquery.min.js"></script>
	<script src="../data/js/bootstrap.bundle.min.js"></script>

</body>

</html>
