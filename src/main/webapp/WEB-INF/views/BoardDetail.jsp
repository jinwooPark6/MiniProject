<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Mini Project</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>게시글상세</h1>
	
	<c:if test="${sessionScope.loginId==board.id}">>
	<form action="deleteBoard" method="post">
		<input type="hidden" name="boardSeq" value="${board.boardSeq }">
		<button type = "submit">삭제</button>
	</form>
	
	<form action="goUpdateBoard" method="get">
	 	<input type="hidden" name="boardSeq" value="${board.boardSeq}">
	 	<button type="submit">수정</button>
	</form>
	
	</c:if>
	
	제목 : ${board.title}<br>
	작성자 : ${board.id}<br>
	작성일 : ${board.indate}<br>
	내용 : ${board.content}<br>
	
	<br>
	
	<a href="/getBoard">게시판목록으로</a>

</body>
</html>