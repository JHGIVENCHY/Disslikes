<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<%
		session.invalidate();
	%>
	<script type="text/javascript">
		$(document).ready(function() {
			alert("로그아웃 되었습니다.");
			location.href = "../Main/Main.jsp"
		});
	</script>
</body>
</html>