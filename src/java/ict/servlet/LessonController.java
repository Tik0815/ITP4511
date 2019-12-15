/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.Attendance;
import ict.bean.Lesson;
import ict.bean.Student;
import ict.bean.Subject;
import ict.bean.Teacher;
import ict.bean.UserInfo;
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

/**
 *
 * @author Tik0815
 */
@WebServlet(name = "LessonController", urlPatterns = {"/getLessons"})
public class LessonController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private LessonDB lessonDb;
    public void init(){
        String dbUser = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String dbPassword = "root";
        String dbUrl = "";
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
            
        if ("list".equalsIgnoreCase(action)) {
            String user = null;
            String subject = null;
            String stuClass = null;
            Student stuBean = (Student) request.getSession().getAttribute("studentBean");
            ArrayList<Attendance> attendList = null;
            
            user = stuBean.getInfo().getUsername();
            subject = request.getParameter("subject");
            attendList = lessonDb.getAttendance(user, subject);
            request.setAttribute("attendList", attendList);
            request.setAttribute("subject", subject);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/lesson.jsp");
            rd.forward(request, response);
        }else if("teacherList".equalsIgnoreCase(action)) {
            String teacherId = null;
            String subject = null;
            
            Teacher teaBean = (Teacher) request.getSession().getAttribute("teacherBean");
            teacherId = teaBean.getUserId();
            subject = request.getParameter("subject");
            ArrayList<Lesson> teacherLessons = lessonDb.getTeacherLessons(teacherId, subject);
            System.out.println(teacherLessons.size());
            request.setAttribute("lessonList", teacherLessons);
            request.setAttribute("subject", subject);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/teacherLesson.jsp");
            rd.forward(request, response);
        }else if("requestAdd".equalsIgnoreCase(action)) {
            String teacherId = null;
            String subject = null;
            
            Teacher teaBean = (Teacher) request.getSession().getAttribute("teacherBean");
            teacherId = teaBean.getUserId();
            subject = request.getParameter("subject");
            request.setAttribute("subject", subject);
            request.setAttribute("user", teacherId);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/createLesson.jsp");
            rd.forward(request, response);
            
        }else if("add".equalsIgnoreCase(action)) {
            String teacherId = null;
            String subject = null;
            String date = null;
            String lessonId = null;
            String stuClass = null;
            teacherId = request.getParameter("user");
            subject = request.getParameter("subject");
            date = request.getParameter("date");
            lessonId = request.getParameter("lessonId");
            stuClass = request.getParameter("stuClass");
            if(!lessonDb.createLesson(teacherId, subject, date, lessonId, stuClass))
                System.out.println("false");
            Teacher teaBean = (Teacher) request.getSession().getAttribute("teacherBean");
            teacherId = teaBean.getUserId();
            subject = request.getParameter("subject");
            request.setAttribute("subject", subject);
            request.setAttribute("user", teacherId);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/createLesson.jsp");
            rd.forward(request, response);
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
        processRequest(request, response);
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
