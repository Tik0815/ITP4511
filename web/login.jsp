<%-- 
    Document   : login
    Created on : 2019/11/25, 上午 12:37:56
    Author     : Tik0815
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <p>Attendance Monitoring System</p>
        <form method="post" action="main">
            <input type="hidden" name="action" value="authenticate"/>
            <table border="0">
                <tr>
                    <td>
                        <p align="right"><b>login:</b>
                    </td>
                    <td>
                        <p>
                        <input type="text" name="username" maxlength="10" size="15">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p align="right"><b>password:</b></td>
                    </td>
                    <td>
                        <p>
                            <input type="password" name="password" maxlength="10" size="15">       
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p align="center">
                            <input type="submit" value="Login">
                    </td>
                </tr>
            </table>
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
