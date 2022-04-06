package servlets.ticketEmpleado;

import datos.DBCliente;
import datos.DBEmpleado;
import datos.DBFacturaCliente;
import datos.DBFacturaRapida;
import datos.DBPelicula;
import datos.DBRegistroBoleta;
import datos.DBRegistroComida;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class NegarE extends HttpServlet {

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
        //conexion base de datos
        DBRegistroComida DBrc = new DBRegistroComida();
        DBRegistroBoleta DBrb = new DBRegistroBoleta();
        DBFacturaRapida DBfc = new DBFacturaRapida();
        DBPelicula DBp = new DBPelicula();
        DBEmpleado DBc = new DBEmpleado();
        //resultsets
        ResultSet res1;
        ResultSet resP;
        try  {
            System.out.println(request.getParameter("idFactura"));
            DBrc.eliminarRegistroComidaByFacturaRapida(Integer.parseInt(request.getParameter("idFactura")));
            DBrb.eliminarRegistroBoletaByFacturaRapida(Integer.parseInt(request.getParameter("idFactura")));
            DBfc.eliminarFacturaRapida(Integer.parseInt(request.getParameter("idFactura")));
            
            res1 = DBc.getEmpleadoById(Integer.parseInt(request.getParameter("idEmpleado")));
            res1.next();
            resP = DBp.getPeliculaByEstado("Cartelera");
            request.getSession().setAttribute("idEmpleado", request.getParameter("idEmpleado"));
            request.getSession().setAttribute("Nombre", res1.getString("Nombre"));
            request.getSession().setAttribute("peliculas", resP);
            response.sendRedirect("inicioE.jsp");
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
