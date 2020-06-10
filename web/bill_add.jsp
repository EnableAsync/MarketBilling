<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div class="main">
    <div class="optitle clearfix">
        <div class="title">账单添加&gt;&gt;</div>
    </div>
    <form method="post" action="billing">
        <div class="content">
            <span style="color: red; "></span>
            <table class="box">
                <tbody>
                <tr>
                    <td class="field">商品名称：</td>
                    <td><input name="name" value="" class="text" type="text">
                        <span style="color: red; ">*</span></td>
                </tr>
                <tr>
                    <td class="field">商品描述：</td>
                    <td><input name="desc" cols="45" rows="5"></td>
                </tr>
                <tr>
                    <td class="field">商品数量：</td>
                    <td><input name="count" class="text" type="number"></td>
                </tr>
                <tr>
                    <td class="field">总价：</td>
                    <td><input name="total" value="" class="text" type="text"></td>
                </tr>
                <tr>
                    <td class="field">是否支付：</td>
                    <td>
                        <select name="isPay">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="field">供货商：</td>
                    <td>
                        <select name="provider_id">
                            <c:forEach items="${sessionScope.providers}" var="p">
                                <option value="${p.id}">${p.name}</option>
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
