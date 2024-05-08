<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/5/8
  Time: 17:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>注册页面</title>
<style type="text/css">
    .myTable {
        border: 2px solid #0000FF;
        margin-top: 15%;
    }

    .inputs {
        width: 95%;
        height: 25px;
        color: #999;
    }

    .btn {
        background-color: #4a8bd6;
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
<form onSubmit="return custCheck()" action="../RegisterServlet" method="post">
    <table rules=none cellspacing=0 width=340 align=center class="myTable">
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
                <input type="radio" id="student" name="type" value="学生" checked onchange="shiftRole()">

                <label for="teacher">教师</label>
                <input type="radio" id="teacher" name="type" value="教师" onchange="shiftRole()">
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
        <!-- 身份证号 -->
        <tr>
            <td height=40 align="center" width=80>身份&nbsp;证号</td>
            <td>
                <input class="inputs"
                       placeholder="请输入身份证号"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="id" id="id">
            </td>
        </tr>
        <!-- 工号 -->
        <tr class="teacher-only">
            <td height=40 align="center" width=80>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</td>
            <td>
                <input class="inputs teacher-only"
                       placeholder="请输入工号"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="tno" id="tno">
            </td>
        </tr>
        <!-- 学号 -->
        <tr class="student-only">
            <td height=40 align="center" width=80>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</td>
            <td>
                <input class="inputs student-only"
                       placeholder="请输入学号"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="sno" id="sno">
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

        <!-- 学院 -->
        <tr>
            <td height=40 align="center" width=80>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院</td>
            <td>
                <input class="inputs"
                       placeholder="请输入学院"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="department" id="department">
            </td>
        </tr>
        <!-- 角色 -->
        <tr class="teacher-only">
            <td height=40 align="center" width=80>角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色</td>
            <td>
                <input class="inputs teacher-only"
                       placeholder="请输入角色"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="role" id="role">
            </td>
        </tr>
        <!-- 专业 -->
        <tr class="student-only">
            <td height=40 align="center" width=80>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</td>
            <td>
                <input class="inputs student-only"
                       placeholder="请输入专业"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="major" id="major">
            </td>
        </tr>
        <!-- 班级 -->
        <tr class="student-only">
            <td height=40 align="center" width=80>班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级</td>
            <td>
                <input class="inputs student-only"
                       placeholder="请输入班级"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="class" id="class">
            </td>
        </tr>

        <!-- 登录 -->
        <tr height="40">
            <td colspan="2" align="center">
                <button width="340" height="40" class="btn">登录</button>
            </td>
        </tr>

    </table>
</form>
<script language="JavaScript" type="text/javascript">
    function custCheck() {
        var inputs = document.querySelectorAll('.inputs'); // 获取所有输入字段
        var isStudent = document.getElementById("student").checked; // 检查学生是否被选中
        var isTeacher = document.getElementById("teacher").checked; // 检查教师是否被选中

        // 检查所有非空字段
        for (let input of inputs) {
            // 如果字段属于学生或教师特定部分，则只在对应的用户类型被选中时验证
            if ((input.classList.contains('student-only') && !isStudent) ||
                (input.classList.contains('teacher-only') && !isTeacher)) {
                continue; // 如果当前类型不需要该字段，跳过验证
            }

            // 验证输入字段是否为空
            if (input.value.trim() === "") {
                alert(input.placeholder + " 不能为空!"); // 提示用户该字段不能为空
                input.focus(); // 聚焦到错误字段
                return false; // 阻止表单提交
            }
        }

        var role = document.getElementById("role"); // 获取 role 字段
        if (role && isTeacher) { // 如果是教师且有 role 字段
            var validRoles = ["系统管理员", "校级管理员", "院级管理员", "普通教师"];

            if (!validRoles.includes(role.value.trim())) { // 检查 role 值是否有效
                alert("角色类型必须是：系统管理员、校级管理员、院级管理员、普通教师之一！");
                role.focus(); // 聚焦到 role 字段
                return false; // 阻止表单提交
            }
        }

        return true; // 所有验证通过
    }

    function shiftRole() {
        const isStudent = document.getElementById("student").checked;
        const studentOnlyElements = document.querySelectorAll('.student-only');
        const teacherOnlyElements = document.querySelectorAll('.teacher-only');

        studentOnlyElements.forEach(element => {
            // 如果是学生，显示这些行；否则，隐藏它们
            element.style.display = isStudent ? '' : 'none';
        });
        teacherOnlyElements.forEach(element => {
            // 如果是学生，显示这些行；否则，隐藏它们
            element.style.display = !isStudent ? '' : 'none';
        });
    }

    // 初始状态，运行一次以确保正确显示
    shiftRole();
</script>

</body>
</html>
