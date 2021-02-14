<%@ page language="java" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="container">
	<button type="button" class="goHome-btn" id="goHome" onclick="location.href='${ctx}/'"><i class="fa fa-home"></i></button>
	<form>
	  <h2>게시글 상세보기</h2> 
    <div class="row">
      <div class="col-25">
        <label for="boardNum">No</label>
      </div>
      <div class="col-75">
        <p id="boardNum"></p>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="title">제목</label>
      </div>
      <div class="col-75">
        <p id="title"></p>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="content">내용</label>
      </div>
      <div class="col-75">
        <p id="content"></p>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="date">날짜</label>
      </div>
      <div class="col-75">
        <p id="date"></p>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="id">작성자</label>
      </div>
      <div class="col-75">
        <p id="id"></p>
      </div>
    </div>
  
	    <div id="btn-group" class="clearfix" style="text-align: right">
	      <button type="button" id="update-btn" class="update-btn">수정</button>
	      <button type="button" id="delete-btn" class="delete-btn">삭제</button>
	    </div>
    </form>
</div>

<script src="${cmm}/js/cmm.js"></script>
<script src="${brd}/js/brd.js"></script>
<script>
	brd.detail(`<%=application.getContextPath() %>`)
</script>
</body>
</html>