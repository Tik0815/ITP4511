<%-- 
    Document   : createLesson
    Created on : 2019/12/15, 下午 01:33:38
    Author     : Tik0815
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creat Lesson Page</title>
    </head>
        
    <body>
        <jsp:include page="header.jsp" />
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <jsp:useBean id="teacherBean" class="ict.bean.Teacher" scope="session"/>
        <b> Hello Teacher, <jsp:getProperty name="userInfo" property="username" /> </b>
          
        <jsp:getProperty name="teacherBean" property="firstName" /> 
        <jsp:getProperty name="teacherBean" property="lastName" /> ,
        <br>
        <b>Create Lesson for <% out.println(request.getAttribute("subject"));%> :</b><br>
        <%
                    out.println("<form method=\"get\" action=\"getLessons\">");
                    out.println("Lesson Id : <input type=\"text\" name=\"lessonId\" required><br>");
                    out.println("Date : <input type=\"date\" name=\"date\" required><br>");
                    out.println("Teacher Id : <input type=\"text\" name=\"user\" value=\"" + request.getAttribute("user") + "\" readonly required><br>");
                    out.println("Subject Id : <input type=\"text\" name=\"subject\" value=\"" + request.getAttribute("subject") + "\" readonly required><br>");
                    out.println("Class : <input type=\"text\" name=\"stuClass\" required><br>");
                    out.println("<input type=\"hidden\" name=\"action\" value=\"add\">");
                    out.println("<input type=\"submit\">");
                    out.println("</form>");
                    out.println("<a href=\"teacher.jsp\">Back Menu</a>");
                    
%>      
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
