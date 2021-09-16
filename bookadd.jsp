<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书入库</title>
<style type="text/css">
body {     
	
    background: #e1e5e8;
	
	font-size: 25px;
	line-height: 50px;
	color: #888;
	padding-top: 300px;
}
.button { /* 按钮美化 */
	width: 270px; /* 宽度 */
	height: 40px; /* 高度 */
	border-width: 0px; /* 边框宽度 */
	border-radius: 3px; /* 边框半径 */
	background: #1E90FF; /* 背景颜色 */
	cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
	outline: none; /* 不显示轮廓线 */
	font-family: Microsoft YaHei; /* 设置字体 */
	color: white; /* 字体颜色 */
	font-size: 17px; /* 字体大小 */
}
.login-button:hover { /* 鼠标移入按钮范围时改变颜色 */
	background: #5599FF;
}
</style>
</head>
<body>
请输入图书的ISBN号、名称、分类id和分类名称<br>
<div align="center">
<form action="AdminServlet?action=bookadd" method="post">
ISBN：<input type="text" name=ISBN><br>
名称：<input type="text" name=name><br>
分类id：<input type="text" name=class_id><br>
分类名称：<input type="text" name=class_name><br>
<input class="button"type="submit" value="确定"> <br>
</form>
</div>
</body>
</html>