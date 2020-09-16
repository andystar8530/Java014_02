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
						<a class="nav-link " href="#">新增</a>
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
					<!-- 新增商品開始 -->
				<form method="POST" action="<c:url value='/register.do' />"
					enctype='multipart/form-data'>

					<Table
						style="width: 900px; background-color: #E7CDFF; cellspacing: 0; border: 2px solid black;">
						<!-- 	<tr height="40" > -->
						<!-- 		<td colspan='4' style="text-align: center; vertical-align: middle;"> -->
						<%-- 			<Font color="#006600" size='6' face="標楷體">ss${AppName}</Font> --%>
						<!-- 		</td> -->
						<!-- 	</tr> -->
						<tr height="36">

							<td colspan='4'
								style="text-align: center; vertical-align: middle;"><Font
								color="#006600" size='5' face="標楷體">增加商品</Font></td>
						</tr>
						<tr height="16">
							<td colspan='4'
								style="text-align: center; vertical-align: middle;">
								<div class="error">${errorSaveData}<br>
								</div>
							</td>
						</tr>

						<tr height="52">

							<td style="width: 90px;"><label class="fontSize">種類名稱：</label><br>&nbsp;</td>

							<td style="width: 290px;"><input type='text'
								name='P_CATEGORY' class="fieldWidth" style="width: 200px;" /><br>&nbsp;
								<font color="red" size="-1">${MsgMap.errorIdEmpty}${MsgMap.errorIdDup}</font></td>

							<td><label class="fontSize">商品名稱：</label><br>&nbsp;</td>
							<td><input type='text' name='P_NAME' class="fieldWidth"
								style="width: 200px;" /> <br>&nbsp; <font color="red"
								size="-1">${MsgMap.errorName}</font></td>
						<tr height="52">

							<td><label class="fontSize">預覽小圖：</label><br>&nbsp;</td>
							<td><input name='P_COVER' type='file' accept="image/*,.pdf" /><br>&nbsp;</td>

							<td><label class="fontSize">P_FILENAME：</label><br>&nbsp;</td>
							<td><input type='text' name='P_FILENAME' class="fieldWidth"
								style="width: 200px;" /> <br>&nbsp; <font color="red"
								size="-1">${MsgMap.errorPassword1Empty}</font></td>

						</tr>
						<tr height="52">
							<td><label class="fontSize">P_PDQTY：</label><br>&nbsp;</td>
							<td><input type='text' name='P_PDQTY' class="fieldWidth"
								style="width: 200px;" /><br>&nbsp; <font color="red"
								size="-1">${MsgMap.errorAddr}</font></td>

							<td><label class="fontSize">P_PDSUM：</label><br>&nbsp;</td>
							<td><input type='text' name='P_PDSUM' class="fieldWidth"
								style="width: 200px;" /><br>&nbsp; <font color="red"
								size="-1">${MsgMap.errorTel}</font></td>
						</tr>
						<tr height="52">

							<td><label class="fontSize">P_STOCK：</label><br>&nbsp;</td>
							<td><input type='text' name='P_STOCK' class="fieldWidth"
								style="width: 200px;" /><br>&nbsp; <font color="red"
								size="-1">${MsgMap.errorEmail}</font></td>

							<td><label class="fontSize">P_SDQTY：</label><br>&nbsp;</td>
							<td><input name='P_SDQTY' type='text' class="fieldWidth"
								style="width: 200px;" /><br>&nbsp;</td>
						</tr>
						<tr height="52">
							<td><label class="fontSize">P_PRICE：</label><br>&nbsp;</td>
							<td><input name='P_PRICE' type='text' class="fieldWidth"
								style="width: 200px;" /><br>&nbsp;</td>

							<!-- 					<td><label class="fontSize">P_NOTE：</label><br>&nbsp;</td> -->
							<!-- 					<td><input name='P_NOTE' type='text' class="fieldWidth" style="width: 200px;" /><br>&nbsp;</td> -->
						</tr>
						<tr height="52">
							<td><label class="fontSize">圖片1：</label><br>&nbsp;</td>
							<td><input name='P_PIC1' type='file' /><br>&nbsp;</td>

							<td><label class="fontSize">圖片1名稱：</label><br>&nbsp;</td>
							<td><input name='P_FILENAME1' type='text' class="fieldWidth"
								style="width: 200px;" /><br>&nbsp;</td>
						</tr>
						<tr height="52">
							<td><label class="fontSize">圖片2：</label><br>&nbsp;</td>
							<td><input name='P_PIC2' type='file' /><br>&nbsp;</td>

							<td><label class="fontSize">圖片2名稱：</label><br>&nbsp;</td>
							<td><input name='P_FILENAME2' type='text' class="fieldWidth"
								style="width: 200px;" /><br>&nbsp;</td>
						</tr>
						<tr height="52">
							<td><label class="fontSize">圖片3：</label><br>&nbsp;</td>
							<td><input name='P_PIC3' type='file' /><br>&nbsp;</td>

							<td><label class="fontSize">圖片3名稱：</label><br>&nbsp;</td>
							<td><input name='P_FILENAME3' type='text' class="fieldWidth"
								style="width: 200px;" /><br>&nbsp;</td>
						</tr>
						<tr height="42">
							<td colspan='4'>
								<div id="btnArea" align="center">
									<input type="submit" name="submit" id="submit" value="儲存" /> <input
										type="reset" name="cancel" id="cancel" value="重填">
								</div>
							</td>
						</tr>
					</Table>
				</form>

				<!--  商品新增標籤開結束 -->

			</div>
		</div>
	</div>

	<jsp:include page="/support/supFragment/bgFooter.jsp" />
	<script src="${pageContext.request.contextPath}/data/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/data/js/bootstrap.bundle.min.js"></script>
</body>
</html>