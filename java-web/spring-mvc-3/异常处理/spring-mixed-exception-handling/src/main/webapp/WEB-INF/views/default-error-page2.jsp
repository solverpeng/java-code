<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>default-error-page</title>
</head>
<body>
<h3>This is default error page 2</h3>
<p>Spring Handler method: ${handler}</p>
<p>
    Status:(javax.servlet.error.status_code)<br/>
    <%=request.getAttribute("javax.servlet.error.status_code") %>
</p>
<p>
    Status:(response.getStatus())<br/><%=response.getStatus() %>
</p>
<p>
    Reason:<br/><%=request.getAttribute("javax.servlet.error.message") %>
</p>
<p>
    Type:<br/><%=request.getAttribute("javax.servlet.error.exception_type") %>
</p>
</body>
</html>
