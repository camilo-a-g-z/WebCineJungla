/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets.AdminComunication;

import datos.DBComida;
import datos.DBEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class LoginEmpleado extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DBEmpleado DBc = new DBEmpleado();
        DBComida DBp = new DBComida();
        ResultSet resP;
        try {
            //se llama y guardan los datos recividos segun el parametro recivido
            
            ResultSet res = DBc.getEmpleadoLogin(request.getParameter("correo"));
            out.println("<html>");
            out.println("<body>");
            //se consulta si la respuesta esta vacia
            if (!res.next()) {
                out.println("<meta http-equiv='refresh' content='3;URL=ingresoC.jsp'>");//redirects after 3 seconds
                out.println("<p style='color:red;'>Contraseña o usuario incorrecto</p>");
            } else {
                if (res.getString("HashPsw") == null ? request.getParameter("contraseña") == null : res.getString("HashPsw").equals(request.getParameter("contraseña"))) {
                    resP = DBp.getComidas();
                    request.getSession().setAttribute("idEmpleado", res.getString("idEmpleado"));
                    request.getSession().setAttribute("comidas", resP);
                    out.println("<meta http-equiv='refresh' content='3;URL=adminConfiteria.jsp'>");//redirects after 3 seconds
                    out.println("<p style='color:red;'>Bienvenido "  + "</p>");
                } else {
                    out.println("<meta http-equiv='refresh' content='3;URL=ingresoC.jsp'>");//redirects after 3 seconds
                    out.println("<p style='color:red;'>Contraseña o usuario incorrecto</p>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }catch (Exception e){
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>error at " + e.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            System.out.println(e.getMessage());
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
