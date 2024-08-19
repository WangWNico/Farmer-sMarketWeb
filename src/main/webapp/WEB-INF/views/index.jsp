<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Farmers Markets</title>
</head>
<body>
<h1>Farmers Markets</h1>
<form action="search" method="get">
    <label for="query">Search:</label>
    <input type="text" id="query" name="query">
    <button type="submit">Search</button>
</form>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Average Rating</th>
    </tr>
    <c:forEach var="market" items="${markets}">
        <tr>
            <td><a href="marketDetail?FMID=${market.FMID}">${market.MarketName}</a></td>
            <td>${market.street}, ${market.city}, ${market.State}, ${market.zip}</td>
            <td>${market.average_rating}</td>
        </tr>
    </c:forEach>
</table>
<div>
    <c:if test="${page > 1}">
        <a href="index?page=${page - 1}">Previous</a>
    </c:if>
    <c:if test="${hasNextPage}">
        <a href="index?page=${page + 1}">Next</a>
    </c:if>
</div>
</body>
</html>