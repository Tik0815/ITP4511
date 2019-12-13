package ict.servlet;

import ict.bean.AdminBean;
import ict.db.AdminDB;
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
@WebServlet(name = "UpdateDeleteAdmin", urlPatterns = {"/UpdateDeleteAdmin"})
public class UpdateDeleteAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private AdminDB adminDB;
    
    public void init() {       
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        adminDB = new AdminDB(url, username, password);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {           
            String action = request.getParameter("action");
            
            if ("list".equalsIgnoreCase(action)) {
                
                ArrayList<AdminBean> admins = adminDB.queryAdmin(); 
                request.setAttribute("admins", admins);
                
                RequestDispatcher rd;
                rd = getServletContext().getRequestDispatcher("/modifyAdmin.jsp");
                rd.forward(request, response);
            } else if ("delete".equalsIgnoreCase(action)) {
                String id = request.getParameter("id");
                if (id != null) {               
                    adminDB.delAdmin(id);
                    response.sendRedirect("UpdateDeleteAdmin?action=list");
                }
            }else if("getEditCustomer".equalsIgnoreCase(action)){
                String id = request.getParameter("id");
                if (id != null) {                
                    AdminBean admin = adminDB.queryAdminById(id);                                       
                    RequestDispatcher rd;
                    rd = getServletContext().getRequestDispatcher("/editAdmin.jsp");
                    request.setAttribute("adm", admin);
                    rd.forward(request, response);                   
                }    
            }else if ("edit".equalsIgnoreCase(action)) { 
                String id = request.getParameter("adminID");
                String ac = request.getParameter("adminAC");
                String pw = request.getParameter("adminPW");
                String fname = request.getParameter("adminFname");
                String lname = request.getParameter("adminLname");
                AdminBean a = adminDB.queryAdminById(id);              
                a.setId(id);
                a.setAc(ac);
                a.setPw(pw);
                a.setFirstName(fname);
                a.setLastName(lname);
                adminDB.editAdmin(a);
                
              response.sendRedirect("UpdateDeleteAdmin?action=list");
             
            } else {
                
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
