<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅排行</title>
</head>
<body>
<table border="1" cellpadding="1" cellspacing="0">
	<tr style=":font-weight:bold">
	<td>书名</td>
	<td>借书次数</td>
	</tr>
<c:forEach var="b" items="${list2}">	
		<tr>
		<td>${b.name}</td>
		<td>${b.borrowtimes}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>