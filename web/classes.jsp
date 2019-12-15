<%-- 
    Document   : classes
    Created on : 2019/12/15, 下午 12:25:33
    Author     : Tik0815
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <jsp:useBean id="teacherBean" class="ict.bean.Teacher" scope="session"/>
        <b> Hello Teacher, <jsp:getProperty name="userInfo" property="username" /> </b>
        
        <jsp:getProperty name="teacherBean" property="firstName" /> 
        <jsp:getProperty name="teacherBean" property="lastName" />
        <br><b> Class: </b><p/>
        
        <jsp:useBean id="classes" scope="request"
                     class="java.util.ArrayList" />
        
        <% 
            for (int i = 0; i < classes.size(); i++){
                out.println("<a href=\"ClassController?action=listStudent&stuClass=" +
                        classes.get(i)+ "\">" + classes.get(i) + "</a><br/>");
                
            }
            out.println("<br><a href=\"teacher.jsp\">Back Menu</a>");
        %>
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
