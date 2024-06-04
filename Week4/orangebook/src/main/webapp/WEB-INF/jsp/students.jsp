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
    <h1>Enrolled Students</h1>

<c:forEach var="student" items="${students}">

<p>${student.firstName}</p>
<p>${student.lastName}</p>
<p>${student.email}</p>

</c:forEach>
</body>
</html>