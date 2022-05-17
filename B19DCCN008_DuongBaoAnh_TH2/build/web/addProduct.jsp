<%-- 
    Document   : add
    Created on : Apr 25, 2022, 10:53:25 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
        <link href="styles/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Product</h1>
        <p style="font-style: italic">You must enter a description for the product</p>
        <p style="color: red"><i>${mess}</i></p>       
        <form action="addProduct" method="post">
            <!--<input type="hidden" name="action" value="update_1"/>-->
            <label>Product code:</label>
            <input type="text" name="code" required><br>
            <label>Product Description:</label>
            <input type="text" name="describe" required><br>
            <label>Product price:</label>
            <input type="text" name="price" required><br>  
            <input type="submit" value="Update Product"/>
            <button><a href="displayProducts" style="color: black; text-decoration: none">View Products</a></button>
        </form>
        <br>

    </body>
</html>
