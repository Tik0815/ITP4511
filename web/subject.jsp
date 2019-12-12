<%-- 
    Document   : brands
    Created on : 2019/11/26, 下午 05:08:53
    Author     : Tik0815
--%>
<%@page import = "ict.bean.*, java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Subjects</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <jsp:useBean id="studentBean" class="ict.bean.Student" scope="session"/>
        <b> Hello Student, <jsp:getProperty name="userInfo" property="username" /> </b>
          
        <jsp:getProperty name="studentBean" property="firstName" /> 
        <jsp:getProperty name="studentBean" property="lastName" /> ,
        <jsp:getProperty name="studentBean" property="studentClass" />
        <b> Your Subject: </b><p/>
        
        <jsp:useBean id="subjects" scope="request"
                     class="java.util.ArrayList<ict.bean.Subject>" />
        
        <% 
            for (int i = 0; i < subjects.size(); i++){
                Subject s = subjects.get(i);
                out.println("<a href=\"getLessons?action=list&subject=" +
                        s.getId()+ "\">" + s.getId() + " - " + s.getName() + "</a><br/>");
                
            }
        %>
        <jsp:include page="footer.jsp" />
        <hr/>
    </body>
</html>
