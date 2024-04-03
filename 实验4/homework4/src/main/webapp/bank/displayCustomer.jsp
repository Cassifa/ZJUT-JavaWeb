<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/4/4
  Time: 1:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示客户</title>
</head>
<body>
<jsp:useBean id="customer" scope="session" class="bank.com.homework4.model.Customer"></jsp:useBean>
<h1>客户信息展示页面</h1>
<h1>邮箱：<jsp:getProperty name="customer" property="email"/></h1>
<h1>姓名：<jsp:getProperty name="customer" property="custName"/></h1>
<h1>手机号：<jsp:getProperty name="customer" property="phone"/></h1>
</body>
</html>
