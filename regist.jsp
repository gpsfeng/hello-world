<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
<form action="ReaderServlet?action=regist" method="post">
<input type="text" name=name>姓名<br>
<input type="text" name=sex>性别<br>
<input type="text" name=birth>生日<br>
<input type="text" name=address>地址<br>
<input type="text" name=phone>电话<br>
<input type="text" name=password>密码<br>
<input type="submit" value="确定"> <br>
</form>
</body>
</html>