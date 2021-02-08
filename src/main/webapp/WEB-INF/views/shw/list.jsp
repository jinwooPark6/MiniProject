<%@ page language="java" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html land="en">
<head>
<meta charset="utf-8">
<title>전자정부 프레임워크 프로젝트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

html {
  box-sizing: border-box;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.column {
  float: left;
  width: 33.3%;
  margin-bottom: 16px;
  padding: 0 8px;
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 8px;
}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #f7f7f7;
  color: black;
}

.container {
  padding: 0 16px;
}

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

.goHome-btn {
  background-color: #506EA5;
  border: none;
  color: white;
  padding: 12px 16px;
  position: absolute;
  top:1%; left:1%;
  font-size: 16px;
  cursor: pointer;
}

.goHome-btn:hover {
  background-color: #506EA5;
}

	#btn-group button{
		border: 2px solid #506EA5;
		background-color: rgba(0,0,0,0);
		color: #506EA5;
		padding: 5px 10px;
  		font-size: 11px;
  		cursor: pointer;
  		border-radius: 8px;
	}
	#btn-group button:hover{
		color: white;
		background-color: #506EA5;
	}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}
</style>
</head>
<body>

<div id="shw-data"></div>

<div class="about-section">
<button type="button" class="goHome-btn" id="goHome" onclick="location.href='${ctx}/'"><i class="fa fa-home"></i></button>
  <h1>전시회 목록</h1> 
  <p>현재 진행 중인 전시회 목록입니다.</p>
  <p>Resize the browser window to see that this page is responsive by the way.</p>
</div>
<div class="row">
  <div class="col-75">
    <div class="container">
      <form>
        <div class="col-50">
	  	<h3 style="text-align:center;">전체 목록</h3>
	  	<div id="shw-data"></div>
        </div>
      </form>
    </div>
  </div>
</div>

<%-- 
<div class="row">
  <div class="column">
    <div class="card">
      <img src="/w3images/team1.jpg" alt="Jane" style="width:100%">
      <div class="container">
        <h2>전시회 제목</h2>
        <p>전시회 장소</p>
        <p>기간</p>
        <p>시간</p>
        <p><button class="button">예매하기</button></p>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="/w3images/team1.jpg" alt="Jane" style="width:100%">
      <div class="container">
        <h2>전시회 제목</h2>
        <p>전시회 장소</p>
        <p>기간</p>
        <p>시간</p>
        <p><button class="button">예매하기</button></p>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <img src="/w3images/team1.jpg" alt="Jane" style="width:100%">
      <div class="container">
        <h2>전시회 제목</h2>
        <p>전시회 장소</p>
        <p>기간</p>
        <p>시간</p>
        <p><button class="button">예매하기</button></p>
      </div>
    </div>
  </div>
</div>--%>

	<div id="btn-group" class="clearfix">
	<input type="text" id="shw-data-count" placeholder="데이터 생성 개수 입력"/>&nbsp;<button type="button" id="shw-generate-db">DB 생성</button>
    <button id="insert-many-shw">DB 초기화</button><br/>
	</div>

<script src="${cmm}/js/cmm.js"></script>
<script src="${shw}/js/shw.js"></script>
<script>
	shw.list(`{ctx}`)
</script>
</body>
</html>
    