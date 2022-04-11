<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dissLIKES</title>
<link rel="shortcut icon" href="Main/Picture/thumb.png" type="image/x-icon">
<link rel="stylesheet" href="Main/style.css" > 

<c:set var="contextPath1" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="Main/Main.js"></script>
<script type="text/javascript">

<c:forEach var="val1" items="${vtlist1}">
	idlist.push("${val1.id}");
</c:forEach>

<c:forEach var="val1" items="${vtlist1}">
	imgnamelist.push("${val1.vt_img_name}");
</c:forEach>

<c:forEach var="val1" items="${vtlist1}">
	namelist.push("${val1.title}");
</c:forEach>

<c:forEach var="val1" items="${vtlist1}">
	imglist.push("${val1.img}");
</c:forEach> 

<c:forEach var="val2" items="${vtlist2}">
	lastimg.push("${val2.img}");
</c:forEach>

<c:forEach var="val2" items="${vtlist2}">
	lasttitle.push("${val2.title}"+" "+ "호 vs 불호");
</c:forEach>

<c:forEach var="val2" items="${vtlist2}">
	lastlike.push("${val2.like}");
</c:forEach>

<c:forEach var="val2" items="${vtlist2}">
	lastdislike.push("${val2.dislike}");
</c:forEach>

<c:forEach var="val2" items="${vtlist2}">
	lastvalue.push(Math.abs("${val2.like}"-"${val2.dislike}")+"표 차이로"+" "+"${val2.win}"+" "+"의 승리!!!");
</c:forEach>

if (window.location == 'http://localhost:8080/disslikes/'){
	session.setAttribute("nick", "회원아님");
	window.location.href="${contextPath1}/Main.do";
	}
else if(window.location == 'http://localhost:8080/disslikes/Main/Main.jsp'){
	window.location.href="${contextPath1}/Main.do";
}

function leftImge() {
	var result="호";
	var img=imgnamelist[Num];
	window.location.href ='<c:url value="Result.do"/>?img=' + img + '&result=' + result;
}
function rightImge() {
	var result="불호";
	var img=imgnamelist[Num];
	window.location.href ='<c:url value="Result.do"/>?img=' + img + '&result=' + result;
}
/* 잠시 보류 
function leftImge() {
	var result="호";
	var id=idlist[Num];
	window.location.href ='<c:url value="Result.do"/>?id='+id+'&result='+result;
}
 */
/* function rightImge() {
	var result="불호"
	var id=idlist[Num]
	window.location.href ='<c:url value="Result.do"/>?id='+id+'&result='+result;
} */
function needlogin(){
	alert("로그인이 필요한 기능입니다.");
}

</script>

</head>
<body onload="showImage()">
<!-- 공통헤더. -->
<div class="header">
	<c:import url="../frame/html/header.jsp"></c:import>
</div>
<article>
	<div class="title">
		<a href="allList.do" id="list">
			진행중인 호불호 조사 >
		</a>
	</div>
	<div class="pro">
		<div class="pro_item" style="width: 1180px;">
            <img class="left" src="Main/Picture/left.png" onclick="leftMove()"
               style="cursor: pointer;"><img
               class="pro_img" id="proId1" onclick="leftImge()"
               onmouseover="good(this)" onmouseout="back(this)"><img class="pro_img" id="proId2"
               onmouseover="bad(this)" onmouseout="back(this)" onclick="rightImge()"><img
               class="right" src="Main/Picture/right.png" onclick="rightMove()"
               style="cursor: pointer;">
        </div>
		<div class="pro_name">
			<font id="proName"></font>
		</div>
	</div>
</article>
<article>
	<div class="title">
		<a href="getAllCloseList.do" id="list">
			지난 이벤트 조사 결과 >
		</a>
	</div>
	<div class="last">
		<div class="last_item">
	   		<img class="last_img" id="intro">
		</div>
		<br>
		<div style="font-size: 25px; font-weight: bold;">
			<font id="lastTitle"></font>
		</div>
		<br>
		<div style="font-size: 30px; font-weight: bold;">
			<font id="lastValue"></font>
		</div>
		<br>
		<div style="text-align:center">
		  <span class="dot"></span> 
		  <span class="dot"></span> 
		  <span class="dot"></span> 
		  <span class="dot"></span>
		</div>
	</div>
</article>
	<div>
		<%if(session.getAttribute("nick") == null){%>
			<a href="" class="vote_making" onclick="needlogin()">
				<img src="Main/Picture/making_button.PNG">
			</a>
		<%}else{%>
			<a href="new-Vote.do" class="vote_making">
				<img src="Main/Picture/making_button.PNG">
			</a>
		<%}%>
	</div>
	<br>
	<br>
</body>
</html>