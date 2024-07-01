<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="/css/cart.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <div class="cartpage">
    <h1>Your Shopping Cart</h1>

    <c:forEach var="car" items="${cartItems}">
<div class="cartitem">
    <img src="${car.photoUrl}"/>
    <p>${car.manufacturerName}</p>
    <p>${car.model}</p>
    <p>${car.price}</p>
    <a href="/cart/remove/${car.id}"><button>Remove</button></a>
</div>
    </c:forEach>

</div>
</body>
</html>