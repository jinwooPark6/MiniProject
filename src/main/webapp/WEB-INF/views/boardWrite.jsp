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
<h1>게시글 작성</h1>
<c:if test="${board.boardSeq!=null}">
	<form action="boardUpdate" method="post">
		<input type="hidden" name="boardSeq" value="${board.boardSeq}">
	</c:if>

	<c:if test="${board.boardSeq==null}">
	<form action="boardWrite" method="post">
	</c:if>

	제목: <input type="text" name="title" value="${board.title}"><br>
	내용: <textarea rows="20" cols="20" name="content">${board.content}</textarea>
	<br>
	<input type="submit" value="등록">	
	</form>
</body>
</html>