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
		margin: 0;
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
	table {
		margin-top: 3%;
		margin-left: auto;
		margin-right: auto;
		width: 20%;
		border-collapse: collapse;
		text-align: left;
	}
	
	th, td {
		border-bottom: 1px solid #d1d1d1;
		padding: 10px;
	}
	#profile {
		margin-top: 3%;
		margin-left: auto;
		margin-right: auto;
		width: 120px;
		height: 120px;
		background: black;
		border-radius: 50%;
		display: flex;
		justify-content: center;
		align-items: center;
		 overflow:hidden;
	}
	#profile_img {
		width: 140px;
		object-fit:cover;
	}
	
	#back {
		width: 100px;
		height: 40px;
		border-color: transparent;
		background: #24abff;
		color: #fff;
		border-radius: 5px;
		margin: 20px;
	}
	#back:hover {
		background: #575757;
		transition: 0.6s;
	}
	
	#pwUp {
		background-color: rgba(212,216,229,.25);
		border: solid 1px rgba(212,216,229,.5);
		color: #7b8994;
		width: 47px;
		border-radius: 4px;
		padding: 2px 9px 3px;
	}
	
	

</style>
<script type="text/javascript" src = "resources/js/jquery-3.6.4.js"></script>
<script type="text/javascript">

	
</script>
</head>
<body>
<div id = "wrap">
	<div id = "header">
		<div class = "header_content">
			<h1><a href = "diary_bbs">나의 일기장</a></h1>
			<ul class = "menu">
				<li><a href = "diary_myPage.jsp">내 정보</a></li>
				<li id = "line">|</li>
				<li><a href = "logout">로그아웃</a></li>
			</ul>
		</div>
	</div>
	<div id = "content">
		<h3>My Page</h3>
		<div id = "profile">
		<img src ="resources/img/profile.jpg" id = "profile_img">
		</div>
		<table>
			<tr>
				<th>이름</th>
				<td colspan="2"><%= session.getAttribute("name") %></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td colspan="2"><%= session.getAttribute("id") %></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><%= session.getAttribute("pw") %></td>
				<td style="text-align: right;"><button id = "pwUp">수정</button></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td colspan="2"><%= session.getAttribute("tel") %></td>
			</tr>
		</table>
	</div>
	<div id ="footer">
		<p>Copyrightⓒ 2023. JJ2uu. All rights reserved.</p>
	</div>
</div>
</body>
</html>