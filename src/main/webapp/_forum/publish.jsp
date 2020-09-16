<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
    .bg-secondary{height: 50rem;}
    .title{font-size: 75px; text-align: center;}
    #content{height: 200px ;}
    .opa{opacity: 0.8;}
    .cen{margin-left: 95%;}
    </style>
</head>
<body>
<div class="bg-secondary container">
    <div class="row">
        <p class="title col-12">發表文章</p>
    <div class="form-group text-light col-12">
        <label for="exampleFormControlSelect1 " style="font-size: 55px;">發文類別</label>
        <select class="form-control" id="exampleFormControlSelect1">
          <option>婚禮布置</option>
          <option>婚禮攝影</option>
          <option>新娘秘書</option>
          <option>婚禮主持</option>
          <option>小物商城</option>
        </select>
        <p style="font-size: 55px";>文章標題 <font margin="3" color="white" size="5">${ErrorMsgKey.TitleEmpty}</font></p>
        
    <form action="${pageContext.request.contextPath}/forum/ForumServlet" method="Post">
    <input type="text" class="form-control" name="title" value="${param.title}" placeholder="您的文章標題" aria-label="title" aria-describedby="addon-wrapping">
    <p style="font-size: 55px";>文章內文</p>
    <!-- <div class="container"> -->
        <div class="row">
            <div class="form-group col-12">
                <label for="exampleFormControlTextarea1"> <font margin="3" color="white" size="5">${ErrorMsgKey.TextEmpty}</font></label>
                <textarea class="form-control" name="text" id="exampleFormControlTextarea1" rows="5">${param.text}</textarea>
            </div>
        </div>
        <!-- <div class="row "> -->
            <div class="col-6">
                <div class=" ">           
                    <input class="btn btn-info cen" type="Submit" value="送出">
                </div>
            </div>
            </form>
          <!-- </div> -->
       <!-- </div> -->

    
    </div>
</div>
</div>
    
   




      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>