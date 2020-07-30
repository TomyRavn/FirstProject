<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문제 풀기</title>
    
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/navi.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
</head>
<body>
    <!--<img scr="images/tetris.jpg"> -->
    <center class="cent">
    <div>
        <ul class="memName">
            <li><a href="<%=request.getContextPath()%>/memEdit.do" class="nameLink"><c:out value="${loginVo.memNickname}" /></a> 회원님, 안녕하세요.</li>
            <li><button class="btn btn-primary" type="button" onclick="location.href='./logout.do'">로그아웃</button>
        </ul>
        <ul class="bar">
            <a href="<%=request.getContextPath()%>/subMain.do"><img class="logo" src="<%=request.getContextPath()%>/images/logo.png"></a>
            <li><a href="<%=request.getContextPath()%>/ranking.do" class="button">랭킹</a></li>
            <li><a href="<%=request.getContextPath()%>/add.do" class="button">문제 출제</a></li>
            <li><a href="<%=request.getContextPath()%>/subMain.do" class="button">문제 리스트</a></li>
        </ul>
    </div>
        <hr>
    </center>   
    <br>
    
    <div class="sand">
        <img src="<%=request.getContextPath()%>/images/sand.png">
    </div>
    <div class="container">
        <center>
            <div id="wrap">
				<form action="${pageContext.request.contextPath}/main.do" method=post>
					<div class="questionCon">
                		<p id=q>- 문제 : <c:out value="${questionVo.questionExplain}" /></p>
                	</div>
                	<input class="myAns" name="myAns" placeholder="답을 입력하세요"/>
                
                	<br><br><br><br><br>
               
                	<button id='aaa' type="submit">다음문제</button>
                
                	<br /><br />

			    	<ul class="textBox">
			        	<li>
			        		<label>정답 <input id='correct' value='<c:out value="${countVo.corCount}" />' disabled/></label>
			    		</li>
			        	<li>
			        		<label>오답 <input id='error' value='<c:out value="${countVo.errCount}" />' disabled/></label>
			    		</li>
			        	<li>
			        		<label>전체 <input id='total' value='<c:out value="${countVo.totCount}" />' disabled/></label>
			        	</li>
                	</ul>
                	<div class="timer"></div>
				</form>  
			</div>
        </center>
    </div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
	<script type="text/javascript">
		function requestTime() {
			
			$.ajax({
				url : "${pageContext.request.contextPath}/data.do",
				dataType : "json"
			}).done(function(data) {
// 				if(data.num <= 0){
// 					location.href='./ranking.do';
// 				}else{
// 					$('.timer').html(data.num);	
// 				}
				if(data.l <= 0){
					location.href='./ranking.do';
				}else{
					$('.timer').html(data.l);	
				}
			}).fail(function(jqXHR, textStatus) {
				alert("Request failed: " + textStatus);
			});
		}
		
		requestTime();
		
		setInterval(function() {
			requestTime();
		}, 1000);
	</script>
</body>
</html>