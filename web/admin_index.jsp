<%--
  Created by IntelliJ IDEA.
  User: SJJ
  Date: 2020/6/5
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>超市账单管理系统</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<frameset rows="100,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="admin_top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
    <frameset cols="200,*" frameborder="no" border="0" framespacing="0">
        <frame src="admin_left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" />
        <frame src="admin_bill_list.jsp" name="mainFrame" id="mainFrame" />
    </frameset>
</frameset>
<noframes><body>
</body></noframes>
</html>