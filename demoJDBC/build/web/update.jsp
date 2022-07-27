<%-- 
    Document   : new
    Created on : May 15, 2022, 9:05:58 AM
    Author     : DELL
--%>

<%@page import="model.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update a category</h1>
        <%
            if(request.getAttribute("category")!=null){
                Category c= (Category)request.getAttribute("category");
        %>
        <form action="update" method="post">
            Enter id: <input type="number" name="id" readonly value="<%= c.getId()%>"/><br>
            Enter name: <input type="text" name="name" value = "<%= c.getName()%>"/><br>
            Enter describe: <input type="text" name="describe" value="<%=c.getDescribe()%>"/><br>
            <input type="submit" value="SAVE"/><br>
        </form>
        <%
               }
        %>
    </body>
</html>
