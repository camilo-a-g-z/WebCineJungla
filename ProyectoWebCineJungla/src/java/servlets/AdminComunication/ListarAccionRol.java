package servlets.AdminComunication;

import datos.DBConexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class ListarAccionRol extends HttpServlet {
    private ResultSet rs;//Crea objeto de tipo ResulSet
    private DBConexion con;//Crea objeto de tipo conexion
    private PreparedStatement st;//Crea objeto de tipo Statement
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
        ResultSet resAccionRol;
        try {
            resAccionRol=listarAccionRol();
            request.getSession().setAttribute("resFuncion",resAccionRol);
            response.sendRedirect("#"); //Cambiar direccionamiento
            
        }catch(Exception e){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarAccionRol</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarAccionRol at " + e.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public ResultSet listarAccionRol(){
        String consulta="select * from AccionRol";
        try {
            con = new DBConexion();//Obtengo la conexión
            st = con.getConexion().prepareStatement(consulta);//por medio del objeto conexión se prepara la consulta a la base de datos
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            st.close();// cierro la conexión
            con.desconectar(); //me desconecto de la base de datos
        } catch (SQLException e) {//Si captura algún error lo muestra
            System.out.println("Consulta imposible");
            System.out.println(e);
        }
        return rs;
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
