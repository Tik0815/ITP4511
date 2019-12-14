package ict.servlet;

import ict.bean.Student;
import ict.db.StudentDB;
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
@WebServlet(name = "UpdateDeleteStudent", urlPatterns = {"/UpdateDeleteStudent"})
public class UpdateDeleteStudent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private StudentDB studentDB;
    
    public void init() {       
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        studentDB = new StudentDB(url, username, password);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {           
            String action = request.getParameter("action");
            
            if ("list".equalsIgnoreCase(action)) {
                
                ArrayList<Student> students = studentDB.queryStudent(); 
                request.setAttribute("students", students);
                
                RequestDispatcher rd;
                rd = getServletContext().getRequestDispatcher("/modifyStudent.jsp");
                rd.forward(request, response);
            } else if ("delete".equalsIgnoreCase(action)) {
                String id = request.getParameter("id");
                if (id != null) {
                    studentDB.delStudent(id);
                    response.sendRedirect("UpdateDeleteStudent?action=list");
                }
            } else if("getEdit".equalsIgnoreCase(action)){
                String id = request.getParameter("id");
                if (id != null) {                
                    Student student = studentDB.queryStudentById(id);                                       
                    RequestDispatcher rd;
                    rd = getServletContext().getRequestDispatcher("/editStudent.jsp");
                    request.setAttribute("stu", student);
                    rd.forward(request, response);                   
                }    
            }else if ("edit".equalsIgnoreCase(action)) { 
                String id = request.getParameter("studentID");                
                String pw = request.getParameter("studentPW");
                String fname = request.getParameter("studentFname");
                String lname = request.getParameter("studentLname");
                String studentClass = request.getParameter("studentClass");
                Student s = studentDB.queryStudentById(id);              
                s.setId(id);
                s.setPw(pw);
                s.setFirstName(fname);
                s.setLastName(lname);
                s.setStudentClass(studentClass);
                studentDB.editStudent(s);                
              response.sendRedirect("UpdateDeleteStudent?action=list");
             
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
