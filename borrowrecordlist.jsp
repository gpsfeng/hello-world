<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅记录</title>
</head>
<body>
所有图书的借阅记录如下:
<table border="1" cellpadding="1" cellspacing="0">
	<tr style=":font-weight:bold">
		<td>ISBN</td>
		<td>书名</td>
		<td>借书人</td>
		<td>借书日期</td>
		<td>归还日期</td>
	</tr>
	<c:forEach var="b" items="${borrowlist}">	
		<tr>
			<td>${b.ISBN}</td>
			<td>${b.name}</td>
			<td>${b.borrowpeople }</td>
			<td>${b.lend_date}</td>
			<td>${b.back_date}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>