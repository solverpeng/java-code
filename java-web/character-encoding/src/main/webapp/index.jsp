<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>

<html>
<meta charset="utf-8">

<body>
<h2>Hello World!</h2>

<label>
    请求编码方式测试
</label>
<a href="encoding?name=abc">GET:测试请求参数非特殊字符</a>
<br>
<a href="encoding?name=张三">GET:测试请求参数中文</a>
<br>
<a href="encoding/abc?name=abc">GET:测试请求URI非特殊字符</a>
<br>
<a href="encoding/测试?name=张三">GET:测试请求URI含特殊字符</a>

<BR><BR>
<label>
    URI非特殊字符
</label>
<form action="encoding/abc" method="post">
    <label>
        name:<input type="text" name="name"/>
    </label>
    <input type="submit"/>
</form>

<label>
    URI中文
</label>
<form action="encoding/中文" method="post">
    <label>
        name:<input type="text" name="name"/>
    </label>
    <input type="submit"/>
</form>


</body>
</html>
