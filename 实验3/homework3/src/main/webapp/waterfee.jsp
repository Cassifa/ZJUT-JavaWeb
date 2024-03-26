<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/3/27
  Time: 4:07
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WaterFree</title>
</head>
<body>
<h1>水费计算结果</h1>
    <%
        // 获取水表记录页面提交的值
        int value1 = Integer.parseInt(request.getParameter("value1"));
        int value2 = Integer.parseInt(request.getParameter("value2"));
        int value3 = Integer.parseInt(request.getParameter("value3"));
        int value4 = Integer.parseInt(request.getParameter("value4"));
        int value5 = Integer.parseInt(request.getParameter("value5"));
        int value6 = Integer.parseInt(request.getParameter("value6"));

        // 计算总用水量
        int totalWater = value1 + value2 + value3 + value4 + value5 + value6;

        // 假设水费计算规则为每立方米水费用为 5 元
        double unitPrice;
        double disposalPrice=1.0;
        if(totalWater<=216) unitPrice=1.9;
        else if(totalWater>300) unitPrice=5.7;
        else  unitPrice=2.85;
        double totalFee=(unitPrice+disposalPrice)*totalWater;
    %>

    <p>总用水量：<%= totalWater %> 吨</p>
    <p>水费单价：<%= unitPrice+disposalPrice %> 元/吨</p>
    <p>总水费：<%= totalFee %> 元</p>
</body>
</html>

