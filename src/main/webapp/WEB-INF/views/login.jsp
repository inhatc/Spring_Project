<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- import Css -->
<link rel="stylesheet" href="./resources/css/login.css">

<!-- import javaScript -->
<script type="text/javascript" src="./resources/js/jQuery-2.1.4.min.js"></script>
<!-- <script type="text/javascript" src="./resources/js/login.js"></script>  -->
<script>
$(document).ready(function(){
	
	var fromObj = $("form[role='form']");
	
	var result = '${msg}';

	if (result == 'success') {
		alert("비밀번호가 틀렸습니다.");
	}
	if (result == 'notEmail'){
		alert("아이디가 이메일형식이 아닙니다.");
	}
	/*
	$(".btn-warning").on("click", function(){
		self.location = "/board/listAll";
	})
	*/
	
	$("#btnLogin").on("click", function() {
		formObj.submit();
	});
});
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
  <form class="login" role="form" method="POST" action="home">
    <p class="title">Log in</p>
    <input type="text" name = "id" placeholder="Username" autofocus/>
    <i class="fa fa-user"></i>
    <input type="password" name="pw" placeholder="Password" />
    <i class="fa fa-key"></i>
    <button id="btnLogin">
      <i class="spinner"></i>
      <span class="state">Log in</span>
    </button>
  </form>
  </p>
</div>
</body>
</html>