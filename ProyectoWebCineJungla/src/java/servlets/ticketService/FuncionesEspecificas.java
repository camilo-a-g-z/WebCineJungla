/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets.ticketService;

import datos.DBCliente;
import datos.DBFacturaCliente;
import datos.DBFuncion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.FacturaCliente;

/**
 *
 * @author User
 */
public class FuncionesEspecificas extends HttpServlet {

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
        DBFuncion DBf = new DBFuncion();
        PrintWriter out = response.getWriter();
        DBFacturaCliente DBfc = new DBFacturaCliente();
        FacturaCliente fc = new FacturaCliente();
        System.out.println(request.getParameter("anio"));
        fc.setAño(Integer.parseInt(request.getParameter("anio")));
        fc.setMes(Integer.parseInt(request.getParameter("mes")));
        fc.setDia(Integer.parseInt(request.getParameter("dia")));
        fc.setCliente_idCliente(Integer.parseInt(request.getParameter("idCliente")));
        fc.setTotal(0.0);
        ResultSet res3;
        DBCliente DBc = new DBCliente();
        int idFactura = 0;
        try {
            res3 = DBc.getClienteById(Integer.parseInt(request.getParameter("idCliente")));
            res3.next();
            request.getSession().setAttribute("Nombre", res3.getString("Nombre"));
            DBfc.insertarFacturaCliente(fc);
            idFactura = Integer.parseInt(DBfc.getLastId());
            ResultSet res = DBf.getFuncionByPelicula(Integer.parseInt(request.getParameter("idPelicula")));
            res.next();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FuncionesEspecificas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hora: " + res.getInt("Hora") + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
