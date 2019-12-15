<%-- 
    Document   : teacherAttendance
    Created on : 2019/12/11, 上午 12:56:45
    Author     : Tik0815
--%>

<%@page import="ict.bean.Student"%>
<%@page import="ict.bean.Lesson"%>
<%@page import="ict.bean.Attendance"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance Page</title>
    </head>
        
    <body>
        <jsp:include page="header.jsp" />
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <jsp:useBean id="teacherBean" class="ict.bean.Teacher" scope="session"/>
        <b> Hello Teacher, <jsp:getProperty name="userInfo" property="username" /> </b>
          
        <jsp:getProperty name="teacherBean" property="firstName" /> 
        <jsp:getProperty name="teacherBean" property="lastName" /> ,
        <br>
        <b>Lesson at  
            <% 
                Lesson lesson = (Lesson)request.getAttribute("lesson");
                out.print(lesson.getDate() +" of " + lesson.getSubjectId()+ " - " + lesson.getStuClass());
                
            %>
        </b>
        <br>
        <%
                    ArrayList lessonList = (ArrayList)request.getAttribute("studentsAttendance");
                    out.println(lessonList.size());
                    out.println("<form method=\"get\" action=\"AttendanceController?action=modify&id=" + lesson.getId()+"\">");
                    out.println("<table border='1'>");
                    out.println("<input type=\"hidden\" name=\"subject\" value=\"" + lesson.getSubjectId() + "\">");
	  // loop through the customer array to display each customer record
                    for (int i = 0; i < lessonList.size(); i++) {
                        Attendance a = (Attendance) lessonList.get(i);
                        Lesson l = a.getLesson();
                        Student s = a.getStu();
                        
                        out.println("<tr class='"+s.getId()+"'>");
                        out.println("<td>" + s.getId() + "</td>");
                        out.println("<td>" + s.getFirstName() +" "+ s.getLastName() + "</td>");
                        out.println("<td>" + s.getStudentClass() + "</td>");
                        out.println("<td>" + a.getIsAttend() + "</td>");
                        if(a.getIsAttend())
                            out.println("<td><input type=\"checkbox\" id=\""+s.getId()+"_attend\"name=\""+s.getId()+"_attend\" checked value=\"true\"");
                        else
                            out.println("<td><input type=\"checkbox\" id=\""+s.getId()+"_attend\"name=\""+s.getId()+"_attend\" value=\"true\" ");
                        out.println("</tr>");

                    }
                    out.println("</table>");
                    out.println("<input type=\"hidden\" name=\"action\" value=\"modify\">");
                    out.println("<input type=\"hidden\" name=\"id\" value=\""+ lesson.getId() + "\">");
                    out.println("<input type=\"submit\">");
                    out.println("<form>");
                    out.println("<p>");
                    out.println("<a href=\"teacher.jsp\">Back Menu</a>");
%> 
        <script>
        </script>
        
        <jsp:include page="footer.jsp" />
    </body>
</html>
