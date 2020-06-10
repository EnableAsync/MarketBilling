<%--
  Created by IntelliJ IDEA.
  User: SJJ
  Date: 2020/6/5
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                   onclick="location.href='bill_add.jsp'"/></em>
        <div class="title">账单管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tr>
                <td>账单编号</td>
                <td>商品名称</td>
                <td>商品数量</td>
                <td>交易金额</td>
                <td>是否付款</td>
                <td>供应商名称</td>
                <td>商品描述</td>
                <td>账单时间</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${sessionScope.bills}" var="bill">
                <tr>
                    <td>${bill.id}</td>
                    <td>${bill.product_name}</td>
                    <td>${bill.product_count}</td>
                    <td>${bill.total_price}</td>
                    <td>
                        <c:choose>
                            <c:when test="${bill.is_payment == 1}">已支付</c:when>
                            <c:otherwise>未支付</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${sessionScope.providersMap[bill.provider_id]}</td>
                    <td>${bill.product_desc}</td>
                    <td>${bill.create_time}</td>
                    <td>
                        <div class="STYLE1"><a href="billing_modify?id=${bill.id}">修改</a></div>
                        <span class="STYLE1"><a href="billing_delete?id=${bill.id}">删除</a></span>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
