<%-- 
    Document   : login
    Created on : Apr 19, 2022, 3:30:32 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <%
            if (request.getAttribute("error") != null) {
                String error = (String) request.getAttribute("error");
        %>
        <h2 style="color: red"><%= error%></h2>
        <%

            }
        %>
        <form action="login" method="post">
            Enter username: <input type="text" name="user"/><br>
            Enter password: <input type="password" name="pass"/><br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
