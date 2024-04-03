<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/4/3
  Time: 17:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>
    <style type="text/css">
        .myTable{
            border: 2px solid #0000FF;
            margin-top: 15%;
        }
        .inputs{
            width: 95%;
            height: 25px;
            color: #999;
        }
        .btn{
            background-color:#4a8bd6;
            width: 90%;
            height: 40px;
            border: none;
            color: aliceblue;
            text-decoration: underline; /* 添加白色下划线 */
            margin: 10px;
        }
    </style>
</head>
<body>
<form onSubmit="return custCheck()" action="../StudentServlet" method="post">
    <table rules=none cellspacing=0  width=340 align=center class="myTable">
        <!-- 提示 -->
        <tr height="40">
            <td colspan="2">
                <h2 align="center">
                    <font color="blue">学生录入</font>
                </h2>
            </td>
        </tr>
        <!-- 学号 -->
        <tr>
            <td height=40 align="center" width=80>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</td>
            <td>
                <input class="inputs"
                       placeholder="请输入学号"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="stuid" id="stuid">
            </td>
        </tr>
        <!-- 姓名 -->
        <tr>
            <td height=40 align="center" width=80>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</td>
            <td height=40>
                <input class="inputs"
                       placeholder="请输入姓名"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="name" id="name">
            </td>
        </tr>
        <!-- 专业 -->
        <tr>
            <td height=40 align="center" width=80>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</td>
            <td height=40>
                <input class="inputs"
                       placeholder="请输入专业"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="major" id="major">
            </td>
        </tr>

        <!-- 录入 -->
        <tr height="40">
            <td colspan="2" align="center">
                <button width="340" height="40" class="btn" >录入</button>
            </td>
        </tr>

    </table>
</form>
<script language="JavaScript" type="text/javascript">
    function custCheck() {
        var stuid = document.getElementById("stuid");
        var name = document.getElementById("name");
        var major = document.getElementById("major");
        if (stuid.value === "" || stuid.value === "请输入学号") {
            alert("学号不能为空!");
            return false;
        } else if (name.value === "" || name.value === "请输入姓名") {
            alert("姓名不能为空!");
            return false;
        } else if (major.value === "" || major.value === "请输入专业") {
            alert("专业不能为空!");
            return false;
        }
        return true;
    }
</script>

</body>
</html>
