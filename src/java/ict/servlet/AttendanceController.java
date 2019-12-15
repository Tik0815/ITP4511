package ict.servlet;
// import library
// map the servlet to url, brandController

import ict.bean.Attendance;
import ict.bean.Lesson;
import ict.bean.Teacher;
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
import javax.swing.JOptionPane;

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
            rd = getServletContext().getRequestDispatcher("/checkAttendance.jsp");
            rd.forward(request, response);               
        }else if("modify".equalsIgnoreCase(action)) {
            ArrayList studentsAttendance = attendanceDb.getStudentsAttendance(lessonId);
            Lesson lesson = lessonDb.queryLessonById(lessonId);
            System.out.println(studentsAttendance.size()+"size");
            int size = studentsAttendance.size();
            for(int i = 0; i < studentsAttendance.size(); i++){
                System.out.println(i);
                Attendance attend = (Attendance)studentsAttendance.get(i);
                String stuAttend;
                if(request.getParameter(attend.getStu().getId()+"_attend") == null)
                    stuAttend = "false";
                else
                    stuAttend = request.getParameter(attend.getStu().getId()+"_attend");
                System.out.println(attend.getStu().getId() + " " + request.getParameter(attend.getStu().getId()+"_attend"));
                
                //if(request.getParameter(attend.getStu().getId()+"_attend").equals("true")){
                System.out.println(stuAttend);
                if(stuAttend.equalsIgnoreCase("true")){
                    attendanceDb.modifyStudentAttendance(lessonId, attend.getStu().getId(), Boolean.TRUE);
                }else{
                    attendanceDb.modifyStudentAttendance(lessonId, attend.getStu().getId(), Boolean.FALSE);
                   
                }    
                
            }
            
                RequestDispatcher rd;
                 String teacherId = null;
                String subject = null;

                Teacher teaBean = (Teacher) request.getSession().getAttribute("teacherBean");
                teacherId = teaBean.getUserId();
                subject = request.getParameter("subject");
                ArrayList<Lesson> teacherLessons = lessonDb.getTeacherLessons(teacherId, subject);
                System.out.println(teacherLessons.size());
                request.setAttribute("lessonList", teacherLessons);
                request.setAttribute("subject", subject);
                //done tick attendance but have to go back 
                
                rd = getServletContext().getRequestDispatcher("/teacherLesson.jsp");
                rd.forward(request, response);  
        }else if("back".equalsIgnoreCase(action)){
                RequestDispatcher rd;
                String teacherId = null;
                String subject = null;
                Teacher teaBean = (Teacher) request.getSession().getAttribute("teacherBean");
                teacherId = teaBean.getUserId();
                subject = request.getParameter("subject");
                ArrayList<Lesson> teacherLessons = lessonDb.getTeacherLessons(teacherId, subject);
                System.out.println(teacherLessons.size());
                request.setAttribute("lessonList", teacherLessons);
                request.setAttribute("subject", subject);
                //done tick attendance but have to go back 
                
                rd = getServletContext().getRequestDispatcher("/teacherLesson.jsp");
                //rd.forward(request, response); 
                response.sendRedirect("/teacherLesson.jsp");
        }else{
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
