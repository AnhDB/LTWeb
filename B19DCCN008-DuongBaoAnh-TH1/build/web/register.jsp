<%-- 
    Document   : register
    Created on : Apr 5, 2022, 8:40:14 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <title>Register Form</title>
        
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="content">
                <form action="register" method="get">
                    <input type="text" name="username" placeholder="Username" required>
                    <input type="text" name="password" placeholder="Password" required><br>
                    <input type="submit" style="background-color: red; margin: 10px 10px 10px 150px" class="login" value="Register" >
                    
                </form>
                <div id="footer">
                  <a class="underlineHover" style="color: red; position: relative " href="index.jsp">Already have an account?</a>
                </div>
                </div>

          </div>
            
    </body>
</html>
