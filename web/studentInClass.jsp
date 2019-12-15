<%-- 
    Document   : classes
    Created on : 2019/12/15, 下午 12:25:33
    Author     : Tik0815
--%>
<%@page import="ict.bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <jsp:useBean id="teacherBean" class="ict.bean.Teacher" scope="session"/>
        <b> Hello Teacher, <jsp:getProperty name="userInfo" property="username" /> </b>
        
        <jsp:getProperty name="teacherBean" property="firstName" /> 
        <jsp:getProperty name="teacherBean" property="lastName" />
        <br><b> <% out.print(request.getParameter("stuClass")); %> Student : </b><p/>
        
       
        
        <% 
            out.println("<table border=1>");
            
            ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");
            for (int i = 0; i < students.size(); i++){
                Student s = students.get(i);
                out.println("<tr class='"+s.getId()+"'>");
                out.println("<td>" + s.getId() + "</td>");
                out.println("<td>" + s.getFirstName() +" "+ s.getLastName() + "</td>");
                out.println("<td>" + s.getStudentClass() + "</td>");
                out.println("</tr>");
                
            }
            out.println("</table>");
            
            out.println("<br><a href=\"teacher.jsp\">Back Menu</a>");
        %>
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
