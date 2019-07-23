<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>exception-page</title>
</head>
<body>
<h3>Exception Page</h3>
<p>
    status:<br/><%=response.getStatus()%>
</p>
<p>
    Exception Message:<br/>${exception.message}
</p>
<p>
    Exception type:<br/>${exception['class'].name}
</p>
</body>
</html>
