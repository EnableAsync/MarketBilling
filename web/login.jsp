<%--
  Created by IntelliJ IDEA.
  User: SJJ
  Date: 2020/6/5
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>系统登录 - 超市账单管理系统</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body class="blue-style">
<div id="login">
    <div class="icon"></div>
    <div class="login-box">
        <form method="post" action="login">
            <dl>
                <dt>用户名：</dt>
                <dd><input type="text" name="username" class="input-text"/></dd>
                <dt>密　码：</dt>
                <dd><input type="password" name="password" class="input-text"/></dd>
            </dl>
            <div class="buttons">
                <input type="submit" name="submit" value="登录系统" class="input-button"/>
                <input type="reset" name="reset" value="重　　填" class="input-button"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
