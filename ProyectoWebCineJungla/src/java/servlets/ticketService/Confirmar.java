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
import logica.Cliente;

/**
 *
 * @author User
 */
public class Confirmar extends HttpServlet {

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
        DBCliente DBC = new DBCliente();
        DBFacturaCliente DBfc = new DBFacturaCliente();
        DBRegistroComida DBrc = new DBRegistroComida();
        DBRegistroBoleta DBrb = new DBRegistroBoleta();
        DBPelicula DBp = new DBPelicula();
        //objetos
        Cliente cli = new Cliente();
        Double puntos = 0.0;
        //resultsets
        ResultSet res1;
        ResultSet res2;
        ResultSet res3;
        ResultSet resP;
        try {
            res1 = DBC.getClienteById(Integer.parseInt(request.getParameter("idCliente")));
            res1.next();
            cli.setCorreo(res1.getString("Correo"));
            cli.setHashPsw(res1.getString("HashPsw"));
            cli.setIdCliente(res1.getInt("idCliente"));
            cli.setMedioPago_idMedioPago(res1.getInt("MedioPago_idMedioPago"));
            cli.setNombre(res1.getString("Nombre"));
            cli.setPuntosJungla(res1.getDouble("PuntosJungla"));
            System.out.println(request.getParameter("idFactura"));
            res2 = DBrc.getRegistroComidaByFacturaCliente(Integer.parseInt(request.getParameter("idFactura")));
            while(res2.next()){
                System.out.println("EntroComida");
                puntos +=5.0;
            }
            
            res3 = DBrb.getRegistroBoletaByFacturaCliente(Integer.parseInt(request.getParameter("idFactura")));
            while(res3.next()){
                System.out.println("EntroBoleta");
                puntos +=10.0;
            }
            puntos += cli.getPuntosJungla();
            cli.setPuntosJungla(puntos);
            DBC.modifyCliente(cli);
            resP = DBp.getPeliculaByEstado("Cartelera");
            request.getSession().setAttribute("idCliente", String.valueOf(cli.getIdCliente()));
            request.getSession().setAttribute("Nombre", cli.getNombre());
            request.getSession().setAttribute("peliculas", resP);
            response.sendRedirect("inicio.jsp");
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
