<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>

<section>
	<div id="wrap" align="center">
		<h1>홈쇼핑 회원 등록</h1>
		<form method="post" action="memberregister.do" name="frm" >
			<table class="center">
				<tr>
					<th>회원번호(자동생성)</th>
					<td><input type="text" name="custno" value="<c:out value="${custno }"/>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate"></td>
				</tr>
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]</th>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<th>거주도시</th>
					<td><input type="text" name="city"></td>
				</tr>
				<tr class="center">
					<td colspan="2">
						<input type="submit" value="등록" onclick="return registerCheck()">
						<input type="button" value="조회" onclick="location.href='memberlist.do'">
					
					</td>
				</tr>
				
			</table>
				
		</form>
	</div>

</section>
<%@include file="footer.jsp" %>