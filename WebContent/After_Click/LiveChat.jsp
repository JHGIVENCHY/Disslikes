<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>라이브채팅</title>
<link rel="stylesheet" href="After_Click/css/livechat_style.css">
</head>
<body>
   <div>
   		<textarea id="chatLog" class="chat_log" readonly></textarea>
   </div>
   <form id="chat">
   		<input id="name" class="nickname" type="text" readonly>
    	<input id="message" class="message" type="text">
      	<input type="submit" class="btn_chat" value="입력"/>
   </form>
<!-- 아래의 내용을 시도하려했으나...실패 -->    
<!--    <div id="box" class="box">
   <script src="/socket.io/socket.io.js"></script> 1
   <script src="//code.jquery.com/jquery-1.11.1.js"></script>
   <script>
      var socket = io(); //1
      $('#chat').on('submit', function(e){ //2
        socket.emit('send message', $('#name').val(), $('#message').val());
        $('#message').val('');
        $('#message').focus();
        e.preventDefault();
      });
      socket.on('receive message', function(msg){ //3
        $('#chatLog').append(msg+'\n');
        $('#chatLog').scrollTop($('#chatLog')[0].scrollHeight);
      });
      socket.on('change name', function(name){ //4
        $('#name').val(name);
      });
    </script> -->
</body>
</html>