<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
	
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
	
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

