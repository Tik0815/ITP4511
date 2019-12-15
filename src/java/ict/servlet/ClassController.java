 package ict.servlet;
// import library
// map the servlet to url, brandController

import ict.bean.Student;
import ict.db.StudentDB;
import ict.db.SubjectDB;
import ict.db.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClassController", urlPatterns = {"/ClassController"})


public class ClassController extends HttpServlet {
  private UserDB userDb;
  public void init() {
        String dbUser = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String dbPassword = "root";
        String dbUrl = "";
        userDb = new UserDB(dbUrl, dbUser, dbPassword);
  }
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String action = request.getParameter("action");
   String user = request.getParameter("user"); 
   if ("list".equalsIgnoreCase(action)) {
        ArrayList classes = userDb.getClasses();
        
        //ArrayList students = userDb.queryStudentsByClass(user)
        request.setAttribute("user", user);
        request.setAttribute("classes", classes);
        RequestDispatcher rd = this.getServletContext()
         .getRequestDispatcher("/classes.jsp");
        rd.forward(request, response);         
   
        
   }else if("listStudent".equalsIgnoreCase(action)){
        String stuClass = request.getParameter("stuClass"); 
        ArrayList<Student> students = userDb.queryStudentsByClass(stuClass);
        request.setAttribute("user", user);
        request.setAttribute("stuClass", stuClass);
        request.setAttribute("students", students);
        RequestDispatcher rd = this.getServletContext()
         .getRequestDispatcher("/studentInClass.jsp");
        rd.forward(request, response);
   }else{
        PrintWriter out = response.getWriter();
         out.println("NO such action :" +action);
   }
  }
  
}
