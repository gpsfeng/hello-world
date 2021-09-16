<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息新增</title>
<style type="text/css">
body {
	
	
	}
.center{
	border:2px solid #0018ff;
	background-color: #00a6ff;
	font-family:"Times New Roman", Times, serif;
	font-size:30px;
	top:35%;
	left:43%;
	position:absolute;
	padding-left: 20px;
	padding-right: 20px;
	padding-bottom: 20px;
	padding-top: 10px;
	
}
.center1{
	
	font-family:"Times New Roman", Times, serif;
	font-size:50px;
	top:60%;
	left:43%;
	position:absolute;
}
</style>
</head>
<body background="2.jfif">
<div class="center">
<form action="AdminServlet?action=add" method="post">
姓名:<input type="text" name=name><br>
性别:<input type="text" name=sex><br>
生日:<input type="text" name=birth><br>
地址:<input type="text" name=address><br>
电话:<input type="text" name=phone><br>
密码:<input type="text" name=password><br>
<div class="center1">
<input type="submit" style="font-size:20px " value="确定" > <br>
</div>
</form>
</div>


</body>
</html>