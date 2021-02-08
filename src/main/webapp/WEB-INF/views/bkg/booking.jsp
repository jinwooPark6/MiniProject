<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
body {
  font-family: Roboto, Arial, sans-serif;
  ont-size: 15px;
  color: #525252;
  padding: 8px;
}
h2 {
  display: block;
  font-size: 1.5em;
  margin-top: 0.83em;
  margin-bottom: 0.83em;
  margin-left: 20px;
  margin-right: 0;
  font-weight: bold;
}
* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 0px;
  width: 70%;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #467575;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #2F4F4F;
}

a {
  color: #598585;
}

a:link {
  text-decoration: none;
}

a:visited {
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
  color: #2f4f4f;
}

a:active {
  text-decoration: underline;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
.collapsible {
  background-color: #777;
  color: white;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color: #555;
}

.content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}
</style>

<h2>예약하기</h2>
<div class="row">
  <div class="col-75">
    <div class="container">
      <form>
      <div class="col-50">
      		<p style="text-align:right;"><a href="#" id="go-home">홈으로</a></p>
            <h3>예약상품 정보</h3>
            <label for="stitle">전시명</label>
            <input type="text" id="showTitle" name="showtitle" placeholder="OOO전시회">
            <label for="sdate">일시</label>
            <input type="text" id="showDate" name="showdate" placeholder="2021-01-01">
            <label for="slocation">장소</label>
            <input type="text" id="showLocation" name="showlocation" placeholder="예술의 전당">
            <label for="sprice">가격</label>
            <input type="text" id="showPrice" name="showprice" placeholder="10,000">
          </div>      	
          <div class="col-50">
            <h3>예약자 정보</h3>
            <label for="fname"><i class="fa fa-user"></i> 예약자명 </label>
            <input type="text" id="bookName" name="bname" placeholder="예약자명 입력">
            <label for="email"><i class="fa fa-envelope"></i> 이메일 </label>
            <input type="text" id="bookEmail" name="email" placeholder="abc@example.com">
            <label for="adr"><i class="fa fa-address-card-o"></i> 전화번호 </label>
            <input type="text" id="bookPnumber" name="pnumber" placeholder="010-1234-5678">          
        </div>
        <label>
          <input type="checkbox" checked="checked" name="sameadr"> 개인정보 이용에 동의합니다.
        </label>
        <button id="booking-btn" class="btn">예매하기</button>
      </form>
    </div>
  </div>
</div>

<script src="${bkg}/js/bkg.js"></script>
<script src="${cmm}/js/cmm.js"></script>
<script>
	$('#booking-btn').click(function() {bkg.booking(`${ctx}`)})
	$('#go-home').click(function() {cmm.goHome(`${ctx}`)})
</script>

