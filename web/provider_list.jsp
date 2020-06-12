<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript">
        function doit(flag, id) {
            if (flag === "del") {
                if (confirm("确认删除吗？") !== true)
                    return;
            }
            window.location = "provider.do?id=" + id + "&flag=" + flag;
        }
    </script>
</head>
<body>
<%--<div class="menu">--%>

<%--    <table>--%>
<%--        <tbody>--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                <form method="post" action="provider.do">--%>
<%--                    <input name="flag" value="search" type="hidden">--%>
<%--                    供应商名称：<input name="providerName" class="input-text" type="text">--%>
<%--                    &nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input--%>
<%--                        value="组合查询" type="submit">--%>
<%--                </form>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>
<div class="main">
    <div class="optitle clearfix">
        <em><input value="添加数据" class="input-button" onclick="window.location='provider_add.jsp'" type="button"></em>
        <div class="title">供应商管理&gt;&gt;</div>
    </div>

    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td width="70" height="29">
                    <div class="STYLE1" align="center">编号</div>
                </td>
                <td width="80">
                    <div class="STYLE1" align="center">供应商名称</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">供应商描述</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">联系人</div>
                </td>

                <td width="100">
                    <div class="STYLE1" align="center">电话</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">地址</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">操作</div>
                </td>
            </tr>
            <c:forEach items="${sessionScope.providers}" var="provider">
                <tr>
                    <td width="70" height="29">
                        <div class="STYLE1" align="center">${provider.id}</div>
                    </td>
                    <td width="80">
                        <div class="STYLE1" align="center">${provider.name}</div>
                    </td>
                    <td width="100">
                        <div class="STYLE1" align="center">${provider.desc}</div>
                    </td>
                    <td width="100">
                        <div class="STYLE1" align="center">${provider.creator}</div>
                    </td>

                    <td width="100">
                        <div class="STYLE1" align="center">${provider.tel}</div>
                    </td>
                    <td width="100">
                        <div class="STYLE1" align="center">${provider.address}</div>
                    </td>
                    <td width="100">
                        <div class="STYLE1" align="center"><a href="provider_modify?id=${provider.id}">修改</a></div>
                        <span class="STYLE1" align="center"><a href="provider_delete?id=${provider.id}">删除</a></span>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>
</body>
</html>