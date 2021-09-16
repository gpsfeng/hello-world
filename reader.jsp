<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户操作</title>
</head>
<body>
<input type="button" value="登录" onclick="location1()">	<br>
<input type="button" value="注册" onclick="location2()">	<br>
<script>
function location1(){
	window.location.href="Login.html";
}
function location2(){
	window.location.href="regist.jsp";
}
</script>
</body>
</html>