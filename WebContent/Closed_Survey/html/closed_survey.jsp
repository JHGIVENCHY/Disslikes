<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ sVo.vt_name }</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
</head>

<link rel="stylesheet" href="Closed_Survey/css/closed_survey_style.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<body>
<div class="wrapper">
<!-- 공통헤더 -->
<header>
	<c:import url="/frame/html/header.jsp"></c:import>
</header>
<section id="mid">
	<div class="container" id="to_list">
		<a href="getAllCloseList.do">목록으로</a>
	</div>
	<div class="container text-center mt-3 survey-name">
		<a class="btn btn-outline-secondary order-1 order-lg-0 fw-medium" href="#!">${ sVo.vt_type } > ${ sVo.vt_dtype }</a>
		<!-- <p id="content-name">반바지&레깅스 레이어드</p> -->
		<p id="content-name">${ sVo.vt_name }</p>
	</div>
	<div class="container text-center survey-result">
		<div class="row">
			<div class="col">
				<div class="container">
					<img class="survey-img" src="${sVo.vt_img_path}">
					<div class="overlay align-self-center">종료된 투표입니다.<br>
						<span class="closed_won">${ sVo.getWonSurv() }</span> 가 <span class="closed_gap">${ sVo.getGapSurv() }</span> 표<br>
						차이로 이겼습니다.
					</div>
				</div>
			</div>
			<div class="col">
				<p class="align-top mt-n3 d-day">투표 종료 D-${ sVo.getDday() }</p>
				<p class="align-top d-timer">00 : 00 : 00 : 00</p>
				<div class="container chart mx-5">
					<div class="overlay-chart align-self-center">
						<span class="chart_won">${ sVo.getWonSurv() }</span><br>
						${ sVo.getPercentSurv() }%
					</div>	
		 			<canvas id="myChart" width="400" height="400"></canvas>
				</div>
			</div>
		</div>
	</div>
	<br><br>
	<div class="container text-center d-grid gap-2 col-6 mx-auto mt-3 survey-other">
		<button type="button" class="btn btn-warning rounded-pill" onclick = "location.href = 'allList.do'">다른 투표 참여하기</button>
	</div>
	<br><br>
</section>
</div>
<div class="all_overlay"></div>
<script type="text/javascript" src="Closed_Survey/js/closed_survey_script.js"  data-agnum=${ sVo.vt_ag_num } data-dagnum=${ sVo.vt_dag_num } data-agwon=${ sVo.getWonSurv() }></script>
</body>
</html>