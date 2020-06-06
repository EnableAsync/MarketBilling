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
        <div class="title">供应商管理&gt;&gt;</div>
    </div>
    <form method="post" action="provider">
        <div class="content">
            <span style="color: red; "></span>
            <table class="box">
                <tbody>
                <tr>
                    <td class="field">供应商名称：</td>
                    <td><input name="name" id="name" value="" class="text" type="text">
                        <span style="color: red; ">*</span></td>
                </tr>
                <tr>
                    <td class="field">供应商描述：</td>
                    <td><textarea name="desc" id="textarea" cols="45" rows="5"></textarea></td>
                </tr>
                <tr>
                    <td class="field">供应商电话：</td>
                    <td><input name="tel" id="tel" value="" class="text" type="text"></td>
                </tr>
                <tr>
                    <td class="field">供应商地址：</td>
                    <td><input name="address" id="address" value="" class="text" type="text"></td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="buttons">
            <input name="method" type="hidden" value="post" />
            <input name="button" value="提交" class="input-button" type="submit">
            <input name="button" onclick="window.location='provider_list.jsp';" value="返回" class="input-button"
                   type="button">
        </div>
    </form>
</div>
</body>
</html>
