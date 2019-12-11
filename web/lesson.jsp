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
        <b>Your attendance:</b><br>
        <%
                    ArrayList<Attendance> attendList = (ArrayList<Attendance> )request.getAttribute("attendList");
                    out.println(attendList.size());
                    out.println("<table border='1'>");
                    
	  // loop through the customer array to display each customer record
                    for (int i = 0; i < attendList.size(); i++) {
                        Attendance a = attendList.get(i);
                        Lesson l = a.getLesson();
                        out.println("<tr>");
                        out.println("<td>" + l.getDate() + "</td>");
                        out.println("");
                        out.println("<td>" + a.getIsAttend() + "</td>");
                        out.println("</tr>");

                    }
                    out.println("</table>");
%> 
        
    </body>
</html>
