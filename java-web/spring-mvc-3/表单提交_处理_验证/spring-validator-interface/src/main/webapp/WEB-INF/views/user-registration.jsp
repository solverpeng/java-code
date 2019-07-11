<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user-registration</title>
    <style>
        span.error {
            color: red;
        }
    </style>
</head>
<body>
<h3> Registration Form </h3>
<br/>
<frm:form action="register" method="post" modelAttribute="user">
<pre>
              Name <frm:input path="name" />
                   <frm:errors path="name" cssClass="error" />

     Email address <frm:input path="email" />
                   <frm:errors path="email" cssClass="error" />

          Password <frm:password path="password" />
                   <frm:errors path="password" cssClass="error" />
                                    <input type="submit" value="Submit" />
</pre>
</frm:form>
</body>
</html>
