<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/4/11
  Time: 2:19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生欢迎</title>
</head>
<body>

<h1>
    <%=request.getSession().getAttribute("name")%>同学，欢迎您！
</h1>
</body>
</html>
