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
	<h1>회원 가입이 완료 되었습니다.</h1>
	<p class="p1">dissLIKEs는 비회원으로도 사용가능합니다.<br>다만, 비회원으로 사용할 경우 '응모', '채팅'등의 기능이 제한됩니다.</p>
	<br><br><br><br><br>
	<a href="Sign-In.do"><img id="img1" alt="로그인버튼" src="Login/picture/loginok.png"></a>
</section>
</body>
</html>