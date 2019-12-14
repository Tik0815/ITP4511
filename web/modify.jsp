<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify account information</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
            <a href="UpdateDeleteAdmin?action=list"/>Modify Administrator</a><br/>
            <a href="UpdateDeleteStudent?action=list"/>Modify Student</a><br/>
            <a href="UpdateDeleteTeacher?action=list"/>Modify Teacher</a><br/>
            <hr>
            <a href="administrator.jsp">Back</a><br/>
        <jsp:include page="footer.jsp" />       
    </body>
</html>
