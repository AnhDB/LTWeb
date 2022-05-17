<%-- 
    Document   : login
    Created on : Apr 19, 2022, 4:38:34 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/main.css" type="text/css"/>
        <title>Welcome Page</title>
    </head>
    <body>
        <h1 style="position: relative">Login Form</h1>
         <%
            if (request.getAttribute("error") != null) {
                String error = (String) request.getAttribute("error");
        %>
        <h2 style="color: red"><%= error%></h2>
        <%

            }
        %>
        <%
            if (request.getAttribute("success") != null) {
                String success = (String) request.getAttribute("success");
        %>
        <h2 style="color: red"><%= success %></h2>
        <%

            }
        %>
        <%! int total=0;%>
        <% total+=1; %>
        <div class="wrapper">
        <form id="content" action="login" method="post">
            <input type="text" name="username" placeholder="username" required><br>
            <input type="password" name="password" placeholder="password" required><br>
            <input type="submit" value="Log In">
            <a id="register" href="register.jsp" style="display:inline-block;text-decoration: none;">Register</a><br>
            Total hits_counter: <%= total%>
        </form>
        </div>
    </body>
</html>
