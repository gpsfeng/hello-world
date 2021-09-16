<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书查询</title>
<style type="text/css">
.center{
	font-family:"Times New Roman", Times, serif;
	font-size:30px;
	border:2px solid #00ffb4;
	background-color: #00a6ff;
	top:55%;
	left:30%;
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
	left:40%;
	position:absolute;
}
.button{
	width: 270px; /* 宽度 */
	height: 40px; /* 高度 */
	border-width: 0px; /* 边框宽度 */
	border-radius: 3px; /* 边框半径 */
	background: #1eeaff; /* 背景颜色 */
	cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
	outline: none; /* 不显示轮廓线 */
	font-family: Microsoft YaHei; /* 设置字体 */
	color: white; /* 字体颜色 */
	font-size: 17px; /* 字体大小 */
}
</style>
</head>
<body background="4.jfif">
<form action="BookServlet?action=find" method="post">
<div class="center">
请输入您要查询的方式<br>
<input type="radio" name="type" value="ISBN">ISBN<br>
<input type="radio" name="type" value="author">作者 <br>
<input type="radio" name="type" value="publish">出版社 <br>
<input type="radio" name="type" value="language">语言 <br>
<input type="radio" name="type" value="price">价格 <br>
<input type="radio" name="type" value="class_id">分类号 <br>
<input type="radio" name="type" value="name">名称 <br>
<input type="radio" name="type" value="introduction">介绍<br>
<input type="radio" name="type" value="pub_time">出版时间 <br>
<input type="radio" name="type" value="number">数量 <br>
<input type="radio" name="type" value="class_name">分类名 <br>
<input type="radio" name="type" value="borrowpeople">借书人 <br>
<input type="radio" name="type" value="lend_date">借书日期<br>
<input type="radio" name="type" value="back_date">归还日期 <br>
<input type="radio" name="type" value="borrowtimes">借书次数 <br>
</div>
<div class="center1">
请输入您查询的内容<br>
<input type="text" name="data"><br>  
<input type="submit" value="确定">
</div>
</form>
</body>
</html>