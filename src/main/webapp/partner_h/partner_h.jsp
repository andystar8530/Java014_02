<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>合作商頁面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/data/css/marryMa.css">
</head>
<body>
  
<jsp:include page="/fragment/topMVC.jsp" />
<jsp:include page="./fragment/partnerSidebar.jsp" />
<%-- <jsp:useBean id='partner' class='partnerInfoEdit.dao.Impl.PartnerDaoImpl_Jdbc' scope='session'/> --%>
<%-- <jsp:getProperty name='partner' property='partnerBean'/> --%>
<div class="col-lg-9 mb-4"> 
        <h2>基本資料&nbsp</h2>
           <a href="${pageContext.request.contextPath}/partner_h/partnerInfoEdit_h.jsp"><img src="${pageContext.request.contextPath}/data/icon/document.png" width="50" style="display: inline;" ></a>
        <br>
        <hr>
       
        <form action="<c:url value='/displayPartnerInfo.do' />" method="GET" name="partnerForm" 
      class="needs-validation">
      <c:set var='nullInfo' value="" />
          <div class="form-group" >
            <label for="exampleInputName">店家名稱</label>
            <input type="text" class="form-control " id="exampleInputName" aria-describedby="NameHelp"
             value="${partnerBean.p_storeName}" readonly="readonly" > 
          </div>
          <div class="form-group" >
            <label for="exampleInputPMId">會員編號</label>
            <input type="text" class="form-control " id="exampleInputPMId" aria-describedby="PMIdHelp" 
            value="${LoginOK.m_No}" readonly="readonly" > 
          </div>
          <div class="form-group" >
            <div><label for="exampleInputInfo">簡介:</label></div>
           	<div>${partnerBean.p_info}${nullInfo} </div>
			<div></div>
          </div>
          
            <div class="form-group">
              <label for="exampleFormControlFile1">封面圖</label>
          <img height='150px' width='200px'
	src='${pageContext.request.contextPath}/util/getPartnerCoverImage?m_No=${LoginOK.m_No}'>
              
            </div>
          
         
            <div class="form-group">
              <label for="exampleFormControlFile1">公司大小章</label>
                  <img height='150px' width='200px'
	src='${pageContext.request.contextPath}/util/getPartnerStampImage?m_No=${LoginOK.m_No}'>
            </div>

            <div class="form-group">主要服務項目:&nbsp&nbsp&nbsp
             ${partnerBean.p_service}
              </div>
        
           
            <div class="form-group">服務區域:&nbsp&nbsp&nbsp
            <c:set var='areaName' scope="session"/>
            <c:choose>
   				 <c:when test="${partnerBean.p_area == 1}">
        				北部
    				</c:when>
    			<c:when test="${partnerBean.p_area == 2}">
     					中部
  					 </c:when>
  				<c:when test="${partnerBean.p_area == 3}">
        				南部
    				</c:when>
    			<c:when test="${partnerBean.p_area == 4}">
     					東部
  					  </c:when>	   	
    			<c:otherwise>
       					離島
    			</c:otherwise>
			</c:choose>
            </div>
            
<%--             <c:if test="${partnerBean.p_area == 1}"> --%>
<!--             	<span>北部</span> -->
<%--             </c:if> --%>
<%--               ${partnerBean.p_area} --%>
<!--               </div> -->
              
              <div class="form-group"> <label for="exampleInputReview">評價:</label>
              ${partnerBean.p_review}
              </div>

              <div class="form-group">
                <label for="exampleInputAccount">銀行帳號:</label>
               ${partnerBean.p_bankAcc}
            </div>
            <div class="form-group">
              <label for="exampleInputLine">Line ID:</label>
        	  ${partnerBean.p_lineId}
           </div>
         <div class="form-group">
            <label for="exampleInputSalary">預估時薪:</label>
            ${partnerBean.p_hRate}
         </div>
 		<div class="form-group">
            <label for="exampleInputCreateTime">建立時間:</label>
           ${partnerBean.memberBean.m_CreateTime}
           
         </div>
         <div class="form-group">
            <label for="exampleInputEditTime">最後修改時間</label>
           ${partnerBean.p_editTime}
      
         </div>
        </form>
      
</body>
</html>