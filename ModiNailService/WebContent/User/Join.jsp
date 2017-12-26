<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Join</title>
</head>
<body>
	<form action="JoinCheck" method="Post">
	<Table>
	
	<tr>
		<td>ID
		</td>
		<td>
			<input type="text" name="id">
		</td>
	</tr>
	
	<tr>
		<td>PW
		</td>
		<td>
			<input type="password" name="pw">
		</td>
	</tr>
	
	<tr>
		<td>Confirm PW
		</td>
		<td>
			<input type="password" name="confirm_pw">
		</td>
	</tr>
	
	<tr>
		<td>Name
		</td>
		<td>
			<input type="text" name="name">
		</td>
	</tr>
	
	<tr>
		<td>Phone Number
		</td>
		<td>
			<input type="number" name="phone1" maxlength="4">-
			<input type="number" name="phone2" maxlength="4">-
			<input type="number" name="phone3" maxlength="4">
		</td>
	</tr>
	
	<tr>
		<td>E-mail
		</td>
		<td>
			<input tpye="text" name="email">
		</td>
	</tr>
	
	<tr>
		<td>
			<input type="submit" value="Join">
		</td>
		<td>
			<input type="reset" value="reset">
		</td>
	</tr>
	
	</Table>
	</form>
</body>
</html>