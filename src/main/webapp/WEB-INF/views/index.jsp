<%@ page language="java" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전시회 정보 사이트</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	#menu-group button{
		border: 2px solid #506EA5;
		background-color: rgba(0,0,0,0);
		color: #506EA5;
		padding: 10px 20px;
  		font-size: 15px;
  		cursor: pointer;
  		border-radius: 8px;
	}
	#menu-group button:hover{
		color: white;
		background-color: #506EA5;
	}
}
</style>
</head>
<body>

				<h1>전시회 정보</h1>
	<div class="container">
	<form>
		<div class="row">
        	<div class="col-20">
				<div id="menu-group">
					<a href="#" id="add">등록하기</a>
					<a href="#" id="list">목록보기</a>
					<a href="#" id="detail">상세보기</a>
				</div>
			</div>
		</div>
	</form>
	</div>
	
<script src="${shw}/js/shw.js"></script>
<script src="<%=application.getContextPath() %>/resources/cmm/js/cmm.js"></script>
<script>
	cmm.init(`<%=application.getContextPath() %>`)
</script>
</body>
</html>