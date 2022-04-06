package servlets.ticketEmpleado;

import datos.DBCliente;
import datos.DBEmpleado;
import datos.DBFacturaCliente;
import datos.DBFacturaRapida;
import datos.DBFuncion;
import datos.DBPelicula;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Automatizacion.FuncionesByMultiplex;
import logica.FacturaCliente;
import logica.FacturaRapida;

/**
 *
 * @author User
 */
public class FuncionesEspecificasE extends HttpServlet {

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
        //conexiones a base de datos
        DBFuncion DBf = new DBFuncion();
        DBFacturaRapida DBfc = new DBFacturaRapida();
        DBEmpleado DBc = new DBEmpleado();
        DBPelicula DBp = new DBPelicula();
        //Generacion de factura
        FacturaRapida fc = new FacturaRapida();
        fc.setAño(Integer.parseInt(request.getParameter("anio")));
        fc.setMes(Integer.parseInt(request.getParameter("mes")));
        fc.setDia(Integer.parseInt(request.getParameter("dia")));
        fc.setEmpleado_idEmpleado(Integer.parseInt(request.getParameter("idEmpleado")));
        fc.setTotal(0.0);
        //resultsets
        ResultSet res1;
        ResultSet res2;
        ResultSet res3;
        //variables
        int idFactura = 0;
        try {
            res1 = DBc.getEmpleadoById(Integer.parseInt(request.getParameter("idEmpleado")));
            res1.next();
            //insertar factura
            DBfc.insertarFacturaRapida(fc);
            //guardar idfactura
            idFactura = Integer.parseInt(DBfc.getLastId());
            res2 = DBp.getPeliculaById(Integer.parseInt(request.getParameter("idPelicula")));
            FuncionesByMultiplex test = new FuncionesByMultiplex(
                    Integer.parseInt(request.getParameter("idPelicula")), 
                    Integer.parseInt(request.getParameter("idMultiplex")), 
                    Integer.parseInt(request.getParameter("anio")), 
                    Integer.parseInt(request.getParameter("mes")),
                    Integer.parseInt(request.getParameter("dia")));   
            //cargar a session
            request.getSession().setAttribute("Nombre", res1.getString("Nombre"));
            request.getSession().setAttribute("array", test.getFunciones());
            request.getSession().setAttribute("idEmpleado", request.getParameter("idEmpleado"));
            request.getSession().setAttribute("pelicula", res2);
            request.getSession().setAttribute("idFactura", idFactura);
            request.getSession().setAttribute("cantidad", request.getParameter("cantidad"));
            response.sendRedirect("funcionEspecificaE.jsp");
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
