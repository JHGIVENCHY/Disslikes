<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="Login/picture/thumb.png" type="image/x-icon">
<title>DissLikes</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="Login/css/styles.css">
  <link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">

</head>
<script src="js/Sign-Up.js"></script>
<body>
<!-- 헤더 공통부분. -->
<div class="header">
	<c:import url="../frame/html/header.jsp"></c:import>
</div>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="home" value="../../closed_survey/html/closed_survey.jsp"/>

<section>
	<h1 class="title1">회원 가입을 환영합니다!</h1>
	<p class="p1">dissLIKES 는 비회원으로도 사용가능합니다.<br>다만, 비회원으로 사용할 경우 '응모', '채팅'등의 기능이 제한됩니다.</p>
	<article>
    	<div class="login-form">
		<!-- <form action="Sign-UpOK.jsp"> -->
			<form name="writeForm" method="post" action="Sign-Up.do">
			   	<div>
					<ul class="text-title">* 이메일</ul>
					<input type="text" name="email" id="email1" class="text-field" placeholder="email@site.com" required>
					<ul class="text-body"><font id="chkNotice1" size="2"></font></ul>
					<br>
					<ul class="text-title">* 비밀번호</ul>
					<input type="password" name="password" id="pw1" class="text-field" placeholder="******" required>
					<ul class="text-body"><font id="chkNotice2" size="2" name="pwchk1"></font></ul>
					<br><br>
					<ul class="text-title">* 비밀번호확인</ul>
					<input type="password" name="password2" id="pw2" class="text-field" placeholder="******" required>
					<ul class="text-body"><font id="chkNotice3" size="2"></font></ul>
					<br><br><br>
					<input id="img1" type="image" src="Login/picture/SignUp.png" onsubmit="">
		        </div>
			</form>
		</div>
	</article>
</section>
</body>
</html>