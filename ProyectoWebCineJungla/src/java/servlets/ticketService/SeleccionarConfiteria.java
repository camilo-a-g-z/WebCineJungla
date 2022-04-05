package servlets.ticketService;

import datos.DBCliente;
import datos.DBComida;
import datos.DBRegistroBoleta;
import datos.DBRegistroComida;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Automatizacion.GenerarRegistroTicket;
import logica.Automatizacion.ObtenerDatosSillaFuncion;
import logica.RegistroBoleta;
import logica.RegistroComida;

/**
 *
 * @author Camilo Garcia
 */
public class SeleccionarConfiteria extends HttpServlet {

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
        DBComida comida = new DBComida();
        //resultsets
        ResultSet res1;
        ResultSet res2;
        try {
            //se generan los registros
            for(int i=0; i<Integer.parseInt(request.getParameter("cantidad"));i++){
                GenerarRegistroTicket gRT = new GenerarRegistroTicket(
                    Integer.parseInt(request.getParameter("idSala"+i)), 
                    Integer.parseInt(request.getParameter("idFactura")));
            }
            //se traen datos de la confiteria
            ObtenerDatosSillaFuncion data = new ObtenerDatosSillaFuncion(Integer.parseInt(request.getParameter("idSala0")));
            res2 = comida.getComidaByMultiplex(data.getSf().getFuncion_idFuncion());
            //Datos de cliente
            res1 = DBc.getClienteById(Integer.parseInt(request.getParameter("idCliente")));
            res1.next();
            //Cargar a session
            request.getSession().setAttribute("Nombre", res1.getString("Nombre"));
            request.getSession().setAttribute("idCliente", request.getParameter("idCliente"));
            request.getSession().setAttribute("idFactura", request.getParameter("idFactura"));
            request.getSession().setAttribute("comida", res2);
            response.sendRedirect("confiteria.jsp");
        }catch(Exception e){
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SeleccionarConfiteria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error at " + e.getMessage() + "</h1>");
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
