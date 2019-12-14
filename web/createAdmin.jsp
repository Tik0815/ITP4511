<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Administrator</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <form method="post" action="create">
            <input type="hidden" name="action"  value="admin" />
            Administrator ID: <input type="text" name="adminID"><br>
            Administrator Account Name: <input type="text" name="adminAC"><br>
            Password: <input type="text" name="adminPW"><br>
            FirstName: <input type="text" name="adminFname"><br>
            LastName: <input type="text" name="adminLname"><br>
            <input type="submit" value="Create New Administrator"><br>
        </form>
        <hr>
        <a href="create.jsp">Back</a><br/>
        <jsp:include page="footer.jsp" />
    </body>
</html>

