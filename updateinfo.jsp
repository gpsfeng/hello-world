<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ReaderServlet?action=updateinfo" method="post">
账号 <input type="text" name="name"><br>
性别 <input type="text" name="sex"><br>
生日 <input type="text" name="birth"><br>
地址 <input type="text" name="address"><br>
电话 <input type="text" name="phone"><br>
<input type="submit" value="提交">
</form>
</body>
</html>