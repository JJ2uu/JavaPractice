<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
<style>
	body {
		position: relative;
		font-family: 'Gowun Dodum', sans-serif;
		background: #f2f2f2;
		text-align: center;
	}
	table {
		margin-top: 20%;
		margin-left: auto;
		margin-right: auto;
	}
	a {
		text-decoration-line: none;
		margin: 10px;
		color: #fff;
	}
	button {
		width: 200px;
		height: 50px;
		padding: 0;
		margin-top: 10px;
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
</style>
<title>나의 일기장</title>
</head>
<body>
<table>
	<tr>
		<td><h3><%= session.getAttribute("name") %>님 환영합니다. </h3></td>
	</tr>
	<tr>
		<td><button><a href = "diary_bbs">일기장 보러가기</a></button></td>
	</tr>
</table>
</body>
</html>