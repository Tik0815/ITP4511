package ict.servlet;
// import library
// map the servlet to url, brandController

import ict.db.SubjectDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AccountController", urlPatterns = {"/AccountController"})


public class AccountController extends HttpServlet {
  private SubjectDB subjectDb;
  public void init() {
        String dbUser = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String dbPassword = "root";
        String dbUrl = "";
        subjectDb = new SubjectDB(dbUrl, dbUser, dbPassword);
  }
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String action = request.getParameter("action");
   String user = request.getParameter("user"); 
   if ("list".equalsIgnoreCase(action)) {
     ArrayList subjects = subjectDb.getSubjects(user);
     request.setAttribute("user", user);
     request.setAttribute("subjects", subjects);
     RequestDispatcher rd = this.getServletContext()
      .getRequestDispatcher("/subject.jsp");
     rd.forward(request, response);         
   }  else{
        PrintWriter out = response.getWriter();
         out.println("NO such action :" +action);
   }
  }
}
