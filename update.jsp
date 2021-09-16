<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lib.reader.Reader" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户个人信息管理</title>
</head>
<body>
<% Reader reader=(Reader)request.getSession().getAttribute("reader");%>
您的个人信息为:<br>
<table border="1" cellpadding="1" cellspacing="0">
	<tr style=":font-weight:bold">
		<td>用户ID</td>
		<td>姓名</td>
		<td>性别</td>
		<td>生日</td>
		<td>地址</td>
	</tr>
<tr>
			<td><%=reader.getReader_id() %></td>
			<td><%=reader.getName() %></td>
			<td><%=reader.getSex()%></td>
			<td><%=reader.getBirth() %></td>
			<td><%=reader.getAddress()%></td>
		</tr>
</table>
<a href="updateinfo.jsp">修改个人信息</a> 
<a href="updatepassword.jsp">修改密码</a> 
</body>
</html>