<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
	<tr class="table_title">
		<th id="no">No</th>
		<th id="title">제목</th>
		<th id="time">날짜</th>
	</tr>
	<c:forEach items="${list}" var="bag">
		<tr class="table_content">
			<td>${bag.no}</td>
			<td>${bag.title}</td>
			<td>${bag.time}</td>
		</tr>
	</c:forEach>
</table>