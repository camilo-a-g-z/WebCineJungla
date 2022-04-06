package servlets;

import datos.DBPelicula;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Automatizacion.FuncionesByMultiplex;

/**
 * Esta clase ejecuta en el servidor lo referente a la elecicion de la taquilla
 * de peliculas.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class PeliculaEspecifica extends HttpServlet {

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
        DBPelicula DBp = new DBPelicula();
        try{
            ResultSet res1 = DBp.getPeliculaById(Integer.parseInt(request.getParameter("idPelicula")));
            FuncionesByMultiplex test = new FuncionesByMultiplex(
                    Integer.parseInt(request.getParameter("idPelicula")), 
                    Integer.parseInt(request.getParameter("idMultiplex")), 
                    Integer.parseInt(request.getParameter("anio")), 
                    Integer.parseInt(request.getParameter("mes")),
                    Integer.parseInt(request.getParameter("dia")));
            request.getSession().setAttribute("array", test.getFunciones());
            request.getSession().setAttribute("pelicula", res1);
        }catch(Exception e){
            
        }
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PeliculaEspecifica</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PeliculaEspecifica at " + request.getContextPath() + "</h1>");
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
