<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error-page</title>
</head>
<body>
<h3>This is custom exception page</h3>
<p>Exception Type: <b>${exception['class'].simpleName}</b></p>
<p>Exception Message: <b>${exception.message}</b></p>
</body>
</html>
