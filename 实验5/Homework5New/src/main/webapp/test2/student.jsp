<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/5/8
  Time: 17:20
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <title>学生信息</title>
</head>
<body>
<h2>学生信息</h2>
<table border="1">
    <tr>
        <td>姓名：</td>
        <td>${student.name}</td>
    </tr>
    <tr>
        <td>身份证号：</td>
        <td>${student.id}</td>
    </tr>
    <tr>
        <td>学号：</td>
        <td>${student.sno}</td>
    </tr>
    <tr>
        <td>学院：</td>
        <td>${student.department}</td>
    </tr>
    <tr>
        <td>专业：</td>
        <td>${student.major}</td>
    </tr>
    <tr>
        <td>班级：</td>
        <td>${student.studentClass}</td>
    </tr>
</table>
</body>
</html>
