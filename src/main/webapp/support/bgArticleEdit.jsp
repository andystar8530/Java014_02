<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公版文管理</title>
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
		後台 <small>公版文管理</small>
	</h1>

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a
			href="${pageContext.request.contextPath}/">首頁</a></li>
		<li class="breadcrumb-item active">公版文管理</li>
	</ol>
	<!-- 引入共同的頁首 -->
	<div class="bgMainDiv container">
		<jsp:include page="/support/supFragment/bgNavbar.jsp" />
		
<!-- 		公版文管理 -->
		
		<div class="bgMainGalleryDiv">
			<!-- 				xxxx標籤是測試用的 -->
			<button class="xxxx btn btn-secondary dropdown-toggle" type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">公版文選單</button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item" href="#">合約公版</a> <a class="dropdown-item"
					href="#">公告</a> <a class="dropdown-item" href="#">注意事項</a>
			</div>


			<div class="bgArtEditDiv">
				<!--fieldset為公版文編輯區域 -->
				<fieldset>

					<textarea name="mytext" rows="17" cols="70" required>         
          <c:choose>
		<c:when test="${empty memberService.allMembers}">
   			目前尚未有任何公版文資料
		</c:when>
		<c:otherwise>
                                 公版文資料如下：
				<c:forEach var="aBean" items="${ memberService.allMembers}">
					
						${aBean.memNo}
						${aBean.mname}
						${aBean.content}
					
				</c:forEach>
			
		</c:otherwise>
	</c:choose>
      </textarea>
				</fieldset>
			</div>
		</div>
		
<!-- 		公版文管理結束 -->
		
	</div>
	<jsp:include page="/support/supFragment/bgFooter.jsp" />
	<script src="${pageContext.request.contextPath}/data/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/data/js/bootstrap.bundle.min.js"></script>
</body>
</html>