package ict.servlet;
// import library
// map the servlet to url, brandController

import ict.db.BrandDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BrandController", urlPatterns = {"/brandController"})

public class BrandController extends HttpServlet {
  private BrandDB brandDb;
  public void init() {
        brandDb = new BrandDB ();
  }
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String action = request.getParameter("action");
   if ("list".equalsIgnoreCase(action)) {
     ArrayList brands = brandDb.getBrands();
     request.setAttribute("brands", brands);
     RequestDispatcher rd = this.getServletContext()
      .getRequestDispatcher("/brands.jsp");
     rd.forward(request, response);         
   }  else{
        PrintWriter out = response.getWriter();
         out.println("NO such action :" +action);
   }
  }
}
