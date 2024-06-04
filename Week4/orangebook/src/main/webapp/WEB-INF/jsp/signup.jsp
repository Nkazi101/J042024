<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="/css/signup.css" />
</head>
<body>

   
<div class="signuppage">
    
    <div class="signupform">
        <!-- the attributes in the form tag allows the form to locate the method which handles the submission -->
    <form method="post" action="/signup">
        <h1>Sign Up</h1>
        <label>First Name</label> <br>
        <input type="text" name="firstName"> <br>
        <label>Last Name</label> <br>
        <input type="text" name="lastName"> <br>
        <label>Date of Birth</label> <br>
        <input type="text" name ="dateofBirth"> <br>
        <label>Email</label> <br>
        <input type="email" name="email"> <br>
        <label>Phone Number</label> <br>
        <input type="text" name="phoneNumber"> <br>
        <label>Password</label> <br>
        <input type="password" name="password"> <br>
        
        <div style="text-align: center;">
        <button type="submit">Sign Up</button>
    </div>

    </form>

</div>

</div>
</body>
</html>