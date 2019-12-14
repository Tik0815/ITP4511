<%-- 
    Document   : administrator
    Created on : 2019/12/10, 下午 09:12:50
    Author     : Tik0815
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        
        
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <b> Hello Admin, <jsp:getProperty name="userInfo" property="username" /> </b><br>
        
        <a href="AccountController?action=create&user=<jsp:getProperty name="userInfo" property="username"/>" >Create New User</a><br/>
        <a href="AccountController?action=register&user=<jsp:getProperty name="userInfo" property="username"/>" >Register student according to class</a><br/>
        <a href="AccountController?action=modify&user=<jsp:getProperty name="userInfo" property="username"/>" >Modify account information</a><br/>
        <a href="AccountController?action=role&user=<jsp:getProperty name="userInfo" property="username"/>" >Manage the user role</a><br/>
        <hr>
        
        <form method="post" action ="login.jsp">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout" name="logoutButton">
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
