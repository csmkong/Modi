<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ǰ �߰�</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/itemInsert.do" method="post" enctype="multipart/form-data">
	<table>
	<tr>
	<td>�귣��</td>
	<td>
		<select name="brand">
			<option value="modi" selected="selected">��� ����</option>
		</select>
	</td>
	</tr>
	<tr>
	<td>��ǰ Ÿ��</td>
	<td>
		<ul>
		<li><input type="radio" name="item_type" value="gel" checked="checked">������</li>
		<li><input type="radio" name="item_type" value="nomal">�Ϲ�</li>
		</ul>
	</td>
	</tr>
	<tr>
	<td>����</td>
	<td><input type="file" name="file"></td>
	</tr>
	<tr>
	<td>��ȣ</td><td><input type="number" name="item_code"></td>
	</tr>
	<tr>
	<td>�̸�</td>
	<td><input type="text" name="item_name"></td>
	</tr>
	<tr>
		<td colspan="1">
		<input type="submit" value="���">
		</td>
	</tr>
	</table>
</form>
</body>
</html>