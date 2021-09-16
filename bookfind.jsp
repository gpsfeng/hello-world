<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书查询</title>
</head>
<body>
<form action="BookServlet?action=find" method="post">
请输入您要查询图书的ISBN号
<input type="text" name="ISBN"><br>
<input type="submit" value="确定">
</form>
</body>
</html>