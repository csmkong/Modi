<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.csmkong.ModiNailService.DAO.ItemDAO" %>
<%@ page import="com.csmkong.ModiNailService.DTO.ItemDTO" %>
<%
	ItemDAO dao = new ItemDAO();
	ArrayList<ItemDTO> dtos = dao.selectItem();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="Action">action</a>
	<%
		for(int i = 0; i < dtos.size() ;i++){
		out.println(dtos.get(i).getItem_code()+"<br/>");
		}
	%>
</body>
</html>