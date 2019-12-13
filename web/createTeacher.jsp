<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Teacher</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <form method="post" action="create">
            <input type="hidden" name="action"  value="teacher" />
            Teacher ID: <input type="text" name="teacherID"><br>
            Teacher Account Name: <input type="text" name="teacherAC"><br>
            Password: <input type="text" name="teacherPW"><br>
            FirstName: <input type="text" name="teacherFname"><br>
            LastName: <input type="text" name="teacherLname"><br>
            Phone Number: <input type="number" name="teacherPhone"><br>
            Email Address: <input type="email" name="teacherEmail"><br>
            <input type="submit" value="Create New Teacher"><br>
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
