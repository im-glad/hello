<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>
<section>
	<div id="wrap" align="center">
		<h1>회원목록조회/수정</h1>
		<table class="center" style="width: 700px">
			<tr><th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th></tr>
			<c:forEach var="member" items="${sellList}">
				<tr class="record">
					<td>${member.custno }</td>
					<td>${member.custname }</td>
					<td>${member.grade}</td>
					<td>${member.price}</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>

</section>

<%@include file="footer.jsp" %>