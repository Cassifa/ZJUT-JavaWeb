<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/4/3
  Time: 17:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示学生</title>
</head>
<body>
<jsp:useBean id="student" scope="session" class="bank.com.homework4.pojo.Student"></jsp:useBean>
<h1>学生信息展示页面</h1>
<h1>学号：<jsp:getProperty name="student" property="stuid"/></h1>
<h1>姓名：<jsp:getProperty name="student" property="name"/></h1>
<h1>专业：<jsp:getProperty name="student" property="major"/></h1>
</body>
</html>
