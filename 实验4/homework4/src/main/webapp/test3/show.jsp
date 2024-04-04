<%@ page import="com.google.zxing.client.j2se.MatrixToImageConfig" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="com.google.zxing.common.BitMatrix" %>
<%@ page import="com.google.zxing.client.j2se.MatrixToImageWriter" %>
<%@ page import="com.google.zxing.MultiFormatWriter" %>
<%@ page import="com.google.zxing.BarcodeFormat" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.util.Base64" %><%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/4/4
  Time: 16:05
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实验三展示</title>
</head>
<body>
<jsp:useBean id="user" scope="session" class="bank.com.homework4.pojo.User"></jsp:useBean>
<%-- 使用JavaScript定时器实时更新当前时间 --%>
<h1 id="currentTime"></h1>
<hr>
<h5><jsp:getProperty name="user" property="name"/></h5>
<%-- 生成二维码 --%>

<%
    String qrCodeData = "Name: " + user.getName() + ", ID: " + user.getId() +
            ", Son: " + user.getSon() + ", Phone: " + user.getPhone() +
            ", Time: " + user.getDate();
    int width = 300;
    int height = 300;
    String imageFormat = "png";

    // 设置二维码颜色
    int blackColor; // 黑色
    int whiteColor = 0xFFFFFFFF; // 白色
    if (user.getColor().equals("red"))
        blackColor = 0xFFFF0000; // 红色
    else if (user.getColor().equals("yellow"))
        blackColor = 0xFFFFFF00; // 黄色
    else blackColor = 0xFF00FF00; // 绿色

    // 创建颜色配置
    MatrixToImageConfig colorConfig = new MatrixToImageConfig(blackColor, whiteColor);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    try {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(qrCodeData, BarcodeFormat.QR_CODE, width, height);
        MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, outputStream, colorConfig); // 使用颜色配置
    } catch (Exception e) {
        e.printStackTrace();
    }

    // 将二维码数据编码为Base64字符串
    String base64ImageData = Base64.getEncoder().encodeToString(outputStream.toByteArray());
    // 构建Data URI
    String dataUri = "data:image/png;base64," + base64ImageData;
%>
    <%-- 显示二维码图像 --%>
    <img src="<%= dataUri %>" alt="QR Code">

    <%-- 获取用户对象的颜色属性 --%>
    <% String color = user.getColor(); %>
    <%-- 根据用户颜色进行条件判断 --%>
    <%
        if ("red".equals(color)) {
    %>
    <h1>红码：。。。</h1>
    <%
    } else if ("green".equals(color)) {
    %>
    <h1>绿码：凭此码可。。。</h1>
    <%
    } else if ("yellow".equals(color)) {
    %>
    <h1>黄码:。。。。</h1>
    <%
    } else {
    %>
    <h1>其他颜色</h1>
    <%
        }
    %>


<script>
    function updateTime() {
        var currentTimeElement = document.getElementById("currentTime");
        var currentTime = new Date();
        var formattedTime = currentTime.getMonth() + 1 + "月" + currentTime.getDate() + "日 <br>" +
            currentTime.getHours() + ":" + currentTime.getMinutes() + ":" + currentTime.getSeconds();

        currentTimeElement.innerHTML = formattedTime;
    }
    // 每秒更新一次时间
    setInterval(updateTime, 1000);
</script>


</body>
</html>
