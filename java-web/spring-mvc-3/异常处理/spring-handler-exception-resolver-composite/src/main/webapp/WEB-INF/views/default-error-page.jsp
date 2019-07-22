<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>default-error-page</title>
</head>
<body>
    <h3>This is the default exception page</h3>
    <p>Exception: <b>${exception['class'].name}</b></p>
    <p>Message: <b>${exception.message}</b></p>
</body>
</html>
