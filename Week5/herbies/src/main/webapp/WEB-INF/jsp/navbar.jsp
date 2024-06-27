<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/navbar.css"/>
</head>
<body>
    
    <!-- sessionScope is a way to access attributes that are stored in the HttpSession object -->

    <div class = "nav">

        <div class = "navitems">

        <a href="/">Home</a>
        <a href="/cars">Cars</a>

        <!-- we only want the sign-in and sign-up to display if there is no user set in the session -->

        <!-- we use the "test" attribute inside of the if tag to do a conditional statement -->
        <c:if test="${empty sessionScope.user}">
        <a href="/signin">Sign-In</a>
        <a href="/signup">Sign-Up</a>
    </c:if>


    <c:choose>

    <c:when test="${sessionScope.userRole == 'BUYER'}">
   
    <a href="/userprofile">User Profile</a>
    <a href="#">Cart</a>
    <a href="/logout">Logout</a>
    </c:when>

    <c:when test="${sessionScope.userRole == 'SELLER'}">
   
    <a href="/addcar">Add Car</a>
    <a href="#">View Reports</a>
    <a href="/logout">Logout</a>
    </c:when>

    


    </c:choose>
        

    </div>
        
    </div>



</body>
</html>