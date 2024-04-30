<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello Test5</title>
</head>
<body>
<h1><%= "Hello Hello Test5!" %>
</h1>
<br/>
<a href="./test1/login.html">点击跳转实验1登录</a>&nbsp;
<a href="./FileDownloadServlet">点击跳转实验1FileDownloadServlet（未登录会返回登录页面）</a><br>
<a href="./test2/login.jsp">点击跳转实验2、实验3登录页面</a><br>
<a href="./AllHomeworkServlet">点击跳转实验3查看所有作业（未登录跳转登录）</a><br>
</body>
</html>