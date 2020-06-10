<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%--        商品名称：<input type="text" name="productName" class="input-text"/>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--        是否付款：<select name="payStatus">--%>
<%--        <option value="">请选择</option>--%>
<%--        <option value="1">已付款</option>--%>
<%--        <option value="0">未付款</option>--%>
<%--    </select>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--        <input type="submit" name="submit" value="组合查询" class="button"/>--%>
<%--    </form>--%>
<%--</div>--%>
<div class="main">
    <div class="optitle clearfix">
        <em><input type="button" name="button" value="添加数据" class="input-button"
                   onclick="location.href='bill_add.jsp'"/></em>
        <div class="title">账单管理&gt;&gt;</div>
    </div>
    <form method="post" action="billing_modify">
        <input name="id" value="${requestScope.bill.id}" hidden>
        <div class="content">
            <span style="color: red; "></span>
            <table class="box">
                <tbody>
                <tr>
                    <td class="field">商品名称：</td>
                    <td><input name="name" value="${requestScope.bill.product_name}" class="text" type="text">
                        <span style="color: red; ">*</span></td>
                </tr>
                <tr>
                    <td class="field">商品描述：</td>
                    <td><input name="desc" cols="45" rows="5" value="${requestScope.bill.product_desc}"></td>
                </tr>
                <tr>
                    <td class="field">商品数量：</td>
                    <td><input name="count" class="text" type="number" value="${requestScope.bill.product_count}"></td>
                </tr>
                <tr>
                    <td class="field">总价：</td>
                    <td><input name="total" value="${requestScope.bill.total_price}" class="text" type="text"></td>
                </tr>
                <tr>
                    <td class="field">是否支付：</td>
                    <td>
                        <select name="isPay">
                            <option value="1" <c:if test="${requestScope.bill.is_payment == 1}">selected</c:if>>是</option>
                            <option value="0" <c:if test="${requestScope.bill.is_payment == 0}">selected</c:if>>否</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="field">供货商：</td>
                    <td>
                        <select name="provider_id">
                            <c:forEach items="${sessionScope.providers}" var="p">
                                <option value="${p.id}" <c:if test="${requestScope.bill.provider_id == p.id}">selected</c:if>>
                                        ${p.name}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="buttons">
            <input name="method" type="hidden" value="post"/>
            <input name="button" value="提交" class="input-button" type="submit">
            <input name="button" onclick="window.location='bill_list.jsp';" value="返回" class="input-button"
                   type="button">
        </div>
    </form>
</div>
</body>
</html>
