<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书内容修改</title>
</head>
<body>
<form action="AdminServlet?action=bookupdate" method="post">
请输入您要修改的内容<br>
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
请输入您要修改图书的ISBN号<br>
<input type="text"" name="ISBN"><br>
要更改的新数据<br>
<input type="text" name="newdata"><br>
<input type="submit" value="确定">
</form>
</body>
</html>