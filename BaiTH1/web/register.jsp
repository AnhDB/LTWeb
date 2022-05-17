<%-- 
    Document   : register
    Created on : Apr 19, 2022, 4:38:48 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/main.css" type="text/css"/>
        <title>Register Page</title>
    </head>
    <body>
        <h1>Register Form!</h1>
        <%
            if (request.getAttribute("error") != null) {
                String error = (String) request.getAttribute("error");
        %>
        <h2 style="color: red"><%= error%></h2>
        <%

            }
        %>
        <div class="wrapper">
        <form id="content" action="register" method="post" style="background-color: #EEEEEE">
            <input type="text" name="username" placeholder="username" required><br>
            <input type="password" name="password" placeholder="password" required><br>
            <input type="submit" value="Register">
            
        </form>
        </div>
    </body>
</html>
