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
<%--
    <script type="text/javascript">
        $(function() {
            $("#posterImage").on('change', function() {
                readURL(this);
            });
        });
        function readURL(input) {
            if(input.files && input.files[0]) {
               var reader = new FileReader();
               reader.onload = function (e) {
                  $('#preImage').attr('src', e.target.result);
               }
               reader.readAsDataURL(input.files[0]);
            }
        }
    </script> --%>
</head>
<body>

<div class="container">
  <button type="button" class="goHome-btn" id="goHome" onclick="location.href='${ctx}/'"><i class="fa fa-home"></i></button>
  <form>
  <%-- <form action="/action_page.php"> --%>
	<h2>전시회 등록화면</h2>
	<p>등록할 전시회 정보를 입력해주세요.</p>
	<%--
    <div class="row">
      <div class="col-25" id="image-container">
        <label for="posterImage">포스터</label>
	  </div>
      <div class="col-75">
        <input type="file" id="posterImage" accept="image/*" required>
        <img style="width:150px;" id="preImage" />
      </div>
    </div>  --%>
    <div class="row">
      <div class="col-25">
        <label for="title">제목</label>
      </div>
      <div class="col-75">
        <input type="text" id="title" placeholder="전시회 제목" required>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="period">기간</label>
      </div>
      <div class="col-75">
        <input type="text" id="period" placeholder="2021.00.00 ~ 2021.00.00" required>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="time">시간</label>
      </div>
      <div class="col-75">
        <input type="text" id="time" placeholder="00:00 ~ 00:00" required>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="venue">장소</label>
      </div>
      <div class="col-75">
        <input type="text" id="venue" placeholder="전시회 장소" required>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="admission">입장연령</label>
      </div>
      <div class="col-75">
        <input type="text" id="admission" placeholder="전체관람가" required>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="price">가격</label>
      </div>
      <div class="col-75">
        <textarea id="price" style="height:70px;" wrap="soft" required>일반(만 19세 이상) : 00,000원&#10청소년(만 13세-18세) : 00,000원&#10어린이(36개월-12세) : 00,000원</textarea>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="host">주최</label>
      </div>
      <div class="col-75">
        <input type="text" id="host" placeholder="전시회 주최" required>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="management">주관</label>
      </div>
      <div class="col-75">
        <input type="text" id="management" placeholder="전시회 주관" required>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="inquiry">문의</label>
      </div>
      <div class="col-75">
        <input type="text" id="inquiry" placeholder="02-000-0000" required>
      </div>
    </div>
    <br />
    <div id="btn-group" class="clearfix" style="text-align: right">
      <button type="submit" id="add-btn" class="add-btn">등록</button>
      <button type="button" id="cancel-btn" class="cancel-btn">취소</button>
    </div>
  </form>
</div>
<script src="${cmm}/js/cmm.js"></script>
<script src="${shw}/js/shw.js"></script>
<script>
$('#add-btn').click(function() {shw.add(`${ctx}`)})
</script> 
 
</body>
</html>