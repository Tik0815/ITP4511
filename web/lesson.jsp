<%-- 
    Document   : lesson
    Created on : 2019/12/11, 上午 12:56:45
    Author     : Tik0815
--%>

<%@page import="ict.bean.Lesson"%>
<%@page import="ict.bean.Attendance"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lesson Page</title>
    </head>
        
    <body>
        <jsp:include page="header.jsp" />
        <jsp:useBean id="userInfo" class="ict.bean.UserInfo" scope="session"/>
        <jsp:useBean id="studentBean" class="ict.bean.Student" scope="session"/>
        <b> Hello Student, <jsp:getProperty name="userInfo" property="username" /> </b>
          
        <jsp:getProperty name="studentBean" property="firstName" /> 
        <jsp:getProperty name="studentBean" property="lastName" /> ,
        <jsp:getProperty name="studentBean" property="studentClass" />
        <br>
        <b>Your attendance of <% out.println(request.getAttribute("subject"));%> :</b><br>
        <%
                    ArrayList<Attendance> attendList = (ArrayList<Attendance> )request.getAttribute("attendList");
                    
                    out.println(attendList.size());
                    out.println("<table border='1'>");
                    
	  // loop through the customer array to display each customer record
                    for (int i = 0; i < attendList.size(); i++) {
                        Attendance a = attendList.get(i);
                        Lesson l = a.getLesson();
                        out.println("<tr class='"+a.getIsAttend()+"'>");
                        out.println("<td>" + l.getDate() + "</td>");
                        out.println("");
                        if(a.getIsAttend())
                            out.println("<td width=20 align='center'> " + "✔" + "</td>");
                        else
                            out.println("<td width=20>" + "" + "</td>");
                        out.println("</tr>");

                    }
                    out.println("</table>");
%> 
        <jsp:include page="footer.jsp" />
        <script>
                var t = document.getElementsByClassName("true");
                for (var i=0;i<t.length; i++) {
                    t[i].style.backgroundColor = "#C5FFC7";
                }
                var f = document.getElementsByClassName("false");
                for (var i=0;i<f.length; i++) {
                    f[i].style.backgroundColor = "#FFCAC5";
                }
                
        </script>
    </body>
</html>
