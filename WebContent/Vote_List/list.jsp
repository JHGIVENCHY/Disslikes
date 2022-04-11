<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Vote_List/css/list_style.css" />
</head>
<body>
<table width=100%>
	<c:forEach var="vo1" items="${alist1}">
	<c:choose>
	<c:when test="${vo1.getDday()>=0}">
		<tr>
			<!-- 좋아요 -->
			<td>
			<a href="Result.do?img=${vo1.vt_img_name}&result=호"><span class="container" >
				<img src="${vo1.vt_img_path}" class="good" >
				<span class="middle1">
					<img src="Vote_List/img/good.PNG" width=50%>
				</span>
			</span></a>
			</td>
			<!-- 싫어요 -->
			<td><a href="Result.do?img=${vo1.vt_img_name}&result=불호"><span class="container">													
				<img src="${vo1.vt_img_path}" class="bad">
				<span class="middle2">
					<img src="Vote_List/img/bad.PNG" width=50%>
				</span>
			</span></a></td>
		</tr>
		<tr>
		<td colspan="2"><span class="vt_name"><br>${vo1.vt_name}</span></td>
		</tr>
		<tr>
		<td colspan="2"><span id="img"><img src="Vote_List/img/clock.png" width="35px"></span>
			<span>투표종료</span><span style="color:red; font-weight:bold"> D-${vo1.getDday()}</span>
		</td>	
		</tr>
		<tr>
			<td><br><br><br><br></td>
		</tr>
	</c:when>	
	<c:when test="${vo1.getDday()<0}">
		<tr>
			<td colspan="2" id="vote_end" name="vt_id"><a href="closeOne.do?img=${vo1.vt_img_name}">종료된 투표입니다.</a></td>
		</tr>
		<tr class="end_title">
		<td colspan="2"><h1>${vo1.vt_name }</h1></td>
		</tr>
		<tr class="end_title">
		<td colspan="2"><span id="img"><img src="Vote_List/img/clock.png" width="35px"></span>
			<span>투표종료</span><span style="color:red; font-weight:bold"> D-DAY</span>
		</td>
		</tr>
	</c:when>
	</c:choose>	
	<td><br><br><br><br></td>
	</c:forEach>
	</table>
</body>
</html>