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
import logica.Cliente;
import logica.Empleado;

/**
 *
 * @author User
 */
public class ConfirmarE extends HttpServlet {

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
        //conexion base datos
        DBEmpleado DBC = new DBEmpleado();
        DBFacturaRapida DBfc = new DBFacturaRapida();
        DBRegistroComida DBrc = new DBRegistroComida();
        DBRegistroBoleta DBrb = new DBRegistroBoleta();
        DBPelicula DBp = new DBPelicula();
        //objetos
        Empleado cli = new Empleado();
        Double puntos = 0.0;
        //resultsets
        ResultSet res1;
        ResultSet res2;
        ResultSet res3;
        ResultSet resP;
        try {
            res1 = DBC.getEmpleadoById(Integer.parseInt(request.getParameter("idEmpleado")));
            res1.next();
            resP = DBp.getPeliculaByEstado("Cartelera");
            request.getSession().setAttribute("idCliente", res1.getString("idEmpleado"));
            request.getSession().setAttribute("Nombre", cli.getNombre());
            request.getSession().setAttribute("peliculas", resP);
            response.sendRedirect("inicioE.jsp");
        } catch(Exception e){
            System.out.print(e.getMessage());
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
