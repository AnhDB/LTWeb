<%-- 
    Document   : new
    Created on : May 15, 2022, 9:05:58 AM
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
        <h1>Add a new category</h1>
        <h3 style="color: red">${error}</h3>
        <form action="add">
            Enter id: <input type="number" name="id"/><br>
            Enter name: <input type="text" name="name"/><br>
            Enter describe: <input type="text" name="describe"/><br>
            <input type="submit" value="SAVE"/><br>
        </form>
    </body>
</html>
