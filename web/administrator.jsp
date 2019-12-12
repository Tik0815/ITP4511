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
        <b> Hello Admin, <jsp:getProperty name="userInfo" property="username" /> </b>
        
        <a href="AccountController?action=list&user=<jsp:getProperty name="userInfo" property="username"/>" >Show Accounts</a><br/>
        <a href="AccountController?action=list&user=<jsp:getProperty name="userInfo" property="username"/>" >Show Subject</a><br/>
        <hr>
        
        <form method="post" action ="main">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout" name="logoutButton">
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
