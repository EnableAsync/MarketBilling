<%--
  Created by IntelliJ IDEA.
  User: SJJ
  Date: 2020/6/5
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="frame-bd">
<ul class="left-menu">
    <li><a href="bill_list.jsp" target="mainFrame"><img src="images/btn_bill.gif" /></a></li>
    <li><a href="provider_list.jsp" target="mainFrame"><img src="images/btn_suppliers.gif" /></a></li>
    <li><a href="user_list.jsp" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
    <li><a href="#" onclick="logout()"><img src="images/btn_exit.gif" /></a></li>
</ul>
</body>
<script>
    function logout(){
        top.location.href="./logout";
    }
</script>
</html>
