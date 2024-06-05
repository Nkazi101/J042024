<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- jstl is a set of tags that can be used for implementing common operations such as looping, conditional formatting, database access, and data processing -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Students</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <h1>Enrolled Students</h1>

<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    <c:forEach var="student" items="${students}">
    <tr>
        <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.email}</td>
    </tr>
</c:forEach>

</table>



</body>
</html>