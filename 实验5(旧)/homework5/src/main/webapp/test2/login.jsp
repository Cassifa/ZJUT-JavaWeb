<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/4/11
  Time: 2:19
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
<form onSubmit="return custCheck()" action="../LoginActionServlet" method="post">
    <table rules=none cellspacing=0  width=340 align=center class="myTable">
        <!-- 提示 -->
        <tr height="40">
            <td colspan="2">
                <h2 align="center">
                    <font color="blue">登录</font>
                </h2>
            </td>
        </tr>
        <!-- 用户类型 -->
        <tr>
            <td height=40 align="center" width=80>用户类型</td>
            <td>
                <label for="student">学生</label>
                <input type="radio" id="student" name="type" value="学生" checked>

                <label for="teacher">教师</label>
                <input type="radio" id="teacher" name="type" value="教师">
            </td>

        </tr>
        <!-- 姓名 -->
        <tr>
            <td height=40 align="center" width=80>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</td>
            <td>
                <input class="inputs"
                       placeholder="请输入姓名"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="name" id="name">
            </td>
        </tr>
        <!-- 工号或学号 -->
        <tr>
            <td height=40 align="center" width=80>工号或学号</td>
            <td>
                <input class="inputs"
                       placeholder="请输入工号或学号"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="id" id="id">
            </td>
        </tr>
        <!-- 密码 -->
        <tr>
            <td height=40 align="center" width=80>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</td>
            <td height=40>
                <input class="inputs"
                       placeholder="请输入密码"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="password" id="password">
            </td>
        </tr>

        <!-- 登录 -->
        <tr height="40">
            <td colspan="2" align="center">
                <button width="340" height="40" class="btn" >登录</button>
            </td>
        </tr>

    </table>
</form>
<script language="JavaScript" type="text/javascript">
    function custCheck() {
        var name = document.getElementById("name");
        var password = document.getElementById("password");
        var id = document.getElementById("id");
        if (name.value === "" || name.value === "请输入姓名") {
            alert("姓名不能为空!");
            return false;
        } else if (password.value === "" || password.value === "请输入密码") {
            alert("密码不能为空!");
            return false;
        }else if (id.value === "" || id.value === "请输入工号或学号") {
            alert("工号或学号不能为空!");
            return false;
        }
        return true;
    }
</script>

</body>
</html>


