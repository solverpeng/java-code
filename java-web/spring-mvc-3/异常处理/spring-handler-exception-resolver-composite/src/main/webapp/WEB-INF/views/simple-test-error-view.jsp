<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>simple-test-error-view</title>
</head>
<body>
    <h3>Simple Test Error View</h3>
    <p>Exception: <b>${exception['class'].name}</b></p>
    <p>Message: <b>${exception.message}</b></p>
</body>
</html>
