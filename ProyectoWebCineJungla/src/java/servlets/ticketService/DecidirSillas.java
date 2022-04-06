package servlets.ticketService;

import datos.DBCliente;
import datos.DBPelicula;
import datos.DBSillaFuncion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Camilo Garcia
 */
public class DecidirSillas extends HttpServlet {

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
        DBSillaFuncion DBsf = new DBSillaFuncion();
        DBCliente DBc = new DBCliente();
        DBPelicula DBp = new DBPelicula();
        //resultsets
        ResultSet res1;
        ResultSet res2;
        ResultSet res3;
        try{
           res1 = DBsf.getSillaFuncionByidFuncionAndEstado(Integer.parseInt(request.getParameter("idFuncion")));
           res2 = DBc.getClienteById(Integer.parseInt(request.getParameter("idCliente")));
           res2.next();
           res3 = DBp.getPeliculaById(Integer.parseInt(request.getParameter("idPelicula")));
           //Se carga en session
           request.getSession().setAttribute("Nombre", res2.getString("Nombre"));
           request.getSession().setAttribute("idCliente", request.getParameter("idCliente"));
           request.getSession().setAttribute("idFactura", request.getParameter("idFactura"));
           request.getSession().setAttribute("sillas", res1);
           request.getSession().setAttribute("cantidad", request.getParameter("cantidad"));
           request.getSession().setAttribute("pelicula", res3);
           response.sendRedirect("funcionFinal.jsp");
        }catch(Exception e){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DecidirSillas</title>");            
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
