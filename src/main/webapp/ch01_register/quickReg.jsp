<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Page Title - SB Admin</title>
<link rel="stylesheet" href="styles.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="bg-primary"
	onload="javascript:document.insertMemberFormA.mId.focus();">
	<jsp:include page="/fragment/topMVC.jsp" />
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">會員註冊</h3>
								</div>
								<div class="card-body">
									<form name="insertMemberFormA" action="member.do" method="POST">
										<div class="form-group">
											<label class="small mb-1" for="inputEmailAddress">Email</label>
											<input class="form-control py-4" id="inputEmailAddress"
												type="email" placeholder="Enter email address" name="mEmail"
												value="${param.mEmail}" /> <span><font color='red'
												size="-1">${ErrorMsgKey.AccountEmptyError}</font></span>
										</div>
										<div class="form-group">
											<label class="small mb-1" for="inputPassword">密碼</label> <input
												class="form-control py-4" id="inputPassword" type="password"
												placeholder="Enter password" name="mPassWord"
												value="${param.mPassWord}" /> <span><font
												color='red' size="-1">${ErrorMsgKey.PasswordEmptyError}</font></span>
										</div>
										<div class="form-group">
											<label class="small mb-1" for="inputPassword">確認密碼</label> <input
												class="form-control py-4" id="confirmPassword"
												type="password" placeholder="Enter password"
												name="cPassWord" value="${param.cPassWord}" /> <span><font
												color='red' size="-1">${ErrorMsgKey.MustbeSamePassword}</font></span>
										</div>
<!-- 										<div class="form-group"> -->
<!-- 											<div class="custom-control custom-checkbox"> -->
<!-- 												<input class="custom-control-input" -->
<!-- 													id="rememberPasswordCheck" type="checkbox" /> <label -->
<!-- 													class="custom-control-label" for="rememberPasswordCheck">Remember -->
<!-- 													password</label> -->
<!-- 											</div> -->
<!-- 										</div> -->
                                           <input type="radio" name="identity" value="${0}"> 新人<br>
                                           <input type="radio" name="identity" value="${1}"> 合作商<br>
                                           <span><font
												color='red' size="-1">${ErrorMsgKey.MustCheckIden}</font></span>
										<div
											class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
											 <input
												class="btn btn-primary" type="submit" value="送出" />
										</div>
									</form>
								</div>
								<div class="card-footer text-center">
									<div class="small">
										<a href="register.html">Need an account? Sign up!</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
		<div id="layoutAuthentication_footer">
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2020</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
