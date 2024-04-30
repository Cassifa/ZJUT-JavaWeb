<%--
    Created by IntelliJ IDEA.
    User: Li Feifei
    Date: 2024/4/11
    Time: 23:16
--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.alibaba.fastjson2.JSONArray" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.List" %>
<%@ page import="zjut.lff.homework5.test3.HomeWork" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>作业展示</title>
    <style>
        th {
            background-color: saddlebrown;
        }

        .download {
            text-decoration: underline;
            color: purple;
        }

        td {
            background-color: lightblue;
        }
    </style>
</head>
<body>
<%
    String jsonData = (String) session.getAttribute("data");
    String type = (String) session.getAttribute("type");
    request.setAttribute("type",type);
    List<HomeWork> list = JSONArray.parseArray(jsonData, HomeWork.class);
    if (list == null) list = new LinkedList<>();
%>
<%-- 在这里使用 homeWorkList 对象展示作业信息 --%>

<h1 align="center">作业信息：</h1>
<table border="1" width="100%">
    <thead>
    <tr>
        <th width="3%">序号</th>
        <th width="10%">学号</th>
        <th width="7%">姓名</th>
        <th width="40%">作业标题</th>
        <th width="20%">上传时间</th>
        <th width="20%">下载</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < list.size(); i++) {
        HomeWork homeWork = list.get(i);
    %>
    <tr style="text-align: center">
        <td><%= i + 1 %>
        </td>
        <td><%= homeWork.getId() %>
        </td>
        <td><%= homeWork.getName() %>
        </td>
        <td><%= homeWork.getDescription() %>
        </td>
        <td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(homeWork.getDate()) %>
        </td>
        <td class="download">
            <a href=<%="./DownloadHomeworkServlet.do?studentid="+homeWork.getId()
                +"&filename="+homeWork.getFilename()
            %>
            >下载</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>

<%--<c:if  test="${type=='学生'}">--%>
    <a href="./test3/studentOperation.jsp">返回操作页面</a>
<%--</c:if>--%>
</body>
</html>
