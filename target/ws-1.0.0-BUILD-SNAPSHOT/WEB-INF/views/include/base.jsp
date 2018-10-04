<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
	<link rel="stylesheet" href="./resources/css/bootstrap-grid.min.css" />
	<script type="text/javascript" src="./resources/js/jQuery-2.1.4.min.js"></script>
	<script>
	$(document).ready(function(){
	$(function(){
		  $(window).scroll(function(){
		    var winTop = $(window).scrollTop();
		    if(winTop >= 30){
		      $("body").addClass("sticky-header");
		    }else{
		      $("body").removeClass("sticky-header");
		    }//if-else
		  });//win func.
		});//ready func.
	});
	</script>
</head>
<body>

<header>
    <h1>ANYWHERE</h1>
    <nav>
      <a href="home">Home</a>
      <a href=""> 추천여행지 </a>
      <a href=""> 평가추가하기 </a>
      <a href=""> MyPage </a>
      <!-- <img src="./resources/img/person.png" width="45px" height="45px" padding="10px" ></img> -->
      <a href="logout"> 로그아웃 </a>
    </nav>
  </header>

