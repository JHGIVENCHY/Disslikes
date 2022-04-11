<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="../c/css/ninia.css?after"> -->
<link rel="stylesheet" href="New_Vote/css/ninia.css">
<script type="text/javascript" src="New_Vote/js/New_Vote.js"></script>
</head>
<body>
<!-- 공통헤더. -->
<div class="header">
	<c:import url="../frame/html/header.jsp"></c:import>
</div>
<!-- <form action="new-vote-upload.jsp" method="post" enctype="multipart/form-data" align="center"> -->
<form action="new-vote-upload.do" method="post" enctype="multipart/form-data" align="center">
	<span id="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
	<span id ="main">호불호 카테고리</span>
	<span id ="sub">어떤 분야의 호불호를 조사하고 싶나요?</span>
	<br>
	<table align="center">
		<tr>
			<td width="400px">
				<span id="categori">카테고리</span>
			</td>
			<td width="400px">
				<span id="categori">세부 카테고리</span>
				<span id="gray">(선택)</span>
			</td>
		</tr>
		<tr>
			<td><br>&nbsp;&nbsp;&nbsp;
				<select name="vt_type" id="vt_type" required style="height:45px;width:300px;display: inline-block;padding: .5em .75em;border-bottom-color: #414141; border-radius: .25em;" required>
					<option value="" selected disabled hidden>선택해주세요</option>
					<option value="음식">음식</option>
					<option value="운동">운동</option>
					<option value="스타일">스타일</option>
				</select>
			</td><br>
			<td><br>&nbsp;&nbsp;&nbsp;
				<select name="vt_dtype" id="vt_dtype" style="height:45px;width:300px;display: inline-block;padding: .5em .75em;border-bottom-color: #414141; border-radius: .25em;" >
					<option value="" selected disabled hidden>선택해주세요</option>
					<option value="a">1</option>
					<option value="b">2</option>
					<option value="c">3</option>
				</select>
			</td>
		</tr>
	</table><br><br><hr><br>
	<span id="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*</span>
	<span id ="main">투표 주제</span>
	<span id ="sub">호또는 불호로 나뉘는 하나의 투표주제를 선정해주세요.</span>
	<table align="center">
		<tr>
			<td width="800px">
				<span id="categori">투표 이름</span>
			</td>
		</tr><br>
		<tr>
			<td widht="800px"><br>&nbsp;&nbsp;
				<input type=text name="vt_name" id="true" style="height:45px ;width:725px;color:#808080;display: inline-block;padding: .5em .75em;border-bottom-color: #414141; border-radius: .25em;" placeholder="투표이름을 입력해주세요." required>
			</td>
		</tr>
		<br>
		<table align="center">
			<tr>
				<td width="800px">
					<span id="categori" >투표 대표 이미지</span>
				</td>
			</tr><br>
		</table>
		<br>
		<table border="1" width="750" height="300" border-color="#414141" align="center">
			<span id=blink>&nbsp;&nbsp;&nbsp;</span>
			<tr>
				<td>
					<br>
					<img id="user_image" src="#" alt="" ><br>
			 	 	<div class="upload">
						<label for="user_profile_img">업로드</label>
						<input accept=".jpg, .png" onchange="PreviewImage();" type="file" id="user_profile_img" name="vt_img_name" style="display:none;"required/><br>
						<input type=text id=text1 value="jpg 또는  png파일 형식만 업로드 가능합니다." disabled style="border:none;width:300px;"><br>
						<input type=text id=text2 value="사진이 너무작거나 클경우 깨질수 있습니다." disabled style="border:none;width:300px;">
					</div>
				</td>
			</tr>
		</table>
	</table>
	<br>
	<hr>
	<br>
	<span id ="main">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;투표 마감 기한</span><span id ="sub">&nbsp;투표 마감 기한을 설정해주세요. 별도 설정하지 않을 경우 기본적으로 '3일'로 적용됩니다. 최대 30일까지 설정 가능합니다.</span>
	<br>
	<br>
	<table width="800" align="center">
		<tr>
			<td width=70px>
				<span id="categori">◎ 시작일</span>
			</td>
			<td width=250px>
				<hr size=5px width="90%" align=center color="gray">
			</td>
			<td width=250px>
				<span id="categori">◎ 종료일</span>
			</td>
		</tr>
	</table>
	<br>
	<table align="center">
		<tr>
			<td width=400px>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="datefield" type="date" name="vt_stdate" value="" style="width:300px;height:40px;font-size:15pt;border-bottom-color: #e2e2e2; border-radius: .25em;">
			</td>
			<td width=400px>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='date' id='nextdate' name="vt_enddate" min="2020-10-10" max="2022-10-10" style="width:300px;height:40px;font-size:15pt;border-bottom-color: #e2e2e2; border-radius: .25em;"/>
			</td>
		</tr>
	</table>
	<br>
	<table align="center">
		<tr>
			<td width="100%" align="center">
				<input id="submit" type="submit" value="새로운 투표조사 생성하기" style="width:500px;
				background-color:#474747;	
				font-size:25pt;
				height:100px;
				color:white;
				font-weight:bold;
				display: inline-block;
				padding: .5em .75em;
				border-bottom-color: #408080;
				 border-radius: .25em;">
			</td>
		</tr>
	</table>
</form>
</body>
</html>