<%-- 
    Document   : lesson
    Created on : 2019/12/11, 上午 12:56:45
    Author     : Tik0815
--%>

<%@page import="ict.bean.Lesson"%>
<%@page import="ict.bean.Attendance"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lesson Page</title>
    </head>
        
    <body>
        <jsp:include page="header.jsp" />
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <jsp:useBean id="teacherBean" class="ict.bean.Teacher" scope="session"/>
        <b> Hello Teacher, <jsp:getProperty name="userInfo" property="username" /> </b>
          
        <jsp:getProperty name="teacherBean" property="firstName" /> 
        <jsp:getProperty name="teacherBean" property="lastName" /> ,
        <br>
        <b>Your Lessons of <% out.println(request.getAttribute("subject"));%> :</b><br>
        <%
                    ArrayList<Lesson> lessonList = (ArrayList<Lesson> )request.getAttribute("lessonList");
                    
                    out.println(lessonList.size());
                    out.println("<table border='1'>");
                    
	  // loop through the customer array to display each customer record
                    for (int i = 0; i < lessonList.size(); i++) {
                        Lesson l = lessonList.get(i);
                        
                        out.println("<tr class='"+l.getId()+"'>");
                        out.println("<td>" + l.getId() + "</td>");
                        out.println("<td>" + l.getStuClass() + "</td>");
                        out.println("<td>" + l.getDate() + "</td>");
                        out.println("<td> <button onclick=\"window.location.href='/AttendanceController?action=list&id=" + l.getId() + "'\">Check</button>" );
                        out.println("</tr>");

                    }
                    out.println("</table>");
%> 
        <jsp:include page="footer.jsp" />
    </body>
</html>
