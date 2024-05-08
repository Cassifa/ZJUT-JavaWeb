<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/5/4
  Time: 9:46
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head><title>商品信息</title></head>
<body>
<table>
    <tr>
        <td>商品号：</td>
        <td>${product.prodId}</td>
    </tr>
    <tr>
        <td>商品名：</td>
        <td>${product.pname}</td>
    </tr>
    <tr>
        <td>价格：</td>
        <td>${product.price}</td>
    </tr>
    <tr>
        <td>库存量：</td>
        <td>${product.stock}</td>
    </tr>
</table>
</body>
</body>
</html>