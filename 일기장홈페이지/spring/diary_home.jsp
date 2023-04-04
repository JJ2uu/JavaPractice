<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 일기장</title>

<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
<style>
	html, body {
		font-family: 'Gowun Dodum', sans-serif;
		background: #f2f2f2;
		height: 100%;
		padding: 0;
		margin: 0;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	#wrap {
		text-align: center;
		min-height: 400px;
	}
	input {
		width: 250px;
		height: 50px;
		margin: 5px;
		padding: 0;
		border-color: transparent;
		border-radius: 6px;
	}
	input:focus {
		outline: 2px solid #24abff;
		border-radius: 6px;
		outline-offset: 0;
		border-color: transparent;
	}
	button {
		width: 250px;
		height: 40px;
		margin: 5px;
		margin-bottom: 20px;
		color: #fff;
		background: #24abff;
		border-color: transparent;
		border-radius: 6px;
	}
	button:hover {
		color: #fff;
		background: #000;
		border-color: transparent;
		transition: 0.5s;
		border-radius: 6px;
	}
	a {
		text-decoration-line: none;
		margin: 10px;
		color: black;
	}
	a:hover {
		color: #24abff;
		transition: 0.5s;
	}
</style>
</head>
<body>
<div id = "wrap">
	<div id = "header">
		<p class = "imoji">&#128512;</p>
		<h2>나만의 일기장</h2>
		<hr>
	</div>
	<div id ="content">
	<form action = "login" method="get">
	<table>
		<tr>
		 	<td>
		 		<input type = "text" name = "id" class = "login" placeholder=" 아이디" onfocus="this.placeholder=''" onblur="this.placeholder='아이디'">
			</td>
		</tr>
		<tr>
			<td>
				<input type = "password" name = "pw" class = "login" placeholder=" 비밀번호" onfocus="this.placeholder=''" onblur="this.placeholder='비밀번호'">
			</td>
		</tr>
		<tr>
			<td>
				<button id ="loginButton" type ="submit">Login</button>
			</td>
		</tr>
	</table>
	</form>
		<div class = "login">
			<a href = "diary_join.jsp">회원가입</a>
			|
			<a href = "pwSearch.jsp">비밀번호 찾기</a>
		</div>
	</div>
</div>
</body>
</html>
