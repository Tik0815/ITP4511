<%-- 
    Document   : teacher
    Created on : 2019/12/10, 下午 09:12:44
    Author     : Tik0815
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Page</title>
    </head>
    <body>
        
        <jsp:include page="header.jsp"/>
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <jsp:useBean id="teacherBean" class="ict.bean.Teacher" scope="session"/>
        <b> Hello Teacher, <jsp:getProperty name="userInfo" property="username" /> </b>
        
        <jsp:getProperty name="teacherBean" property="firstName" /> 
        <jsp:getProperty name="teacherBean" property="lastName" />
        
        <p></p>
        <a href="SubjectController?action=teacherlist&user=<jsp:getProperty name="teacherBean" property="userId"/>" >Show Subject</a><br/>
        
        <form method="post" action ="main">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout" name="logoutButton">
        </form>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
