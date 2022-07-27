<%-- 
    Document   : calculate
    Created on : Apr 19, 2022, 3:12:15 PM
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
        <h1>Math Form</h1>
        <form action="calculate.jsp">
            Enter number 1: <input type="text" name="num1"/><br>
            Enter number 2: <input type="text" name="num2"/><br>
            Select operator:
            <input type="radio" name="op" value="1" checked/>+
            <input type="radio" name="op" value="2"/>-
            <input type="radio" name="op" value="3"/>x
            <input type="radio" name="op" value="4"/>:<br>
            <input type="submit" value="Caculate"/>
        </form>
        <h2>Xu ly hoan toan bang JSP</h2>
        <% 
            if(request.getParameter("num1")!=null){            
            String n1_raw=request.getParameter("num1");
            String n2_raw=request.getParameter("num2");
            String op_raw=request.getParameter("op");
            int op=1;
            double n1=0, n2=0;
            String res="";
            try{
                n1=Double.parseDouble(n1_raw);
                n2=Double.parseDouble(n2_raw);
                op=Integer.parseInt(op_raw);
                switch(op){
                    case 1: res=n1+" + "+n2+" = "+(n1+n2);
                        break;
                    case 2: res=n1+" - "+n2+" = "+(n1-n2);
                        break;
                    case 3: res=n1+" x "+n2+" = "+(n1*n2);
                        break;
                    case 4: 
                        if(n2==0)
                            res= "divide by zero";
                        else
                            res=n1+" : "+n2+" = "+(n1/n2);
                        break;
                }  
            }catch(NumberFormatException ex){
                System.out.println(ex);
            }
        %>
        <h2 style="color: red"><%=res%></h2>
        <% } %>
    </body>
</html>
