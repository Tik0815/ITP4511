<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id ="stu" scope="request" class="ict.bean.StudentBean"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Student</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <form method="get" action="UpdateDeleteStudent">
            <input type="hidden" name="action"  value="edit" />
            Student ID: <input type="number" name="studentID" readonly value="<%=stu.getId()%>"><br>           
            Password: <input type="text" name="studentPW" value="<%=stu.getPw()%>"><br>
            FirstName: <input type="text" name="studentFname" value="<%=stu.getFirstName()%>"><br>
            LastName: <input type="text" name="studentLname" value="<%=stu.getLastName()%>"><br>
            Class: <input type="text" name="studentClass" value="<%=stu.getStudentClass()%>"><br>
            <input type="submit" value="Edit Student"><br>
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
