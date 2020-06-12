<%--
  Created by IntelliJ IDEA.
  User: SJJ
  Date: 2020/6/12
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<head>
    <title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript">
        function checkit() {
            if (document.getElementById("password_text").value !== document.getElementById("passwordConfirm").value) {
                alert("两次密码输入不相同");
                return false;
            }
        }
    </script>
</head>
<body>
<div class="main">
    <div class="optitle clearfix">
        <div class="title">用户管理&gt;&gt;</div>

    </div>
    <form method="post" action="user" onsubmit="return checkit();">
        <input type="hidden" name="flag" value="doAdd">
        <div class="content">
            <table class="box"><span style="color: red; "></span>
                <tr>
                    <td class="field">用户名称：</td>
                    <td><input type="text" name="username" class="text"/> <span style="color: red; ">*</span></td>
                </tr>
                <tr>
                    <td class="field">用户密码：</td>

                    <td><input type="password" id="password_text" name="password" class="text"/> <span
                            style="color: red; ">*</span></td>
                </tr>
                <tr>
                    <td class="field">确认密码：</td>
                    <td><input type="password" id="passwordConfirm" class="text"/> <span style="color: red; ">*</span>
                    </td>
                </tr>

                <tr>
                    <td class="field">用户生日：</td>
                    <td><input type="date" name="birthday"/> <span style="color: red; ">*</span></td>
                </tr>
                <tr>
                    <td class="field">用户电话：</td>
                    <td><input type="text" name="phone" class="text"/> <span
                            style="color: red; ">*</span></td>

                </tr>
                <tr>
                    <td class="field">用户地址：</td>
                    <td><textarea name="address" id="textarea" class="text" cols="45" rows="5"></textarea></td>
                </tr>
                <tr>
                    <td class="field">用户权限：</td>

                    <td>
                        <input type="radio" name="role" value="0" checked="checked"/>经理
                        <input type="radio" name="role" value="1"/>普通用户
                    </td>
                </tr>
            </table>
        </div>
        <div class="buttons">
            <input type="submit" name="button" value="提交" class="input-button"/>
            <input type="button" name="button" onclick="window.location='user_list.jsp';" value="返回"
                   class="input-button"/>
        </div>

    </form>
</div>
</body>
</html>

