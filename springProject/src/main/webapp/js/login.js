//ajax로 로그인을 처리할 때는 자바스크립트이기 때문에 데이터에 접근할 수 있으므로,
//로그인 인터셉터나 컨트롤러에서 따로 접근을 막아주어야 함
    	
let isSuccess = false;
    	
function check(){

	$.ajax({
		url : "${pageContext.request.contextPath}/loginajax.do",
		data : $('#loginForm').serialize(),
		dataType : "json"
	}).done(function(data) {
		console.log(data.loginVo);
		
		if(data.loginVo != null){
			isSuccess = true;	
		}else{
			isSuccess = false;
		}
		
		console.log(isSuccess);
		if(!isSuccess) $('#alert').show();
		else location.href='./subMain.do';
		
	}).fail(function(jqXHR, textStatus) {
		alert("Request failed: " + textStatus);
	});
	
}