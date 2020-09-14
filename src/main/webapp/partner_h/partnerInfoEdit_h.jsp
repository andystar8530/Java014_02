<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編輯店家資訊</title>
</head>
<body>
<jsp:include page="/fragment/topMVC.jsp" />
<jsp:include page="./fragment/partnerSidebar.jsp" />
<div class="col-lg-9 mb-4"> 
        <h2>基本資料&nbsp</h2>
        <br>
        <hr>
        <form action="<c:url value='/partnerInfoEdit.do' />" method="POST" name="partnerEditForm" enctype='multipart/form-data'
      class="needs-validation" novalidate>
          <div class="form-group" >
            <label for="exampleInputName">店家名稱</label>
            <input type="text" class="form-control " id="exampleInputName" aria-describedby="NameHelp"
             name="p_storeName" value="${partnerBean.p_storeName}"  ><small><Font color='red'  size="-3">${MsgMap.errorStoreNameEmpty}
             </Font></small> 
          </div>
          <div class="form-group" >
            <label for="exampleInputPMId">會員編號</label>
            <input type="text" class="form-control " id="exampleInputPMId" aria-describedby="PMIdHelp" 
           name="p_mId" value="${partnerBean.memberBean.m_No}"  readonly="readonly"  > 
          </div>
          <div class="form-group" >
            <div><label for="exampleInputInfo">簡介</label></div>
           	<textarea name="p_info" cols="50" rows="5" value="${partnerBean.p_info}"> ${partnerBean.p_info}
			</textarea> 
			<div></div>
            <small id="InfoHelp" class="form-text text-muted" >向新人介紹自己</small>
            <small><Font color='red'  size="-3">${MsgMap.errorInfoEmpty}
             </Font></small> 
          </div>
          
            <div class="form-group">
              <label for="exampleFormControlFile1">封面圖</label><br>
              <small><Font color='red'  size="-3">${MsgMap.errorPicture}
             </Font></small> 
<!--               <input type="file" class="form-control-file" id="exampleFormControlFile1"> -->
<!--               <img id="cov_img"> -->
 
 			<label for="image">
     		<input type="file" name="p_coverPic" id="image_file" style="display: none " />
     		<img src="${pageContext.request.contextPath}/util/getPartnerCoverImage?m_No=${LoginOK.m_No}" id="show_image" 
     		 style="max-width:300px" name="image_1"/>
    		</label>
    		  
            </div>
          
            <div class="form-group">
              <label for="exampleFormControlFile1">上傳公司大小章</label><br> 
              <small><Font color='red'  size="-3">${MsgMap.errorPicture2}
             </Font></small> 
