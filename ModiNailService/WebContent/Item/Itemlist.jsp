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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/Modistyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>My Modi Nail Item List</title>
</head>
<body>
	<ul id="GrandList">
	<%
		for(int i = 0; i < dtos.size() ;i++){
	%>
		<li class="localList">
		<ul class="Item" id="modi<%=dtos.get(i).getItem_code() %>">
			<li class="ItemCode"><%=dtos.get(i).getItem_code() %></li>
			<li class="ItemImg"><img src="<%=request.getContextPath() %>/Resources/<%=dtos.get(i).getFileName()%>"></li>
			<li class="ItemBrand"><%=dtos.get(i).getBrand()%></li>
			<li class="ItemType"><%=dtos.get(i).getItem_type() %></li>
			<li class="ItemName"><%=dtos.get(i).getItem_name() %></li>
		</ul>
		</li>
	<% 
		}
	%>
	</ul>
	<input type="button" onclick="javascript:window.location='itemInsert.do'" value="제품 등록">
</body>
</html>