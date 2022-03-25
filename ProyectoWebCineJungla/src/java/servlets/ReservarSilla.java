package servlets;

import datos.DBCliente;
import datos.DBEmpleado;
import datos.DBFuncion;
import datos.DBSilla;
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
public class ReservarSilla extends HttpServlet {

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
        DBSilla DBs = new DBSilla();
        DBFuncion DBf = new DBFuncion();
        DBEmpleado DBe = new DBEmpleado();
        DBCliente DBc = new DBCliente();
        try {
            //Recibo cantidad de sillas el id de una funcion y el id de usuario o el del empleado
            ResultSet res1 = DBf.getFuncionById(Integer.parseInt(request.getParameter("idFuncion")));
            res1.next();
            ResultSet res2 = DBs.getSillaByidSala(res1.getInt("Sala_idSala"));
            request.getSession().setAttribute("funcion", res1);
            request.getSession().setAttribute("sillas", res2);
            request.getSession().setAttribute("peliculas", request.getParameter("idUsuario"));
            //Aqui va la redireccion
            //Devuelvo las sillas, la funcion y el id de usuario o el del empleado
        }catch(Exception e){
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReservarSilla</title>");            
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
