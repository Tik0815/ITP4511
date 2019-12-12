<%-- 
    Document   : loginError
    Created on : 2019/11/25, 上午 09:26:46
    Author     : Tik0815
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <p>InCorrect Password</p>
        <p>
            <% out.println("<a href=\"" + request.getContextPath()+ "\">Login again</a>"); %>
        <jsp:include page="footer.jsp" />
    </body>
</html>
