<%@page import="multi.mySQL_memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="bag" class = "multi.mySQL_memberVO"></jsp:useBean>
    <jsp:setProperty property="*" name="bag"/>
    
    <%
    mySQL_memberDAO dao = new mySQL_memberDAO();
    dao.insert(bag);
    %>
    
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
		width: 100px;
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
		<td><h3>회원가입이 완료되었습니다.</h3></td>
	</tr>
	<tr>
		<td><button><a href = "home.html">로그인하기</a></button></td>
	</tr>
</table>
</body>
</html>