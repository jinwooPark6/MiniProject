<%@ page language="java" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>전자정부 프레임워크 프로젝트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

.container {
  border-radius: 5px;
  background-color: #f7f7f7;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}

.goHome-btn {
  background-color: #506EA5;
  border: none;
  color: white;
  padding: 12px 16px;
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
		padding: 10px 20px;
  		font-size: 15px;
  		cursor: pointer;
  		border-radius: 8px;
	}
	#btn-group button:hover{
		color: white;
		background-color: #506EA5;
	}
}
</style>
</head>
<body>
<div class="container">
<div class="about-section">
<button type="button" class="goHome-btn" id="goHome" onclick="location.href='${ctx}/'"><i class="fa fa-home"></i></button>
</div>
<div class="row">
  <div class="col-75">
	  <h1>전시회 상세 페이지</h1> 
      <form>
		  <table class="table">
	        <thead>
	            <tr>
	                <td>글번호</td>
	                <td id="showNum"></td>
	            </tr>
	            <tr>
	                <td>제목</td>
	                <td id="title"></td>
	            </tr>
	            <tr>
	                <td>기간</td>
	                <td id="period"></td>
	            </tr>
	            <tr>
	                <td>시간</td>
	                <td id="time"></td>
	            </tr>
	            <tr>
	                <td>장소</td>
	                <td id="venue"></td>
	            </tr>
	            <tr>
	                <td>관람등급</td>
	                <td id="admission"></td>
	            </tr>
	            <tr>
	                <td>가격</td>
	                <td id="price"></td>
	            </tr>
	            <tr>
	                <td>주최</td>
	                <td id="host"></td>
	            </tr>
	            <tr>
	                <td>주관</td>
	                <td id="management"></td>
	            </tr>
	            <tr>
	                <td>문의</td>
	                <td id="inquiry"></td>
	            </tr>
	      </thead>
	    </table>
	    <div id="btn-group" class="clearfix" style="text-align: center">
	      <button type="button" id="update-btn" class="update-btn">수정</button>
	      <button type="button" id="delete-btn" class="delete-btn">삭제</button>
	    </div>
      </form>
    </div>
  </div>
</div>


<script src="${cmm}/js/cmm.js"></script>
<script src="<%=application.getContextPath() %>/resources/shw/js/shw.js"></script>
<script>
	shw.detail(`<%=application.getContextPath() %>`)
</script>
</body>
</html>