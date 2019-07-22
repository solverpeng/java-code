<%--
  Created by IntelliJ IDEA.
  User: T
  Date: 2019/7/22
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>exception-page</title>
</head>
<body>
<h3>This is a JSP exception page</h3>
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
