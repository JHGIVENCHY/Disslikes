<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Countdown</title>
<link rel="stylesheet" href="After_Click/css/countdown_style.css">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
<!-- 여기도 시간과 연동시켜야 한다. -->
<!-- <h1>2021년 12월 15일까지 </h1> -->
<div style="font-weight: bold;">투표종료 D-${ iVo1.getDday() }</div> 
<div id="Timer01" style="color:#fe5744; font-size: 50px; font-weight: bold;"></div>
<br/> 

<script> 
   const countDownTimer = function (id, date) { 
   var _vDate = new Date(date); // 전달 받은 일자 
   var _second = 1000; 
   var _minute = _second * 60; 
   var _hour = _minute * 60; 
   var _day = _hour * 24; 
   var timer; 
   
   function showRemaining() { 
      var now = new Date(); 
      var distDt = _vDate - now; 
      
      if (distDt < 0) { 
         clearInterval(timer); document.getElementById(id).textContent = '해당 이벤트가 종료 되었습니다!'; 
         return; 
         } 
      
      var days = Math.floor(distDt / _day); 
      var hours = Math.floor((distDt % _day) / _hour); 
      var minutes = Math.floor((distDt % _hour) / _minute); 
      var seconds = Math.floor((distDt % _minute) / _second); 
      
      //document.getElementById(id).textContent = date.toLocaleString() + "까지 : "; 
      document.getElementById(id).textContent = days + ' : '; 
      document.getElementById(id).textContent += hours + ' : '; 
      document.getElementById(id).textContent += minutes + ' : '; 
      document.getElementById(id).textContent += seconds; 
      } 
   
   timer = setInterval(showRemaining, 1000); 
   } 
   
   var dateObj = new Date(); 
   dateObj.setDate(dateObj.getDate() + 1); 
   
   ${ iVo1.vt_enddate }
   countDownTimer('Timer01', '${ iVo1.vt_enddate }'); 
   /* countDownTimer('Timer01', '12/15/2021 00:00 AM');  */
</script>


</body>
</html>