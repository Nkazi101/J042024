<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <form method="post" action="/editprofile">

   
    <label>First Name</label> <br>
    <input type="text" name="firstName" value="${user.firstName}"/> <br>
    <label>Last Name</label> <br>
    <input type="text" name="lastName" value="${user.lastName}"/> <br>
    <label>Date Of Birth</label> <br>
    <input type="date" name="dateOfBirth" value="${user.dateOfBirth}"/> <br>
    <label>Address</label> <br>
    <input type= "text" name="address" value="${user.address}"/> <br>
    <label>Email</label> <br>
    <input type="email" name="email" value="${user.email}"/> <br>
    <label>Phone Number</label> <br>
    <input type="number" name="phoneNumber" value="${user.phoneNumber}" /> <br>
    
    <button>Submit</button>

</form>
</body>
</html>