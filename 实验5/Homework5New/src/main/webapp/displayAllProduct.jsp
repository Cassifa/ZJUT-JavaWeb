<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/5/4
  Time: 9:47
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="zjut.lff.homework5new.pojo.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有商品</title>
</head>
<body>
<table border="1">
    <tr>
        <td>商品号</td>
        <td>商品名</td>
        <td>价格</td>
        <td>数量</td>
        <td>删除</td>
    </tr>
    <c:forEach var="product" items="${sessionScope.productList}" varStatus="status">
        <%--为奇数行和偶数行设置不同的背景颜色--%>
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff">
        </c:if>
        <c:if test="${status.count%2!=0}">
            <tr style="background: #dedeff">
        </c:if>
        <%--用EL访问作用域变量的成员--%>
        <td>${product.prodId}</td>
        <td>${product.pname}</td>
        <td>${product.price}</td>
        <td>${product.stock}</td>
        <td>
            <!-- 添加表单，提交删除请求 -->
            <form action="AddDeleteProductServlet" method="get" onsubmit="return confirmDelete();">
                <!-- 将 productid 作为隐藏字段传递 -->
                <input type="hidden" name="productid" value="${product.prodId}">
                <input type="submit" value="删除" style="background-color: red; color: white;">
            </form>
        </td>
        </tr>
    </c:forEach>
</table>
<h2>添加产品</h2>
<form action="AddDeleteProductServlet" method="post">
    <label for="prodId">产品 ID:</label>
    <input type="text" id="prodId" name="prodId" required><br><br>

    <label for="pname">产品名称:</label>
    <input type="text" id="pname" name="pname" required><br><br>

    <label for="price">价格:</label>
    <input type="number" id="price" name="price" step="0.01" required><br><br>

    <label for="stock">库存:</label>
    <input type="number" id="stock" name="stock" required><br><br>

    <input type="submit" value="添加产品">
</form>
</body>
</html>

