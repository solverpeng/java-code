<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyView</title>
</head>
<body style="margin:20px;">
JSP page
<p> Page Created:  <%= LocalDateTime.now()%></p>
<a href='test1'>test1</a>
</body>
</html>
