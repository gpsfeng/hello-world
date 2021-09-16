<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询到的用户信息</title>
</head>
<body>
<table border="1" cellpadding="1" cellspacing="0">
	<tr style=":font-weight:bold">
		<td>用户ID</td>
		<td>姓名</td>
		<td>性别</td>
		<td>生日</td>
		<td>地址</td>
		<td>电话</td>
	</tr>
	<c:forEach var="r" items="${list}">	
		<tr>
			<td>${r.reader_id}</td>
			<td>${r.name}</td>
			<td>${r.sex}</td>
			<td>${r.birth}</td>
			<td>${r.address}</td>
			<td>${r.phone}</td>
		</tr>
	</c:forEach>
</table>
<a href="readermanage.html">返回</a>
</body>
</html>