package ict.servlet;
// import library
// map the servlet to url, brandController

import ict.bean.Lesson;
import ict.db.AttendanceDB;
import ict.db.LessonDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AttendanceController", urlPatterns = {"/AttendanceController"})
public class AttendanceController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private AttendanceDB attendanceDb;
    private LessonDB lessonDb;
    public void init() {
          String dbUser = "jdbc:mysql://localhost:3306/ITP4511_DB";
          String dbPassword = "root";
          String dbUrl = "";
          attendanceDb = new AttendanceDB(dbUrl, dbUser, dbPassword);
          lessonDb = new LessonDB(dbUrl, dbUser, dbPassword);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LessonController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LessonController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String lessonId = request.getParameter("id");
        if ("list".equalsIgnoreCase(action)) {

             ArrayList studentsAttendance = attendanceDb.getStudentsAttendance(lessonId);
             Lesson lesson = lessonDb.queryLessonById(lessonId);
             request.setAttribute("studentsAttendance", studentsAttendance);
             request.setAttribute("lesson", lesson);
             RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/test.jsp");
            rd.forward(request, response);               
        }  else{
             PrintWriter out = response.getWriter();
              out.println("NO such action :" +action);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
