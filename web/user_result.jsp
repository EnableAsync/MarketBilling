<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript">
        function doit(flag, id) {
            if (flag === "del") {
                if (confirm("确认删除吗？") !== true)
                    return false;
            }
        }
    </script>
</head>
<body>

<div class="main">
    <div class="optitle clearfix">
        <em><input value="添加数据" class="input-button" onclick="window.location='user_add.jsp'" type="button"></em>
        <div class="title">用户管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td width="70" height="29">
                    <div class="STYLE1" align="center">编号</div>
                </td>
                <td width="80">
                    <div class="STYLE1" align="center">用户名称</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">生日</div>
                </td>

                <td width="150">
                    <div class="STYLE1" align="center">电话</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">地址</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">权限</div>
                </td>
                <td>操作</td>
            </tr>

            <tr>
                <td height="23"><span class="STYLE1">${requestScope.user.id}</span></td>
                <td><span class="STYLE1"><a href="#" onclick="doit('mod',1)">${requestScope.user.username}</a></span>
                </td>
                <td><span class="STYLE1">${requestScope.user.birthday}</span></td>
                <td><span class="STYLE1">${requestScope.user.phone}</span></td>
                <td><span class="STYLE1">${requestScope.user.address}</span></td>
                <td><span class="STYLE1">
                        <c:if test="${requestScope.user.role == 0}">经理</c:if>
                        <c:if test="${requestScope.user.role == 1}">普通用户</c:if>
                    </span></td>
                <td width="100">
                    <div class="STYLE1"><a href="user_modify?id=${requestScope.user.id}">修改</a></div>
                    <span class="STYLE1"><a href="user_delete?id=${requestScope.user.id}">删除</a></span>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
</div>
</body>
</html>