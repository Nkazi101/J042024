<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign-In</title>
    <link rel="stylesheet" href="/css/signin.css" />
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <div class="signinpage">
        <div class="signinform">
        <form method="post" action="/signin">
    <h1>Sign In</h1>
            <label>Email</label> <br>
            <input type="email" name="email"> <br>
            <label>Password</label> <br>
            <input type="password" name="password"> <br>
            <a>Forgot password?</a>
    
            <div style="text-align: center;">
            <button type="submit">Sign In</button>
    
           
        </div>
        </form>
    </div>
      
    
    
    </div>
</body>
</html>