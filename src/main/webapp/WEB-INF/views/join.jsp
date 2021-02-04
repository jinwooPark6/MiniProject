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

<h1>회원가입</h1>

	<form action="insertUser" method="post">
			ID:<input type="text" name="id"><br>
			<font color="red">${message}</font><br>
			PW:<input type="password" name="pw"><br>
			NAME:<input type="text" name="name"><br>
			PHONE:<input type="tel" name="phone"><br>
			EMAIL:<input type="email" name="email"><br>
			BIRTHDATE:<input type="date" name="birthdate"><br>
			<input type="submit" value="SIGNUP">
		</form>
   </body>
</html>