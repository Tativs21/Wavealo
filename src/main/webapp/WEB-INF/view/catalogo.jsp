<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Catalogo - Wavealo</title>
</head>
<body>
    <h1>Catalogo</h1>
    <c:forEach var="p" items="${prodotti}">
        <p>${p.nome}</p>
        <p>${p.prezzo}</p>
    </c:forEach>
</body>
</html>
