<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>  
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Ubuntu:wght@500&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css" type="text/css"/>
</head>
<body>
<nav>
        <div class="logo">
           <p>MARSS</p>
        </div>

                <ul>
                    <li><a href="index.jsp">HOME</a></li>
                    <li><a href="login.jsp">Log In</a></li>
                    <li><a href="register.jsp">Register</a></li>
                    

                </ul>
    </nav>
    <div class="background">
        <div class="blur"></div>
    </div>


    <form class="btn" action="Login" method="post">
        <table >
            <tr>
                <th> <label for="uname">User Name<span style="color: red;">*</span></label><br>
                    <input type="text" id="uname" name="uname" placeholder="User Name"><br>
                </th>
            </tr>
            <tr>
                <th> <label for="password">Password<span style="color: red;">*</span></label><br>
                    <input type="password" name="password" id="password" placeholder="Password"> <br>
                    
                </th>
            </tr>
            
       
        </table> <br> 
        <div style="color: #FF0000;">${errorMessage}</div><br>
        <a href="Admin.jsp" style="color: #000000;">login as admin</a> <br> <br>
       
        <input type="submit" value="Submit">
    </form>

<div id="bottom-container">


    <p class="ftext">Copyright @ MARSS</p>



</div>
</body>
</html>