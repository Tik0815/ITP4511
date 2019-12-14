package ict.servlet;

import ict.bean.TeacherBean;
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

/**
 *
 * @author user
 */
@WebServlet(name = "UpdateDeleteTeacher", urlPatterns = {"/UpdateDeleteTeacher"})
public class UpdateDeleteTeacher extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private TeacherDB teacherDB;
    
    public void init() {       
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        teacherDB = new TeacherDB(url, username, password);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {           
            String action = request.getParameter("action");
            
            if ("list".equalsIgnoreCase(action)) {
                
                ArrayList<TeacherBean> teachers = teacherDB.queryTeacher(); 
                request.setAttribute("teachers", teachers);
                
                RequestDispatcher rd;
                rd = getServletContext().getRequestDispatcher("/modifyTeacher.jsp");
                rd.forward(request, response);
            } else if ("delete".equalsIgnoreCase(action)) {
                String id = request.getParameter("id");
                if (id != null) {
                    teacherDB.delTeacher(id);
                    response.sendRedirect("UpdateDeleteTeacher?action=list");
                }
            }else if("getEdit".equalsIgnoreCase(action)){
                String id = request.getParameter("id");
                if (id != null) {                
                    TeacherBean teacher = teacherDB.queryTeacherById(id);                                       
                    RequestDispatcher rd;
                    rd = getServletContext().getRequestDispatcher("/editTeacher.jsp");
                    request.setAttribute("tea", teacher);
                    rd.forward(request, response);                   
                }    
            }else if ("edit".equalsIgnoreCase(action)) { 
                String id = request.getParameter("teacherID");
                String ac = request.getParameter("teacherAC");
                String pw = request.getParameter("teacherPW");
                String fname = request.getParameter("teacherFname");
                String lname = request.getParameter("teacherLname");
                String phone = request.getParameter("teacherPhone");
                String email = request.getParameter("teacherEmail");
                TeacherBean t = teacherDB.queryTeacherById(id);              
                t.setId(id);
                t.setAc(ac);
                t.setPw(pw);
                t.setFirstName(fname);
                t.setLastName(lname);
                t.setPhone(phone);
                t.setEmail(email);
                teacherDB.editTeacher(t);
                
              response.sendRedirect("UpdateDeleteTeacher?action=list");
             
            }else{
                
                out.println("No such action!!!");
            }
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
