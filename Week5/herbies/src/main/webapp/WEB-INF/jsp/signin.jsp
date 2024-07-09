<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign-In</title>
</head>
<body>
    
<jsp:include page="navbar.jsp"/>

<form:form method="post" action="/signinsubmit">

<c:if test="${not empty errorMessage}">

    <div>${errorMessage}</div>
    
</c:if>

    <label>Email</label> <br>
    <input type = "email" name="email"/> <br>

    <label>Password</label> <br>
    <input type="password" name="password" /> <br>

    <input type="checkbox" name="isAdmin" value="${null}"/>

    <a>Forgot Password?</a> <br>
    <a>Forgot Username?</a> <br>

    <button type="submit">Sign In</button>


</form:form>



</body>
</html>