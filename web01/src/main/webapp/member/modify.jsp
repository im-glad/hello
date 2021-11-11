<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>

<section>
<div id="wrap" align="center">
	<h1>홈쇼핑 회원 정보 수정</h1>
	<form name="frm" method="post" action="membermodify.do" >
		<input type="hidden" name="custno" value="${member.custno }">
		<table class="center">
			<tr>
				<th>회원번호</th>
				<td>
				<input type="text" name="custno" value="${member.custno }">
				</td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td>
				<input type="text" name="custname" value="${member.custname }">
				</td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td>
				<input type="text" name="phone" value="${member.phone }">
				</td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td>
				<input type="text" name="address" value="${member.address }">
				</td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td>
				<input type="text" name="joindate" value="${member.joindate }">
				</td>
			</tr>
			<tr>
				<th>고객등급[A:VIP,B:일반,C:직원]</th>
				<td>
				<input type="text" name="grade" value="${member.grade }">
				</td>
			</tr>
			<tr>
				<th>도시코드</th>
				<td>
				<input type="text" name="city" value="${member.city }">
				</td>
			</tr>
			<tr class="center">
				<td colspan="2">
					<input type="submit" value="수정" onclick="return modifyCheck()">
					<input type="button" value="조회" onclick="location.href='memberlist.do'"> 
				
				</td>
			</tr>
			
		</table>
	</form>

</div>
</section>

<footer class="center">
	HRDKOREA Copyright 2016 All rights reserved Human Resources Development Service of Korea
</footer>	
</body>
</html>