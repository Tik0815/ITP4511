<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="ict.bean.AdminBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Admin</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <%
                    ArrayList<AdminBean> admins = (ArrayList<AdminBean> )request.getAttribute("admins");
                    out.println("<h1>Administrator Information</h1>");
                    out.println("<table border='1' >");
                    out.println("<tr>");
                    out.println("<th>Administrator ID</th><th>Administrator Account</th><th>Password</th><th>First Name</th ><th>Last Name</th >");
                    out.println("</tr>");
                    for (int i = 0; i < admins.size(); i++) {
                        AdminBean a = admins.get(i);
                        out.println("<tr>");
                        out.println("<td>" + a.getId() + "</td>");
                        out.println("<td>" + a.getAc() + "</td>");
                        out.println("<td>" + a.getPw() + "</td>");
                        out.println("<td>" + a.getFirstName() + "</td>");
                        out.println("<td>" + a.getLastName() + "</td>");
                        out.println("<td><a href=\"UpdateDeleteAdmin?action=delete&id=" + a.getId() + "\">delete</a></td>");
                        out.println("<td><a href=\"UpdateDeleteAdmin?action=getEdit&id=" + a.getId() + "\">edit</a></td>");
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