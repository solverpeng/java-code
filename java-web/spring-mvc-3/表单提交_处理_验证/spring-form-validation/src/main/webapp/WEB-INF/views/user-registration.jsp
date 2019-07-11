<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration-done</title>
    <style>
        span.error {
            color: red;
        }
    </style>
</head>
<body>
<h3> Registration Form </h3>
<br/>
<form action="register" method="post" >
<pre>
              Name <input type="text" name="name" value="${user.name}" />
                   <span class="error">${nameError}</span>

     Email address <input type="text" name="email" value="${user.email}" />
                   <span class="error">${emailError}</span>

          Password <input type="password" name="password" value="${user.password}" />
                   <span class="error">${passwordError}</span>
                                    <input type="submit" value="Submit" />
</pre>
</form>
</body>
</html>
