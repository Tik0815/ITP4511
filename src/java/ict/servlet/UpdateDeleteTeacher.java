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
            }else if("getEditCustomer".equalsIgnoreCase(action)){
                String id = request.getParameter("id");
                if (id != null) {
                    out.print("adc");
                    // call  query db to get retrieve for a customer with the given id
                    
                    //ArrayList<CustomerBean> customer = db.queryCustById(id);
                    
                    // set the customer as attribute in request scope
                    //request.setAttribute("cus", customer);
                                        
                    // forward the result to the editCustomer.jsp   
                    RequestDispatcher rd;
                    rd = getServletContext().getRequestDispatcher("/editCustomer.jsp");
                    rd.forward(request, response);
                    
                }    

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
