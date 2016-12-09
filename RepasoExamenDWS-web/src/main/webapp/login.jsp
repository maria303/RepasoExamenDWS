<%-- 
    Document   : login
    Created on : 09-dic-2016, 12:36:48
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet" method="POST">
            <label>DNI</label>
            <input type="text" name="dni" value=""/><br>
            <label>PASSWORD</label>
            <input type="text" name="password" value=""/><br>
            <input type="submit" value="Entrar"/>
        </form>
    </body>
</html>
