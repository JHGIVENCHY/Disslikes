<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet" href="${contextPath}css/style.css">
<script type="text/javascript" src="After_Click/js/jquery-3.6.0.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
<header id="header">
	<div class="block1-1" id="menu_home_user">
		<a href="list url"><img src="${contextPath}/img/menu.png" class="menu"></a>
		<!-- 리스트로 가는 url을 작성해야 합니다. -->
		<a href="project url"><img src="${contextPath}/img/dissLIKES_Logo_w48.png" alt="Visit the home" class="logo"></a>
		<!-- 홈으로 가는 url을 작성해야 합니다. -->
		<a href="login url"><img src="${contextPath}/img/user.png" alt="Visit the login" class="user"></a>
		<!-- 로그인 페이지로 url을 작성해야 합니다. -->
	</div>
	<div class="block1-2" id="to_list">
		<a href="javascript:history.back();"><img src="${contextPath}/img/ListBack.png"></a>
		<!-- list의 주소로 변경해야 합니다. -->
	</div>
</header>
</body>
</html>