<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SJJ
  Date: 2020/6/12
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
<%--<div class="menu">--%>
<%--    <form method="get" action="">--%>
<%--        商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--        是否付款：<select name="payStatus">--%>
<%--        <option value="">请选择</option>--%>
<%--        <option value="1">已付款</option>--%>
<%--        <option value="0">未付款</option>--%>
<%--    </select>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--        <input type="submit" name="submit" value="组合查询" class="button" />--%>
<%--    </form>--%>
<%--</div>--%>
<div class="main">
    <div class="optitle clearfix">
        <em><input type="button" name="button" value="添加数据" class="input-button"
                   onclick="location.href='user_add.jsp'"/></em>
        <div class="title">用户管理&gt;&gt;</div>
    </div>
    <form method="post" action="user_modify">
        <div class="content">
            <table class="box">
                <tr>
                    <td><input type="text" hidden name="id" class="text" readonly value="${requestScope.user.id}"/></td>
                </tr>
                <tr>
                    <td class="field">用户名称：</td>
                    <td><input type="text" name="username" class="text" value="${requestScope.user.username}"/></td>
                </tr>
                <tr>
                    <td class="field">用户电话：</td>
                    <td><input name="phone" value="${requestScope.user.phone}"/></td>
                </tr>
                <tr>
                    <td class="field">用户地址：</td>
                    <td><input name="address" value="${requestScope.user.address}"/></td>
                </tr>
                <tr>
                    <td class="field">用户生日：</td>
                    <td><input name="birthday" type="date" value="${requestScope.user.birthday}"/></td>
                </tr>
                <tr>
                    <td class="field">用户权限：</td>
                    <td>
                        <input type="radio" name="role" value="0"
                               <c:if test="${requestScope.user.role == 0}">checked</c:if> />经理
                        <input type="radio" name="role" value="1"
                               <c:if test="${requestScope.user.role == 1}">checked</c:if> />普通用户
                    </td>
                </tr>
            </table>
        </div>
        <div class="buttons">
            <input type="submit" name="submit" value="确认" class="input-button"/>
            <input name="button" onclick="window.location='user_list.jsp';" value="返回" class="input-button"
                   type="button">
        </div>
    </form>
</div>
</body>
</html>
