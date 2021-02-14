  
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
<div class="about-section">
	<button type="button" class="goHome-btn" id="goHome" onclick="location.href='${ctx}/'"><i class="fa fa-home"></i></button>
	<form>
	  <h2>후기 목록</h2> 

    <div class="row">
      <div class="col-25">
      	  <br>
		  <div id="brd-data"></div>
      </div>
    </div>
    </form>
</div>

<script src="${cmm}/js/cmm.js"></script>
<script src="${brd}/js/brd.js"></script>
<script>
	brd.list(`<%=application.getContextPath() %>`)
</script>
</body>
</html>