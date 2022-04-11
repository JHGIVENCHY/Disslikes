/**
 * 
 */
$(function(){
	var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	$('#pw1').keyup(function(){ // 비번검사 1
		$('#chkNotice3').html('');
	});
	$('#pw1').keyup(function(){ // 비번형식 검사
		if(!reg_pwd.test($('#pw1').val())){
			$('#chkNotice2').html('비밀번호는 숫자+영어 6~20자');
			$('#chkNotice2').attr('color', 'RED');
		} else{
			$('#chkNotice2').html('');
		}
	});
	$('#pw2').keyup(function(){ // 비번검사2
		if($('#pw1').val() != $('#pw2').val()){
			$('#chkNotice3').html('비밀번호 불일치');
			$('#chkNotice3').attr('color', 'RED');
		} else{
			$('#chkNotice3').html('');
		}
	});
	$('#email1').keyup(function(){ // 이메일검사
		if($('#email1').val().indexOf('@') == -1 || $('#email1').val().indexOf('.com') == -1){
			$('#chkNotice1').html('@, .com필수');
			$('#chkNotice1').attr('color', 'RED');
		}else{
			$('#chkNotice1').html('');
		}
	})
});