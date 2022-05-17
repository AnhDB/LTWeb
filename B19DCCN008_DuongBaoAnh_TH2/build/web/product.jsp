<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
    </head>
    <body>
        <h1>Products</h1>
        <table border="1px" width="50%">
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${data}" var="p">
                <tr>
                    <td>${p.code}</td>
                    <td>${p.describe}</td>
                    <td>${p.price}</td>
                    <td>
                        <a href="edit?productCode=${p.code}">Edit</a>
                    </td>
                    <td>
                        <a href="deleteProduct?productCode=${p.code}">Delete</a>
                    </td>
                </tr>
            </c:forEach>                
        </table>
        <br>
        <button><a href="addProduct" style="text-decoration: none; color: black">Add Product</a></button>

    </body>
</html>
