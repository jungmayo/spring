<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User1::register</title>
</head>
<body>
	<h3>user1 등록</h3>
	
	<a href="/ch05/">처음으로</a>
	<a href="/ch05/user5/list">목록</a>
	
	<form action="/ch05/user5/register" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label><input type="radio" name="gender" value="M"/>남</label>
					<label><input type="radio" name="gender" value="F"/>여</label>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr"/></td>
			</tr>
			<tr>
				<td colspan="2" align ="right">
					<input type="submit" value="등록하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>