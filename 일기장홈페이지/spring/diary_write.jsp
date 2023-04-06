<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 일기장 게시판</title>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
<style>
	html, body {
		font-family: 'Gowun Dodum', sans-serif;
		height: 100%;
		padding: 0;
		margin: 0;
	}
	#wrap {
		display: flex;
	    min-height: 100%;
	    text-align: center;
	    flex-direction: column;
	}
	#header {
		width: 100%;
		border-bottom: 1px solid #ccc;
		
	}
	#content {
		flex: 1;
		padding: 20px;
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	#footer {
		width: 100%;
		padding: 30px 0;
		background: #000;
		color: #fff;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	p {
		font-size: small;
		margin: 0px;
	}
	
	/* header */
	h1 {
		margin: 0;
		padding-left: 3%;
	}
	.header_content {
		display: flex;
		width: 60%;
		margin-left: auto;
		margin-right: auto;
		justify-content: space-between;
		padding: 2% 0 2% 0;
	}
	.menu {
		list-style-type: none;
		padding-right: 10%;
		display: flex;
	}
	#line {
		margin-left: 10px;
		margin-right: 10px;
	}
	a {
		text-decoration: none;
		color: #000;
	}
	a:hover {
		color: #24abff;
	}
	
	/* 글쓰는 곳 */
	#bbs_title {
		width: 100%;
		height: 40px;
	}
	#bbs_content {
		width: 100%;
		margin-top: 10px;
		line-height: 1.2;
	}
	.button {
		margin-top: 20px;
		margin-bottom: 30px;
	}
	#submit {
		width: 100px;
		height: 40px;
		border-color: transparent;
		background: #24abff;
		color: #fff;
		border-radius: 5px;
	}
	#submit:hover {
		background: #575757;
		transition: 0.6s;
	}
	
	#cancle {
		width: 100px;
		height: 40px;
		border-color: transparent;
		background: #000;
		color: #fff;
		border-radius: 5px;
	}
	
	#today {
		display: flex;
		align-items: flex-end;
		margin-bottom: 10px;
	}
	
	#today_input {
		text-align: left;
		border-style: none;
		margin-left: 5px;
	}
	form {
		width: 50%;
	}
</style>
<script type="text/javascript" src = "resources/js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	$('document').ready(function() {
		now = new Date();
		console.log(now);
		year = now.getFullYear();
		month = now.getMonth();
		month += 1;
		if (month <= 9){
		    month = "0" + month;
		}
		day = now.getDate();
		if (day <= 9){
		    day = "0" + day;
		}
		
		console.log(year)
		console.log(month)
		console.log(day)
		
		today = year + "-" + month + "-" + day
		console.log(today)
		
		$("#today_input").attr("value", today)
		})
</script>
</head>
<body>
<div id = "wrap">
	<div id = "header">
		<div class = "header_content">
			<h1>나의 일기장</h1>
			<ul class = "menu">
				<li>내 정보</li>
				<li id = "line">|</li>
				<li><a href = "logout">로그아웃</a></li>
			</ul>
		</div>
	</div>
	<div id = "content">
		<h3>오늘의 일기</h3>
		<form action = "diary_bbs_insert" method="get">
			<div id ="today">
			<p style ="text-align: left; margin: 0;">오늘 날짜 : </p>
			<input id="today_input" name ="time" value="" readonly onfocus="this.blur()">
			</div>
			<input id = "bbs_title" placeholder="Title" name = "title">
			<textarea rows="20" cols="100" id = "bbs_content" placeholder="Input some text." name="content"></textarea>
			<div class="button">
				<button id = "submit" type="submit">작성완료</button>
				<button id = "cancle">작성취소</button>
			</div>
		</form>
	</div>
	<div id ="footer">
		<p>Copyrightⓒ 2023. JJ2uu. All rights reserved.</p>
	</div>
</div>
</body>
</html>