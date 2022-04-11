<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중인 투표</title>
<link rel="stylesheet" href="After_Click/css/style.css">
</head>
<script>
function Go_After() {
   var img = '${ vt_img_name }';
   var url = decodeURIComponent(location.href);
   var url_arr = url.split('?', 1);
   if (url_arr == 'http://localhost:8080/disslikes/Result.do') {
      window.location.href ='<c:url value="Search_vt_id.do"/>?img=' +img;
   } 
   return;
}
</script>
<body onload="Go_After()">
<!-- 공통헤더. -->
<div class="header">
	<c:import url="../frame/html/header.jsp"></c:import>
</div>
<c:import url="Main.jsp"></c:import>
<c:import url="Footer.jsp"></c:import>
</body>
</html>