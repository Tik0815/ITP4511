<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New User</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
            <a href="createAdmin.jsp"/>Create Administrator</a><br/>
            <a href="createStudent.jsp"/>Create Student</a><br/>
            <a href="createTeacher.jsp"/>Create Teacher</a><br/>
            <hr>
            <a href="administrator.jsp">Back</a><br/>
        <jsp:include page="footer.jsp" />
    </body>
</html>
