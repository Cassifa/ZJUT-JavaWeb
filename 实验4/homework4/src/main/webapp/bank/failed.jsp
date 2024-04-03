<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/4/4
  Time: 1:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
</head>
<body>
<h1>
    <%=request.getSession().getAttribute("msg")%>
</h1>
</body>
</html>
