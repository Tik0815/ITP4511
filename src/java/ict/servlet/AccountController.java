package ict.servlet;
// import library
// map the servlet to url, brandController

import ict.db.AdminDB;
import ict.db.StudentDB;
import ict.db.TeacherDB;
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
  private AdminDB adminDB;
  private StudentDB studentDB;
  private TeacherDB teacherDB;
  public void init() {
        String dbUser = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String dbPassword = "root";
        String dbUrl = "";
        adminDB = new AdminDB(dbUrl, dbUser, dbPassword);
        studentDB = new StudentDB(dbUrl, dbUser, dbPassword);
        teacherDB = new TeacherDB(dbUrl, dbUser, dbPassword);
  }
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String action = request.getParameter("action");
   String user = request.getParameter("user"); 
   if ("create".equalsIgnoreCase(action)) {
     RequestDispatcher rd = this.getServletContext()
      .getRequestDispatcher("/create.jsp");
     rd.forward(request, response);         
   } else if ("register".equalsIgnoreCase(action)){
       RequestDispatcher rd = this.getServletContext()
      .getRequestDispatcher("/register.jsp");
     rd.forward(request, response);   
   } else if ("modify".equalsIgnoreCase(action)){
       RequestDispatcher rd = this.getServletContext()
      .getRequestDispatcher("/modify.jsp");
     rd.forward(request, response);   
   } else if ("role".equalsIgnoreCase(action)){
       RequestDispatcher rd = this.getServletContext()
      .getRequestDispatcher("/role.jsp");
     rd.forward(request, response);   
   } else {
        PrintWriter out = response.getWriter();
         out.println("NO such action :" +action);
   }
  }
}
