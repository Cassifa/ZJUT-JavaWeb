<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/5/4
  Time: 9:39
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head><title>商品查询</title></head>
<body>
<form action="queryproduct.do" method="post">
    请输入商品号：
    <input type="text" name="productid" size="15">
    <input type="submit" value="确定">
</form>
<p><a href="queryproduct.do">查询所有商品</a></p>
</body>
</html>
