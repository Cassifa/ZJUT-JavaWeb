<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/5/8
  Time: 17:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师信息</title>
</head>
<body>
<h2>老师信息</h2>
<table border="1">
    <tr>
        <td>姓名：</td>
        <td>${teacher.name}</td>
    </tr>
    <tr>
        <td>身份证号：</td>
        <td>${teacher.id}</td>
    </tr>
    <tr>
        <td>工号：</td>
        <td>${teacher.tno}</td>
    </tr>
    <tr>
        <td>学院：</td>
        <td>${teacher.department}</td>
    </tr>
    <tr>
        <td>角色：</td>
        <td>${teacher.role}</td>
    </tr>
</table>
</body>
</html>
