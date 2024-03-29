<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="ict.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Student</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <%
                    ArrayList<StudentBean> students = (ArrayList<StudentBean> )request.getAttribute("students");
                    out.println("<h1>Student Information</h1>");
                    out.println("<table border='1'               >");
                    out.println("<tr>");
                    out.println("<th>Student ID</th><th>Password</th><th>First Name</th ><th>Last Name</th ><th>Class</th >");
                    out.println("</tr>");
                    for (int i = 0; i < students.size(); i++) {
                        StudentBean s = students.get(i);
                        out.println("<tr>");
                        out.println("<td>" + s.getId() + "</td>");
                        out.println("<td>" + s.getPw() + "</td>");
                        out.println("<td>" + s.getFirstName() + "</td>");
                        out.println("<td>" + s.getLastName() + "</td>");
                        out.println("<td>" + s.getStudentClass() + "</td>");
                        out.println("<td><a href=\"UpdateDeleteStudent?action=delete&id=" + s.getId() + "\">delete</a></td>");
                        out.println("<td><a href=\"UpdateDeleteStudent?action=getEdit&id=" + s.getId() + "\">edit</a></td>");
                        out.println("</tr>");

                    }
                    out.println("</table>");
        %>
        <hr>
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <a href="AccountController?action=modify&user=<jsp:getProperty name="userInfo" property="username"/>" >Back</a><br/>
        <jsp:include page="footer.jsp" />
    </body>
</html>