<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="header.jsp" %>

<section>
	<div id="wrap" align="center">
		<h1>회원목록조회/수정</h1>
		<table class="center">
			<tr><th>회원번호</th><th>회원성명</th><th>전화번호</th><th>주소</th><th>가입일자</th><th>고객등급</th><th>거주지역</th></tr>
			<c:forEach var="member" items="${memberList}">
				<tr class="record">
					<td><a href="membermodify.do?custno=${member.custno}">${member.custno }</a></td>
					<td>${member.custname }</td>
					<td>${member.phone }</td>
					<td>${member.address}</td>
					<td>${member.joindate }</td>
					<td>${member.grade}</td>
					<td>${member.city}</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>

</section>
<%@include file="footer.jsp" %>