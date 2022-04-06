package servlets.ticketService;

import datos.DBCliente;
import datos.DBMultiplex;
import datos.DBPelicula;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Esta clase ejecuta en el servidor datos para el manejo de peliculas por
 * multiplex.
 * 
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class PeliculaMultiplex extends HttpServlet {

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
        DBPelicula DBp = new DBPelicula();
        DBMultiplex DBm = new DBMultiplex();
        ResultSet res1;
        ResultSet res2;
        ResultSet res3;
        DBCliente DBc = new DBCliente();
        try {
            res1 = DBp.getPeliculaById(Integer.parseInt(request.getParameter("idPelicula")));
            res2 = DBm.getMultiplexs();
            res3 = DBc.getClienteById(Integer.parseInt(request.getParameter("idCliente")));
            res3.next();
            request.getSession().setAttribute("idCliente", request.getParameter("idCliente"));
            request.getSession().setAttribute("pelicula", res1);
            request.getSession().setAttribute("multiplex", res2);
            request.getSession().setAttribute("Nombre", res3.getString("Nombre"));
            response.sendRedirect("funcion.jsp");
        } catch (Exception e) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PeliculaMultiplex</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PeliculaMultiplex at " + e.getMessage() + "</h1>");
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
