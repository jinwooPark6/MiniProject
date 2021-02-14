<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <h1> 게시판1 </h1>
    <div class="container">
	<form>
		<div class="row">
        	<div class="col-20">
				<div id="menu-group">
        <a id="write" href="#">글 쓰기</a>
        <a id="list" href="#">글 목록</a>
        <a id="detail" href="#">글 상세</a>
				</div>
			</div>
		</div>
	</form>
	</div>

        
<script src="${brd}/js/brd.js"></script>
    <script src="<%=application.getContextPath() %>/resources/cmm/js/cmm.js"></script>
    <script>
    	cmm.init(`<%=application.getContextPath() %>`)
    </script>
</body>
</html>