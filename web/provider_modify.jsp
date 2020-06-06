<%--
  Created by IntelliJ IDEA.
  User: SJJ
  Date: 2020/6/6
  Time: 9:45
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
                   onclick="location.href='provider_add.jsp'"/></em>
        <div class="title">账单管理&gt;&gt;</div>
    </div>
    <form method="post" action="provider_modify">
        <div class="content">
            <table class="box">
                <tr>
                    <td class="field">供应商编号：</td>
                    <td><input type="text" name="id" class="text" readonly value="${requestScope.provider.id}"/></td>
                </tr>
                <tr>
                    <td class="field">供应商名称：</td>
                    <td><input type="text" name="name" class="text" value="${requestScope.provider.name}"/></td>
                </tr>
                <tr>
                    <td class="field">供应商描述：</td>
                    <td><textarea name="desc" value="${requestScope.provider.desc}"></textarea></td>
                </tr>
                <tr>
                    <td class="field">供应商电话：</td>
                    <td><input name="tel" value="${requestScope.provider.tel}"/></td>
                </tr>
                <tr>
                    <td class="field">供应商地址：</td>
                    <td><input name="address" value="${requestScope.provider.address}"/></td>
                </tr>
                <%--                <tr>--%>
                <%--                    <td class="field">联系人：</td>--%>
                <%--                    <td><input name="creator" value="${requestScope.provider.creator}"/></td>--%>
                <%--                </tr>--%>
                <%--                <tr>--%>
                <%--                    <td class="field">时间：</td>--%>
                <%--                    <td><input name="time" value="${requestScope.provider.create_time}"/></td>--%>
                <%--                </tr>--%>
            </table>
        </div>
        <div class="buttons">
            <input type="hidden" name="method" value="put"/>
            <input type="submit" name="submit" value="确认" class="input-button"/>
            <input type="button" name="button" value="返回" class="input-button" onclick="history.back();"/>
        </div>
    </form>
</div>
</body>
</html>
