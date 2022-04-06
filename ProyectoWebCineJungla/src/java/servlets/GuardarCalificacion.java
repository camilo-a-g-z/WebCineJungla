package servlets;

import datos.DBCalificacionPelicula;
import datos.DBCalificacionServicio;
import datos.DBCliente;
import datos.DBFacturaCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.CalificacionPelicula;
import logica.CalificacionServicio;

/**
 *
 * @author User
 */
public class GuardarCalificacion extends HttpServlet {

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
        //variables
        String idCliente = request.getParameter("idCliente");        
        //conexion con base de datos
        DBCliente DBc = new DBCliente();
        DBFacturaCliente DBfc = new DBFacturaCliente();
        DBCalificacionPelicula DBcp = new DBCalificacionPelicula();
        DBCalificacionServicio DBcs = new DBCalificacionServicio();
        //resultsets
        ResultSet res1;
        ResultSet res2;
        ResultSet res;
        //generacion de objetos
        CalificacionPelicula cp = new CalificacionPelicula();
        cp.setCalificacion(Double.parseDouble(request.getParameter("calPelicula")));
        cp.setCliente_idCliente(Integer.parseInt(request.getParameter("idCliente")));
        System.out.println(request.getParameter("idFactura"));
        cp.setFacturaCliente_idFacturaCliente(Integer.parseInt(request.getParameter("idFactura")));
        System.out.println("AQui");
        CalificacionServicio cs = new CalificacionServicio();
        cs.setCalificacion(Double.parseDouble(request.getParameter("calServicio")));
        cs.setCliente_idCliente(Integer.parseInt(request.getParameter("idCliente")));
        cs.setFacturaCliente_idFacturaCliente(Integer.parseInt(request.getParameter("idFactura")));
        try {
            DBcp.insertarCalificacionPelicula(cp);
            DBcs.insertarCalificacionPelicula(cs);
            
            res1 = DBc.getClienteById(Integer.parseInt(idCliente));
            res2 = DBfc.getFacturaClienteByCliente(Integer.parseInt(idCliente));
            request.getSession().setAttribute("idCliente", idCliente);
            request.getSession().setAttribute("cliente", res1);
            request.getSession().setAttribute("facturas", res2);
            response.sendRedirect("usuario.jsp");
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
