<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="Login/picture/thumb.png" type="image/x-icon">
<title>dissLikes</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="Login/css/styles.css">
</head>
<body>
<!-- 공통헤더. -->
<div class="header">
	<c:import url="../frame/html/header.jsp"></c:import>
</div>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<section>
		<article><br><br>
			<div class="login-form">
				<form action="Sign-InOK.do" method="post">
					<div>
						<ul class="text-title">이메일</ul>
						<input type="text" name="email" class="text-field" placeholder="email@site.com" required><!-- placeholder 에 내용적으면 출력. --><br><br>
						<ul class="text-title">비밀번호</ul>
						<input type="password" name="password" class="text-field" placeholder="******" required>
						
						<div class="links">
							<a href="password-find1.do">비밀번호 찾기</a><br><br><br><br>
						</div>
						<input id="img1" type="image" src="Login/picture/SignIn.png">
						<div class="links2"><br>
							아직 회원이 아니신가요?&nbsp;&nbsp;&nbsp;<a href="Sign-Up.do">회원가입</a>
						</div>
					</div>
				</form>			
			</div>
		</article>
	</section>
</body>
</html>