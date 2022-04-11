<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <title>${ iVo.vt_name }</title> --%>
<title>dissLikes</title>
<link rel="stylesheet" href="After_Click/css/style.css">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!-- <script type="text/javascript" src="../After_Click/jquery-3.6.0.js"></script> -->
<body>
<section id="container">

   <div class=btn_ca><button class="btn_category">${iVo1.vt_type} > ${iVo1.vt_dtype}</button></div>
   <!-- 카테고리 정해지면 버튼변경 -->
   
   <div class=title>${ iVo1.vt_name }<!-- 민트초코 --></div><br>
   <!-- 민트초코는 예시입니다. -->
   
   <article class="block2-1">
      <!-- <div class="vote_img"> -->
         <img src="${iVo1.vt_img_path }" class="center" alt=center_img>
       <%-- <img src="${iVo.vt_img_name}" class="center"> 위에가 예시입니다 --%>
       <!-- </div> -->
       <div class="all_chart">
         <div class="cd_timer">
            <c:import url="Countdown.jsp"></c:import>
            <%-- <jsp:include page="Countdown.jsp"></jsp:include> --%>
         </div>
         <div class="vote_chart">
            <c:import url="Chart.jsp"></c:import>
            <%-- <jsp:include page="Chart.jsp"></jsp:include> --%>
         </div>
      </div>
   </article>
   
   <article class="block2-2">
      <div class="a_vote">
         <c:import url="AnotherSurvey.jsp"></c:import>
         <%-- <jsp:include page="AnotherSurvey.jsp"></jsp:include> --%>
      </div>
      <div class="chat">
         <c:import url="LiveChat.jsp"></c:import>
         <%-- <jsp:include page="LiveChat.jsp"></jsp:include> --%>
      </div>
   </article>
   
   <div class=url>투표 공유하기</div><br>
   
   <article class="block2-3">
      <a href="Kakao.Link.createScrapButton(PARAMETER);"><img src="After_Click/img/Kakao_logo.png" class="kakao"></a>
       <a href="https://line.me"><img src="After_Click/img/Line_logo.png" class="line"></a>
       <a href="https://twitter.com/"><img src="After_Click/img/Twitter_logo.png" class="twitter"></a>
       <a href="https://www.instagram.com/"><img src="After_Click/img/Instagram_logo.png" class="insta"></a>
    </article>
    
</section>

</body>
</html>