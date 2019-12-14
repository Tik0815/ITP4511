<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Student</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <form method="post" action="create">
            <input type="hidden" name="action"  value="student" />
            Student ID: <input type="number" name="studentID"><br>           
            Password: <input type="text" name="studentPW"><br>
            FirstName: <input type="text" name="studentFname"><br>
            LastName: <input type="text" name="studentLname"><br>
            Class: <input type="text" name="studentClass"><br>
            <input type="submit" value="Create New Student"><br>
        </form>
        <hr>
        <a href="create.jsp">Back</a><br/>
        <jsp:include page="footer.jsp" />
    </body>
</html>
