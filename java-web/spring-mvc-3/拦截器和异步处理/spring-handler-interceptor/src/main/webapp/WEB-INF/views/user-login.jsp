<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Login Page </title>
</head>
<body>
<h3> Login Page </h3>
    <br/>
    <form action="login" method="post" >
    <pre>
             Email address <input type="text" name="emailAddress" />
                  Password <input type="password" name="password" />
                            <input type="submit" value="Submit" />
                            <div class = "error">${error}</div>
    </pre>
    </form>
</body>
</html>
