<%-- 
    Document   : student
    Created on : 2019/12/10, 下午 09:12:08
    Author     : Tik0815
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Page</title>
    </head>
    <body>
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <b> Hello Student, <jsp:getProperty name="userInfo" property="username" /> </b>
        <p/>
        Welcome!
        
        <p/>
        <a href="SubjectController?action=list&user=<jsp:getProperty name="userInfo" property="username"/>" >Show Subject</a><br/>
        
        <hr>
         <form method="post" action ="main">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout" name="logoutButton">
        </form>
    </body>
</html>