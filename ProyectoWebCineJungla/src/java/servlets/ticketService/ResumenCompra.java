package servlets.ticketService;

import datos.DBCliente;
import datos.DBFacturaCliente;
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
import logica.Automatizacion.CalcularFactura;
import logica.Automatizacion.GenerarRegistroComida;

/**
 * Esta clase ejecuta en el servidor datos para la generacion de resumen de la 
 * transaccion.
 * 
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class ResumenCompra extends HttpServlet {

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
        DBCliente DBc = new DBCliente();
        DBFacturaCliente DBfc = new DBFacturaCliente();
        DBRegistroComida DBrc = new DBRegistroComida();
        DBRegistroBoleta DBrb = new DBRegistroBoleta();
        DBPelicula DBp = new DBPelicula();
        //resultsets
        ResultSet res1;
        ResultSet factura;
        ResultSet rc;
        ResultSet rb;
        ResultSet peli;
        try  {
            //se genera registro de la comida
            GenerarRegistroComida generate = new GenerarRegistroComida(
                    Integer.parseInt(request.getParameter("idComida")),
                    Integer.parseInt(request.getParameter("idFactura")),
                    Integer.parseInt(request.getParameter("cantidad")));
            //se calcula la factura
            CalcularFactura calcular = new CalcularFactura(Integer.parseInt(request.getParameter("idFactura")));
            //Se traen los resultados correspondientes de base de datos
            factura = DBfc.getFacturaClienteById(Integer.parseInt(request.getParameter("idFactura")));
            rc = DBrc.getRegistroComidaByFacturaClienteResumen(Integer.parseInt(request.getParameter("idFactura")));
            rb = DBrb.getRegistroBoletaByFacturaClienteResumen(Integer.parseInt(request.getParameter("idFactura")));
            //se obtiene nombre cliente
            res1 = DBc.getClienteById(Integer.parseInt(request.getParameter("idCliente")));
            res1.next();
            //Se carga pelicula
            peli = DBp.getPeliculaById(Integer.parseInt(request.getParameter("idPelicula")));
            //Carga en session
            request.getSession().setAttribute("idCliente", request.getParameter("idCliente"));
            request.getSession().setAttribute("Nombre", res1.getString("Nombre"));
            request.getSession().setAttribute("Factura", factura);
            request.getSession().setAttribute("pelicula", peli);
            request.getSession().setAttribute("rc", rc);
            request.getSession().setAttribute("rb", rb);
            response.sendRedirect("pagoC.jsp");
        }catch(Exception e){
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
