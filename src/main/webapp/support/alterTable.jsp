<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="memberService" class="support.MemberService" />
<c:set var="subTitle" value="查詢公版文資料" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="proenter.css">
<title>Document</title>
</head>
<body onload="javascript:document.alterTable.mId.focus();">

	<form name="alterTable" action="ContentUpdateServlet.do" method="POST">
		<input type="hidden" value="${plateannouncement.PAID}" name="paid" />
		<img src="./images/2020-08-11.png" width="80px"> <br>
		<fieldset>

			<textarea name="mytext" rows="17" cols="110" required>         
                                 
		${plateannouncement.PACONTENT}			

      </textarea>
		</fieldset>
		<input type="submit" value="審核修改通過存檔"> <a
			href="<c:url value='../index.jsp' />">回首頁</a>
	</form>
</body>
</html>