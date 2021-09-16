<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书查询</title>
</head>
<body>
<table border="1" cellpadding="1" cellspacing="0">
	<tr style=":font-weight:bold">
		<td>ISBN</td>
		<td>作者</td>
		<td>出版社</td>
		<td>语言</td>
		<td>价格</td>
		<td>分类号</td>
		<td>书名</td>
		<td>介绍</td>
		<td>出版时间</td>
		<td>数量</td>
		<td>分类名</td>
		<td>借书人</td>
		<td>借书日期</td>
		<td>归还日期</td>
		<td>借书次数</td>
	</tr>
	<c:forEach var="b" items="${findlist}">	
		<tr>
			<td>${b.ISBN}</td>
			<td>${b.author}</td>
			<td>${b.publish}</td>
			<td>${b.language}</td>
			<td>${b.price}</td>
			<td>${b.class_id}</td>
			<td>${b.name}</td>
			<td>${b.introduction}</td>
			<td>${b.pub_time}</td>
			<td>${b.number}</td>
			<td>${b.class_name}</td>
			<td>${b.borrowpeople}</td>
			<td>${b.lend_date}</td>
			<td>${b.back_date}</td>
			<td>${b.borrowtimes}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>