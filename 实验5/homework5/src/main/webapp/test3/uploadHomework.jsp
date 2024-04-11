<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/4/11
  Time: 16:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传作业</title>
</head>
<body>
<h1>上传作业</h1>
<form action="../UploadServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="file" accept="*/*" required>
    <input type="text" name="description"
           placeholder="请输入描述" required>
    <br>
    <input type="submit" value="上传">
</form>
</body>
</html>