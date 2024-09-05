
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User1::register</title>
</head>
<body>
	<h3>user1 수정</h3>
	
	<a href="/ch05/">처음으로</a>
	<a href="/ch05/user4/list">목록</a>
	
	<form action="/ch05/user4/modify" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" value="${user4DTO.uid}" readonly/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${user4DTO.name}"/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label><input type="radio" name="gender" value="M" <c:if test="${user4DTO.gender=='M'}"> checked</c:if>/>남</label>
					<label><input type="radio" name="gender" value="F" <c:if test="${user4DTO.gender=='F'}"> checked</c:if>/>여</label>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" value="${user4DTO.age}"/></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="${user4DTO.hp}"/></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" value="${user4DTO.addr}"/></td>
			</tr>
			<tr>
				<td colspan="2" align ="right">
					<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>