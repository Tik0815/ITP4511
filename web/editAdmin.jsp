<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id ="adm" scope="request" class="ict.bean.AdminBean"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Administrator</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <form method="get" action="UpdateDeleteAdmin">
            <input type="hidden" name="action"  value="edit" />
            Administrator ID: <input type="text" name="adminID" readonly value="<%=adm.getId()%>"><br>
            Administrator Account Name: <input type="text" name="adminAC" value="<%=adm.getAc()%>"><br>
            Password: <input type="text" name="adminPW" value="<%=adm.getPw()%>"><br>
            FirstName: <input type="text" name="adminFname" value="<%=adm.getFirstName()%>"><br>
            LastName: <input type="text" name="adminLname" value="<%=adm.getLastName()%>"><br>
            <input type="submit" value="Edit Administrator"><br>
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
