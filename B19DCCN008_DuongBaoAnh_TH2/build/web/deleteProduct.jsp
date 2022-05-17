<%-- 
    Document   : delete
    Created on : Apr 25, 2022, 5:53:40 PM
    Author     : DELL
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
    </head>
    <body>
        <h1>Are you sure you want to detete this product?</h1>
        <form action="deleteProduct" method="post">
            <input type="hidden" name="code" value="${p.code}"/>
            <label> Product Code: ${p.code}</label> </br>
            <label> Product Description: ${p.describe}</label> </br>
            <label> Product Price: ${p.price}</label>
            </br>
            </br>
            <input type="submit" action ="deleteProduct" value="Yes"/>
            <button><a href="displayProducts" style="text-decoration: none; color: black">No</a></button>
        </form>
    </body>

</body>
</html>
