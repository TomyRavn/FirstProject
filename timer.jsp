<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Timer</title>
<script type="javascript">
	var SetTime = 30;
	function msg_time(){
	s = Math.floor(SetTime%60) + "초";
	
 	var msh = "문제풀이 남은 시간 : " + s +" 입니다.";
	
	document.all.ViewTimer.innerHTML = msg;
	SetTime--;

	if(SetTime < 0){
	clearInterval(tid);
		}
	}
	window.onload = function TimerStart(){tid=setInterval('msg_time()'1000};
</script>
</head>
<body>
	<div id = "ViewTimer"></div>
</body>
</html>