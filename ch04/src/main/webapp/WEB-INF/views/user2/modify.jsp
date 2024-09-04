
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User1::register</title>
</head>
<body>
	<h3>user1 수정</h3>
	
	<a href="/ch04/">처음으로</a>
	<a href="/ch04/user2/list">목록</a>
	
	<form action="/ch04/user2/modify" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" value="${user2DTO.uid}"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${user2DTO.name}"/></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="birth" value="${user2DTO.birth}"/></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="${user2DTO.hp}"/></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" value="${user2DTO.addr}"/></td>
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