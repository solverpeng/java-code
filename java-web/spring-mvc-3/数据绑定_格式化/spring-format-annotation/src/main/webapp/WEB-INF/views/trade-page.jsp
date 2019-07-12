<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>trade-page</title>
</head>
<body>
<h3> Showing Trade with Id ${trade.tradeId} </h3>
    <p>BuySell: ${trade.buySell}</p>
    <p>Buy Currency: ${trade.buyCurrency}</p>
    <p>Sell Currency: ${trade.sellCurrency}</p>
    <p>Amount :
        <spring:bind path="trade.amount">${status.value}</spring:bind>
    </p>
    <p>Trade Date :
        <spring:bind path="trade.tradeDate">${status.value}</spring:bind>
    </p>
</body>
</html>
