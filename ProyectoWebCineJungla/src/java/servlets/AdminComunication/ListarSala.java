package servlets.AdminComunication;

import datos.DBConexion;
import datos.DBMultiplex;
import datos.DBSala;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Esta clase ejecuta en el servidor la lista de salas disponibles en los
 * multiplex.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class ListarSala extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        ResultSet resSala, resMulti;
        DBSala DBs = new DBSala();
        DBMultiplex DBm = new DBMultiplex();
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        try {
            resSala = DBs.getSalas();
            resMulti = DBm.getMultiplexs();
            request.getSession().setAttribute("resSala", resSala);
            request.getSession().setAttribute("resMulti", resMulti);
            request.getSession().setAttribute("idEmpleado", idEmpleado);
            response.sendRedirect("#"); // CAMBIAR DIRECCIONAMIENTO
        } catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarSala</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarSala at " + e.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    //Cierre del metodo
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
