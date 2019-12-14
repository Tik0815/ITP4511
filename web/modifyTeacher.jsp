<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="ict.bean.TeacherBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Teacher</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
         <%
                    ArrayList<TeacherBean> teachers = (ArrayList<TeacherBean> )request.getAttribute("teachers");
                    out.println("<h1>Teacher Information</h1>");
                    out.println("<table border='1'               >");
                    out.println("<tr>");
                    out.println("<th>Teacher ID</th><th>Teacher Account</th><th>Password</th><th>First Name</th ><th>Last Name</th ><th>Phone Number</th ><th>Email Address</th >");
                    out.println("</tr>");
                    for (int i = 0; i < teachers.size(); i++) {
                        TeacherBean t = teachers.get(i);
                        out.println("<tr>");
                        out.println("<td>" + t.getId() + "</td>");
                        out.println("<td>" + t.getAc() + "</td>");
                        out.println("<td>" + t.getPw() + "</td>");
                        out.println("<td>" + t.getFirstName() + "</td>");
                        out.println("<td>" + t.getLastName() + "</td>");
                        out.println("<td>" + t.getPhone() + "</td>");
                        out.println("<td>" + t.getEmail() + "</td>");
                        out.println("<td><a href=\"UpdateDeleteTeacher?action=delete&id=" + t.getId() + "\">delete</a></td>");
                        out.println("<td><a href=\"UpdateDeleteTeacher?action=getEdit&id=" + t.getId() + "\">edit</a></td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
%>
        <jsp:include page="footer.jsp" />
    </body>
</html>
