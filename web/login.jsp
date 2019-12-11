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
        <script>
              function chgAction(action_name){
                  if(action_name =="stu"){
                      //document.login.action = "studentMain";
                      document.getElementById("loginType").value = "student";
                  }else if (action_name =="tec"){
                      //document.login.action = "teacherMain";
                      document.getElementById("loginType").value = "teacher";
                  }else if (action_name =="adm"){
                      //document.login.action = "adminMain";
                      document.getElementById("loginType").value = "admin";
                  }
                  document.login.submit();
              }
        </script>
    </head>
    <body>
        <p>Attendance Monitoring System</p>
        <form method="post" action="main" name="login">
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
                            <input type="hidden" value="student" id="loginType" name="loginType">
                            <input type="button" value="Login As Student" onclick="chgAction('stu')">
                            <input type="button" value="Login As Teacher" onclick="chgAction('tec')">
                            <input type="button" value="Login As Administrator" onclick="chgAction('adm')">
                            
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
