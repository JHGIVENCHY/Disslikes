<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- 공통부분 -->
<!-- local css file -->
<link rel="stylesheet" href="frame/css/header_style.css"/>
<!-- CDN:Bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" 
integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous"/>
<!-- CDN:Font Awesome -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" 
integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css"/>
<!-- CDN:Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gugi&family=Noto+Sans+KR:wght@400;500;700;900&display=swap" rel="stylesheet"/>
<!-- 
-> css : font-family: 'Gugi', cursive; 
		 font-family: 'Do Hyeon', sans-serif;
		 font-family: 'Noto Sans KR', sans-serif;
 -->
<!-- CDN : jQuery, Bootstrap&Javascript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Popper.JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
 <!-- jQuery Custom Scroller CDN -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- local js file -->
<script type="text/javascript" src="frame/js/header_script.js"></script>
<!-- 공통부분 -->
<!DOCTYPE html>
	<nav id="sidebar">
		<div id="dismiss">
			<i class="far fa-times-circle fa-2x"></i>
		</div>
		<div class="sidebar-header">
			<p>dissLIKES</p>
		</div>
		<ul class="list-unstyled components">
			<li class="active">
				<a href="Main.do">홈</a>
			</li>
			<li>
				<%if(session.getAttribute("nick") == null){%>
				<a href="Sign-In.do">로그인/회원가입</a>
				<%}%>
			</li>
			<li>
				<a href="allList.do">진행중인 투표</a>
			</li>
			<li>
				<a href="getAllCloseList.do">종료된 투표</a>
			</li>
		</ul>
	</nav>
<div class="container py-5">
	<div class="row align-items-center">
		<div class="pb-3 col-3">
			<nav class="navbar navbar-expand-lg">
				<div class="container-fluid">
					<button type="button" id="sidebarCollapse" class="btn">
						<i class="fas fa-bars fa-2x"></i>
					</button>
				</div>
			</nav>
		</div>
		<div class="col-6 text-center">
			<a id="home" href="Main.do">dissLIKES</a>
		</div>
		<div class="pb-4 col-3 text-end">
			<%if(session.getAttribute("nick") == null){%>
			<a style="font-family: 'Noto Sans KR', sans-serif;
						font-size: 18pt;
						font-weight: 500;
						color: #212121;
						text-decoration:none;" href="Sign-In.do">로그인/회원가입</a>
			<%}else{%>
			<a style="font-family: 'Noto Sans KR', sans-serif;
						font-size: 18pt;
						font-weight: 500;
						color: #212121;
						text-decoration:none;" href="Login/logout.jsp">로그아웃</a>
			<%}%>
		</div>
	</div>
</div>
