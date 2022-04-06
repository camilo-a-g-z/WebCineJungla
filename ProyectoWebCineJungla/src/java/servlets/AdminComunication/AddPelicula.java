package servlets.AdminComunication;

import datos.DBPelicula;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Pelicula;

/**
 *
 * @author USER
 */
public class AddPelicula extends HttpServlet {

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
        Pelicula pelicula = new Pelicula();
        DBPelicula DBpel = new DBPelicula();
        String empleado = request.getParameter("idEmpleado");
        pelicula.setNombre(request.getParameter("nombre"));
        pelicula.setClasificacionEdad(request.getParameter("clasificacionEdad"));
        pelicula.setDuracion(Integer.parseInt(request.getParameter("duracion")));
        pelicula.setDirector(request.getParameter("director"));
        pelicula.setSinopsis(request.getParameter("sinopsis"));
        pelicula.setUrlPelicula(request.getParameter("imagen"));
        pelicula.setEstado(request.getParameter("estado"));
        try {
            DBpel.insertarPelicula(pelicula);
            response.sendRedirect("ListarPeliculas?idEmpleado=" + empleado);
        }catch (Exception e){
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
