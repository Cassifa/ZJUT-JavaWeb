<%--
  Created by IntelliJ IDEA.
  User: Li Feifei
  Date: 2024/3/27
  Time: 3:51
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
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<form onSubmit="return custCheck()" method="post" action="waterfee.jsp">
    <table rules=none cellspacing=0  width=340 align=center class="myTable">
        <!-- 提示 -->
        <tr height="40">
            <td colspan="2">
                <h2 align="center">
                    <font color="blue">水表记录</font>
                </h2>
            </td>
        </tr>
        <!-- 水表值1 -->
        <tr height=40>
            <td height=40 align="center" width=80 >输入水表值</td>
            <td width=240>
                <input class="inputs"
                       placeholder="水表值1"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="value1" id="value1">
            </td>

        </tr>
        <!-- 水表值2 -->
        <tr>
            <td height=40 align="center" width=80>输入水表值</td>
            <td>
                <input class="inputs"
                       placeholder="水表值2"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="value2" id="value2">
            </td>
        </tr>
        <!-- 水表值3 -->
        <tr>
            <td height=40 align="center" width=80>输入水表值</td>
            <td height=40>
                <input class="inputs"
                       placeholder="水表值3"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="value3" id="value3">
            </td>
        </tr>
        <!-- 水表值4 -->
        <tr height=40>
            <td height=40 align="center" width=80 >输入水表值</td>
            <td width=240>
                <input class="inputs"
                       placeholder="水表值4"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="value4" id="value4">
            </td>

        </tr>
        <!-- 水表值5 -->
        <tr>
            <td height=40 align="center" width=80>输入水表值</td>
            <td>
                <input class="inputs"
                       placeholder="水表值5"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="value5" id="value5">
            </td>
        </tr>
        <!-- 水表值6 -->
        <tr>
            <td height=40 align="center" width=100>输入水表值</td>
            <td height=40>
                <input class="inputs"
                       placeholder="水表值6"
                       onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                       onBlur="if(!value){value=defaultValue; this.style.color='#999'}"
                       name="value6" id="value6">
            </td>
        </tr>

        <!-- 登录 -->
        <tr height="40">
            <td colspan="2" align="center">
                <button width="340" height="40" class="btn" >确认提交</button>
            </td>
        </tr>
    </table>
</form>
<script language="JavaScript" type="text/javascript">
    function check(str) {
        var regex = /^\d+$/;
        return regex.test(str);
    }
    function custCheck() {
        var value1 = document.getElementById("value1");
        var value2 = document.getElementById("value2");
        var value3 = document.getElementById("value3");
        var value4 = document.getElementById("value4");
        var value5 = document.getElementById("value5");
        var value6 = document.getElementById("value6");
        if (!check(value1.value)) {
            alert("请输入正确的数值!");
            return false;
        }
        else if (!check(value2.value)) {
            alert("请输入正确的数值!");
            return false;
        }
        else if (!check(value3.value)) {
            alert("请输入正确的数值!");
            return false;
        }
        else if (!check(value4.value)) {
            alert("请输入正确的数值!");
            return false;
        }
        else if (!check(value5.value)) {
            alert("请输入正确的数值!");
            return false;
        }
        else if (!check(value6.value)) {
            alert("请输入正确的数值!");
            return false;
        }
        return true;
    }
</script>

</body>
</html>
