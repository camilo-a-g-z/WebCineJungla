package servlets;

import datos.DBEmpleado;
import datos.DBMultiplex;
import datos.DBPelicula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Automatizacion.rellenoSalas;
import logica.Empleado;

/**
 *
 * @author User
 */
public class Inicio extends HttpServlet {

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
        DBPelicula pelis = new DBPelicula();
        DBMultiplex DBm = new DBMultiplex();
        DBEmpleado DBe = new DBEmpleado();
        Empleado em = new Empleado();
        
        Date da = new Date(System.currentTimeMillis());  
        
        da.setYear(2022);
        da.setMonth(4);
        da.setDate(1);
        da.setMinutes(0);
        long timeInMilliSeconds = da.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        date1.setYear(da.getYear());
        date1.setMonth(da.getMonth());
        date1.setDate(da.getDate());
        //date1.setMinutes(da.getMinutes());
        em.setCedula("12345");
        em.setCedula("12345");
        //em.setFechaIngreso(date1);
        em.setHashPsw("1234");
        em.setMultiplex_idMultiplex(1);
        em.setNombre("Camilo");
        em.setNumTelefono("12345");
        em.setRol_idRol(1);
        em.setSalario(1000.0);
        
        try{
            rellenoSalas prueba = new rellenoSalas(1,1,2022,4,1,12,30);
            ResultSet res1 = pelis.getPeliculaByEstado("Cartelera");
            ResultSet res2 = DBm.getMultiplexs();
            request.getSession().setAttribute("peliculas", res1);
            request.getSession().setAttribute("multiplex", res2);
            
            //DBe.insertarEmpleado(em);
            System.out.println(date1);
            response.sendRedirect("ingresoE.jsp");
        }catch(Exception e){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inicio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Error: "+e.getMessage()+"</h1>");
            out.println("</body>");
            out.println("</html>");
            System.out.println();
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
