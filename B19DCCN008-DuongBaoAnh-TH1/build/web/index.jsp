<%-- 
    Document   : index
    Created on : Apr 5, 2022, 7:54:26 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <title>Login Form</title>
    </head>
    <body>
        <%! int hits_counter = 0;%>
        <% hits_counter ++;%>
        <div class="wrapper fadeInDown">
            <div id="content">
                <form action="login" method="get">
                    <input type="text" name="username" placeholder="Username" required>
                    <input type="text" name="password" placeholder="Password" required><br>
                  <input type="submit" class="login" value="Log In"> 
                  <a id="register" href="register.jsp">Register</a>
                </form>
                <p>Tổng số lần truy cập: <%=hits_counter%></p>
          </div>
            
        </div>
    </body>
</html>
