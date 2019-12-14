/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.db.AdminDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "create", urlPatterns = {"/create"})
public class CreateController extends HttpServlet {
    
    private AdminDB db;
    
    public void init() {
    //1.  obtain the context-param, dbUser, dbPassword and dbUrl which defined in web.xml
    //2.  create a new db object  with the parameter
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        db = new AdminDB(url, username, password);
    } 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet create</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet create at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            if ("admin".equalsIgnoreCase(action)){                
                out.println("<title>Create Administrator</title>");
                String id = request.getParameter("adminID");
                String ac = request.getParameter("adminAC");
                String pw = request.getParameter("adminPW");
                String fname = request.getParameter("adminFname");
                String lname = request.getParameter("adminLname");                
                out.println("</head>");
                out.println("<body>");
                boolean good = db.createAdmin(id,ac,pw,fname,lname);
                if (good == true){
                    out.println("<h1>AdminID "+id+" added.</h1>");
                } else {
                    out.println("<h1>Error detected.\nPlease Input the information again.</h1>");
                }           
            } else if ("student".equalsIgnoreCase(action)){
                out.println("<title>Create Student</title>"); 
                String id = request.getParameter("studentID");               
                String pw = request.getParameter("studentPW");
                String fname = request.getParameter("studentFname");
                String lname = request.getParameter("studentLname"); 
                String studentClass = request.getParameter("studentClass");
                out.println("</head>");
                out.println("<body>");
                boolean good = db.createStudent(id,pw,fname,lname,studentClass);
                if (good == true){
                    out.println("<h1>StudentID "+id+" added.</h1>");
                } else {
                    out.println("<h1>Error detected.\nPlease Input the information again.</h1>");
                }           
            } else if ("teacher".equalsIgnoreCase(action)){
                out.println("<title>Create Teacher</title>"); 
                String id = request.getParameter("teacherID");
                String ac = request.getParameter("teacherAC");
                String pw = request.getParameter("teacherPW");
                String fname = request.getParameter("teacherFname");
                String lname = request.getParameter("teacherLname");
                String phone = request.getParameter("teacherPhone");
                String email = request.getParameter("teacherEmail");
                out.println("</head>");
                out.println("<body>");
                boolean good = db.createTeacher(id,ac,pw,fname,lname,phone,email);
                if (good == true){
                    out.println("<h1>TeacherID "+id+" added.</h1>");
                } else {
                    out.println("<h1>Error detected.\nPlease Input the information again.</h1>");
                }           
            } else {               
                out.println("<h1>failed "+action+"</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
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
