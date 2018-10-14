<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./include/base.jsp"%>
<link rel="stylesheet" href="./resources/css/main.css">
<script>
$(document).ready(function(){

	var fromObj = $("form[role='form']");
	
	var result = '${msg}';
	
	function btnConSubmit(){
		var result1 = 0;
		if($(".inputCon").value==null && $(".inputCon").value=="" ){
			alert('입력값을 확인하세요.');
		}else{
			result1=1;
		}
		
		if(result1==1){
			$(".btnConfirm").on("click", function() {
				formObj.submit();
			});			
		}
	}
	
	if (result == 'fail') {
		alert("인증번호가 틀립니다 ");
	}else if(result == 'success'){
		alert("인증번호 인증 완료 ");
	}
	/*
	$(".btn-warning").on("click", function(){
		self.location = "/board/listAll";
	})
	*/
	
	
});
</script>
  <div class="wrapper">
    <section id='steezy'>
      <h2> MY PAGE</h2>
      <p>ID / E-mail : ${vo.getId()}</p>
	<c:set var="name" value='${vo.getConfirm()}'/>
	<c:choose>
		<c:when test="${name eq '0'}">
			<p>인증상태 : 인증필요 </p>
			<form role = "form" method="POST" action="/myapp/emailAuth">
				<p><input class="class=btn blue" type="submit" value="인증번호 발송"></p>
			</form>
			<form role = "form" method="POST" action="/myapp/myPage">
				<p><input class="inputCon" type="text" name="inputConfirm"><input class="btnConfrim" type="submit" value="확인" ></p>
				<p></p>
			</form>
      	</c:when>
      	<c:when test="${name eq '1' }">
    			<p>인증상태 : 인증완료 </p>  	
      	</c:when>
	</c:choose>	
      <p></p>
    </section>
 </div>
  
</body>
</body>
</html>
