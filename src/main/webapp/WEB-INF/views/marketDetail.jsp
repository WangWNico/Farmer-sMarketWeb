<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Market Details</title>
</head>
<body>
<h1>Market Details</h1>
<div th:if="${market != null}">
    <p><strong>Market Name:</strong> <span th:text="${market.marketName}"></span></p>
    <p><strong>Website:</strong> <span th:text="${market.website}"></span></p>
    <p><strong>Address:</strong> <span th:text="${market.street} + ', ' + ${market.city} + ', ' + ${market.state} + ' ' + ${market.zip}"></span></p>
    <p><strong>Season 1:</strong> <span th:text="${market.season1Date} + ' - ' + ${market.season1Time}"></span></p>
    <p><strong>Season 2:</strong> <span th:text="${market.season2Date} + ' - ' + ${market.season2Time}"></span></p>
    <p><strong>Season 3:</strong> <span th:text="${market.season3Date} + ' - ' + ${market.season3Time}"></span></p>
    <p><strong>Season 4:</strong> <span th:text="${market.season4Date} + ' - ' + ${market.season4Time}"></span></p>
    <p><strong>Coordinates:</strong> <span th:text="'(' + ${market.x} + ', ' + ${market.y} + ')'"></span></p>
    <p><strong>Location:</strong> <span th:text="${market.location}"></span></p>
    <p><strong>Credit:</strong> <span th:text="${market.credit}"></span></p>
    <p><strong>WIC:</strong> <span th:text="${market.wic}"></span></p>
    <p><strong>WIC Cash:</strong> <span th:text="${market.wicCash}"></span></p>
    <p><strong>SFMNP:</strong> <span th:text="${market.sfmnp}"></span></p>
    <p><strong>SNAP:</strong> <span th:text="${market.snap}"></span></p>
    <p><strong>Organic:</strong> <span th:text="${market.organic}"></span></p>
    <p><strong>Update Time:</strong> <span th:text="${market.updateTime}"></span></p>
    <h2>Products</h2>
    <p th:text="${market.products}"></p>
</div>
<div th:if="${market == null}">
    <p>Market details not found.</p>
</div>
</body>
</html>