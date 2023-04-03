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
	body {
		display: block;
		font-family: 'Gowun Dodum', sans-serif;
		text-align: center;
		padding: 0;
		margin: 0;
	}
	.content {
		height: 50%;
	}
	th {
		padding: 10px;
		background: #24abff;
		color: #fff;
	}
	.table_content {
		border-bottom: 1px solid #d1d1d1;
	}
	td {
		padding: 10px;
	}
	table {
		margin-top: 3%;
		margin-left: auto;
		margin-right: auto;
		width: 60%;
		border-collapse: collapse;
		border-bottom: 1px solid #24abff;
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
	#no {
		width: 10%;
	}
	#time {
		width: 20%;
	}
	.header {
		width: 100%;
		border-bottom: 1px solid #000;
		
	}
	.header_content {
		display: flex;
		width: 60%;
		margin-left: auto;
		margin-right: auto;
		justify-content: space-between;
		padding: 2% 0 2% 0;
	}
	h1 {
		margin: 0;
		padding-left: 3%;
	}
	.search {
		margin: 1% 0 3% 0;
	}
	
	.write {
		display: flex;
		width: 60%;
		margin-left: auto;
		margin-right: auto;
		justify-content: flex-end;
		padding-top: 10px;
		padding-right: 30px;
	}
	
	#writerButton {
		width: 100px;
		height: 40px;
		border-color: transparent;
		background: #24abff;
		color: #fff;
		border-radius: 5px;
	}
	
	#writerButton:hover {
		background: #575757;
		transition: 0.6s;
	}
	
	#searchSelect {
	  width: 100px; /* 가로 사이즈 */
	  padding: 10px; /* 내부여백 */
	  padding-left: 12px;
	  border: 1px solid #ddd;
	  background: url(resources/img/arrow_down_18dp.png) no-repeat right 50%; /* 화살표 위치 */
	  background-size: 30px; /* 화살표 크기 */
	  border-radius: 4px;
	  box-sizing: border-box;
	  -webkit-appearance: none;
	  -moz-appearance: none;
	  appearance: none;
	  font-size: 12px;
	  color: #000;
  	  outline:none;
	}
	#searchSelect:hover {
		border: 1px solid #aaa;
	}
	
	#searchInput {
		width: 300px;
		height: 31px;
		border: 1px solid #aaa;
		border-radius: 4px;
	}
	
	#searchInput:focus {
		outline-style: none;
		border: 1px solid #000;
	}
	
	#searchButton {
		width: 60px;
		height: 37px;
		border-style: none;
		background: #000;
		color: #fff;
		border-radius: 4px;
		text-align: center;
	}
	.footer {
		width: 100%;
		height: 80px;
		background: #000;
		color: #fff;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	p {
		font-size: small;
	}
	
	a {
		text-decoration: none;
		color: #000;
	}
	
	a:hover {
		color: #24abff;
	}

</style>

</head>
<body>
<div class = "header">
	<div class = "header_content">
		<h1>나의 일기장</h1>
		<ul class = "menu">
			<li>내 정보</li>
			<li id = "line">|</li>
			<li><a href = "diary_home.jsp">로그아웃</a></li>
		</ul>
	</div>
</div>
<div class = "content">
	<div class = "list">
		<table>
			<tr class = "table_title">
				<th id = "no">No</th>
				<th id = "title">제목</th>
				<th id = "time">날짜</th>
			</tr>
			<c:forEach items="${list}" var="bag">
				<tr class = "table_content">
					<td>${bag.no}</td>
					<td>${bag.title}</td>
					<td>${bag.time}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class = "write">
		<button id = "writerButton">글쓰기</button>
	</div>
	<div class = "search">
		<select id = "searchSelect">
			<option>제목 + 내용</option>
			<option>글 제목</option>
			<option>글 번호</option>
		</select>
		<input type = "text" id = "searchInput" placeholder="검색어를 입력하세요.">
		<button id = "searchButton">검색</button>
	</div>
</div>
<div class = "footer">
	<p>Copyrightⓒ 2023. JJ2uu. All rights reserved.</p>
</div>

</body>
</html>