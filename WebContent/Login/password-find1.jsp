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
		<h1>임시 비밀번호를 메일로 전송해 드립니다.</h1>
		<p class="p1">임시비밀번호로 로그인 한뒤, <br>비밀번호를 변경해 주세요!</p>
		<article>
			<div class="login-form">
				<form action="passwordfind.do" method="post">
					<div>
						<ul class="text-title">이메일</ul>
						<input type="text" name="findemail" class="text-field" placeholder="email@site.com" required>
						<!-- <input type="image" src="picture/SendMail.png" onmouseover="this.src='picture/SendMailOn.png'" onmouseout="this.src='picture/SendMail.png'"> -->
						<input id="img1" type="image" src="Login/picture/SendMail.png">
					</div>
				</form>
			</div>
		</article>
	</section>
</body>
</html>