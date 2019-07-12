<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Customer List </h3>

<table style="width:100%">
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>
                <spring:eval expression="customer.id" />
            </td>
            <td>
                <spring:eval expression="customer.name" />
            </td>
            <td>
                <spring:eval expression="customer.address" />
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
