<%-- 
    Document   : home
    Created on : Apr 19, 2022, 2:22:51 PM
    Author     : DELL
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 style="color: red">
        <% 
            String name="Anh";
            out.println("Xin chao "+name+"!");
            Date d= new Date();
            SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
            out.print("Hom nay la: "+f.format(d));
            
        %>
        <h1>Hello World!</h1>
        </h2>
    </body>
</html>
