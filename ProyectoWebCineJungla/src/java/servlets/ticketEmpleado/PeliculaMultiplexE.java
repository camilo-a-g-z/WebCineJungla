package servlets.ticketEmpleado;

import datos.DBCliente;
import datos.DBEmpleado;
import datos.DBMultiplex;
import datos.DBPelicula;
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
public class PeliculaMultiplexE extends HttpServlet {

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
        DBPelicula DBp = new DBPelicula();
        DBMultiplex DBm = new DBMultiplex();
        ResultSet res1;
        ResultSet res2;
        ResultSet res3;
        DBEmpleado DBc = new DBEmpleado();
        try {
            res1 = DBp.getPeliculaById(Integer.parseInt(request.getParameter("idPelicula")));
            res2 = DBm.getMultiplexs();
            res3 = DBc.getEmpleadoById(Integer.parseInt(request.getParameter("idEmpleado")));
            res3.next();
            request.getSession().setAttribute("idEmpleado", request.getParameter("idEmpleado"));
            request.getSession().setAttribute("pelicula", res1);
            request.getSession().setAttribute("multiplex", res2);
            request.getSession().setAttribute("Nombre", res3.getString("Nombre"));
            response.sendRedirect("funcionE.jsp");
        } catch (Exception e) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PeliculaMultiplex</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PeliculaMultiplex at " + e.getMessage() + "</h1>");
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
