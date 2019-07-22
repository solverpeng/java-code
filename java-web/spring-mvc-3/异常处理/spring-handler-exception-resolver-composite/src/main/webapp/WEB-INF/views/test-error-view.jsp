<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test-error-view</title>
</head>
<body>
    <h3>Test Error View</h3>
    <p>Request Uri: <b>${requestUri}</b></p>
    <p>Exception: <b>${exception['class'].name}</b></p>
    <p>Message: <b>${exception.message}</b></p>
    <p>Response status: <b>${statusValue} (${statusStr})</b></p>
</body>
</html>