<!--               <input type="file" class="form-control-file" id="exampleFormControlFile2"> -->
<!--                <img id="sta_img"> -->
			<label for="image">
     		<input type="file" name="p_stamp" id="image_file_sta" style="display: none " />
     		<img src="${pageContext.request.contextPath}/util/getPartnerStampImage?m_No=${LoginOK.m_No}" id="show_image_sta"
     		 style="max-width:300px" name="image_2"/>
    		</label>
           
            </div>
         
          <div class="form-group">主要服務項目:&nbsp&nbsp&nbsp
          <small><Font color='red'  size="-3">${MsgMap.errorServiceEmpty}
             </Font></small> 
          <div class="form-check">
            <input class="form-check-input" type="radio" name="serviceRadios" id="serviceRadios1" 
            value="婚禮佈置" ${partnerBean.p_service == "婚禮佈置" ?  "checked='checked'" : ""} >
            <label class="form-check-label" for="serviceRadios1">
              婚禮佈置
            </label>
          </div>
          <div class="form-check">
            <input class="form-check-input" type="radio" name="serviceRadios" id="serviceRadios2"
             value="婚禮攝影" ${partnerBean.p_service == "婚禮攝影" ? "checked='checked'" : ""}>
            <label class="form-check-label" for="serviceRadios2">
              婚禮攝影
            </label>
          </div>
          <div class="form-check disabled">
            <input class="form-check-input" type="radio" name="serviceRadios" id="serviceRadios3" 
            value="新娘秘書" ${partnerBean.p_service == "新娘秘書" ? "checked='checked'" : ""}>
            <label class="form-check-label" for="serviceRadios3">
             新娘秘書
            </label>
          </div>
          <div class="form-check disabled">
            <input class="form-check-input" type="radio" name="serviceRadios" id="serviceRadios4" 
            value="婚禮主持" ${partnerBean.p_service == "婚禮主持" ?  "checked='checked'" : ""} >
            <label class="form-check-label" for="serviceRadios4">
             婚禮主持
            </label>
          </div>
          
          </div>
       

        
        
         <div class="form-group">服務區域:&nbsp&nbsp&nbsp
          <small><Font color='red'  size="-3">${MsgMap.errorAreaEmpty}
             </Font></small> 
          <div class="form-check">
            <input class="form-check-input" type="radio" name="areaRadios" id="areaRadios1" value="1" 
            ${partnerBean.p_area == "1" ?  "checked='checked'" : ""}>
            <label class="form-check-label" for="areaRadios1">
              北部
            </label>
          </div>
          <div class="form-check">
            <input class="form-check-input" type="radio" name="areaRadios" id="areaRadios2" value="2"
             ${partnerBean.p_area == "2" ?  "checked='checked'" : ""} >
            <label class="form-check-label" for="areaRadios2">
              中部
            </label>
          </div>
          <div class="form-check disabled">
            <input class="form-check-input" type="radio" name="areaRadios" id="areaRadios3" value="3" 
             ${partnerBean.p_area == "3" ?  "checked='checked'" : ""} >
            <label class="form-check-label" for="areaRadios3">
              南部
            </label>
          </div>
          <div class="form-check disabled">
            <input class="form-check-input" type="radio" name="areaRadios" id="areaRadios4" value="4" 
            ${partnerBean.p_area == "4" ?  "checked='checked'" : ""} >
            <label class="form-check-label" for="areaRadios4">
              東部
            </label>
          </div>
          <div class="form-check disabled">
            <input class="form-check-input" type="radio" name="areaRadios" id="areaRadios5" value="5"
            ${partnerBean.p_area == "5" ?  "checked='checked'" : ""}  >
            <label class="form-check-label" for="areaRadios5">
              離島
            </label>
          </div>
          </div>
          
              <div class="form-group">
              <label for="exampleInputAccount">銀行帳號</label>
              <input type="text" class="form-control" id="exampleInputAccount" aria-describedby="AccountHelp"
              name="p_bankAcc" value="${partnerBean.p_bankAcc}">
              <small id="AccountHelp" class="form-text text-muted" >要錢給帳號喔喔喔</small>
                <small><Font color='red'  size="-3">${MsgMap.errorbankAcc}
             </Font></small> 
              
          </div>
          <div class="form-group">
            <label for="exampleInputLine">Line ID:</label>
            <input type="text" class="form-control" id="exampleInputLine" aria-describedby="LineHelp"
             name="p_lineId" value="${partnerBean.p_lineId}" >
          
            <small id="LineHelp" class="form-text text-muted" >請填寫Line ID</small>
              <small><Font color='red'  size="-3">${MsgMap.errorLineId}
             </Font></small> 
         </div>
         
         <div class="form-group">
            <label for="exampleInputLine">預估時薪:</label>
            <input type="number" class="form-control" id="exampleInputHRate" aria-describedby="HRateHelp" min="158"
            name="p_hRate" value="${partnerBean.p_hRate}">
          
            <small id="HRateHelp" class="form-text text-muted" >請填寫預估時薪</small>
              <small><Font color='red'  size="-3">${MsgMap.errorHRate}
             </Font></small> 
         </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
          <script>
      $("#show_image").click(function (e) {
        document.getElementById("image_file").click();
      });
      $("#show_image_sta").click(function (e) {
          document.getElementById("image_file_sta").click();
        });

      $("#image_file").on("change", function (event) {
        const file = event.target.files[0];
        let readFile = new FileReader();
        readFile.readAsDataURL(file);
        readFile.addEventListener("load", function (e) {
          let image = document.getElementById("show_image");
          image.src = this.result;

          // image.width = 500 ;
          image.style.maxWidth = "200px"; //css屬性
          image.style.maxHeight = "200px";
        });
      });
        $("#image_file_sta").on("change", function (event) {
            const file = event.target.files[0];
            let readFile = new FileReader();
            readFile.readAsDataURL(file);
            readFile.addEventListener("load", function (e) {
              let image = document.getElementById("show_image_sta");
              image.src = this.result;

              // image.width = 500 ;
              image.style.maxWidth = "200px"; //css屬性
              image.style.maxHeight = "200px";
            });
      });
      </script>
      
<!--         <script src="../data/js/partner.js"></script> -->

</body>
</html>