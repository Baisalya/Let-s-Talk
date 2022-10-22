<%-- 
    Document   : SignOut
    Created on : 20 Oct, 2022, 9:44:57 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignOut</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.sendRedirect("main.html");
            %>
    </body>
</html>
