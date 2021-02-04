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

	<h1>${sessionScope.loginId}님의 페이지</h1>
	
		<form action="test" method="get">
			<input type="submit" value="test">
		</form>
		<form action="logout" method="get">
			<input type="submit" value="logout">
		</form>
		<a href="goWrite">게시글 작성하기</a>
		<table>
		<tr>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		</tr>
		<c:forEach items="${bList}" var="board">
		<tr>
		<td><a href="boardDetail?boardSeq=${board.boardSeq}">${board.title}</a></td>
		<td>${board.id}]</td>
		<td>${board.indate}</td>
		</tr>
		</c:forEach>
		</table>
		
   </body>
</html>