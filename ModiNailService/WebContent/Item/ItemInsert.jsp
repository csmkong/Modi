<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>제품 추가</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/itemInsert.do" method="post" enctype="multipart/form-data">
	<table>
	<tr>
	<td>브랜드</td>
	<td>
		<select name="brand">
			<option value="modi" selected="selected">모디 네일</option>
		</select>
	</td>
	</tr>
	<tr>
	<td>제품 타입</td>
	<td>
		<ul>
		<li><input type="radio" name="item_type" value="gel" checked="checked">젤네일</li>
		<li><input type="radio" name="item_type" value="nomal">일반</li>
		</ul>
	</td>
	</tr>
	<tr>
	<td>파일</td>
	<td><input type="file" name="file"></td>
	</tr>
	<tr>
	<td>번호</td><td><input type="number" name="item_code"></td>
	</tr>
	<tr>
	<td>이름</td>
	<td><input type="text" name="item_name"></td>
	</tr>
	<tr>
		<td colspan="1">
		<input type="submit" value="등록">
		</td>
	</tr>
	</table>
</form>
</body>
</html>