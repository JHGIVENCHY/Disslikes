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
<body>
<!-- 공통헤더. -->
<div class="header">
	<c:import url="../frame/html/header.jsp"></c:import>
</div>
<section>
	<h1 class="title1">임시 비밀번호를 메일로 전송해 드립니다.</h1>
	<p class="p1">임시비밀번호로 로그인 한뒤. <br>비밀번호를 변경해 주세요!</p>
	<br>
	<p class="p2">비밀번호 : <%=(String) session.getAttribute("findpassword")%></p>
	<a href="Sign-In.do"><img id="img1" alt="로그인버튼" src="Login/picture/loginok.png"></a>
</section>
</body>
</html>