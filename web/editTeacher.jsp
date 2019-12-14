<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id ="tea" scope="request" class="ict.bean.TeacherBean"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Teacher</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <form method="get" action="UpdateDeleteTeacher">
            <input type="hidden" name="action"  value="edit" />
            Teacher ID: <input type="text" name="teacherID" readonly value="<%=tea.getId()%>"><br>
            Teacher Account Name: <input type="text" name="teacherAC" value="<%=tea.getAc()%>"><br>
            Password: <input type="text" name="teacherPW" value="<%=tea.getPw()%>"><br>
            FirstName: <input type="text" name="teacherFname" value="<%=tea.getFirstName()%>"><br>
            LastName: <input type="text" name="teacherLname" value="<%=tea.getLastName()%>"><br>
            Phone Number: <input type="number" name="teacherPhone" value="<%=tea.getPhone()%>"><br>
            Email Address: <input type="email" name="teacherEmail" value="<%=tea.getEmail()%>"><br>
            <input type="submit" value="Edit Teacher"><br>
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
