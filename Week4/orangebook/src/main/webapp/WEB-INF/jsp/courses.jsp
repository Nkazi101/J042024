<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Courses</title>
    <link rel="stylesheet" href="/css/courses.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <h1>Courses</h1>
    <div class="course-list" >
        
    <c:forEach var="course" items="${courses}">

    <div class="course-item">
    <label>Course Name</label>
    <p>${course.courseName}</p>
    <label>Credits</label>
    <p>${course.credits}</p>

</div>
    </c:forEach>

</div>

</body>
</html>