/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package frontend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class adminPeliculas extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\n" +
"    <title>Table - Brand</title>\n" +
"    <link rel=\"stylesheet\" href=\"assetsAdmin/bootstrap/css/bootstrap.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\">\n" +
"    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Aclonica&amp;display=swap\">\n" +
"    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Aldrich&amp;display=swap\">\n" +
"    <link rel=\"stylesheet\" href=\"assetsAdmin/fonts/font-awesome.min.css\">\n" +
"</head>\n" +
"\n" +
"<body id=\"page-top\">\n" +
"    <div id=\"wrapper\">\n" +
"        <nav class=\"navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0\" style=\"background: rgb(0,0,0);\">\n" +
"            <div class=\"container-fluid d-flex flex-column p-0\"><a class=\"navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0\" href=\"#\" style=\"font-size: 23px;font-family: Aclonica, sans-serif;margin-top: 0px;\">\n" +
"                    <div class=\"sidebar-brand-text mx-3\"><span style=\"font-size: 23px;font-family: Aclonica, sans-serif;margin-top: 0px;\">cine jungla</span>\n" +
"                        <p style=\"font-size: 8px;font-family: Aldrich, sans-serif;margin-top: 0px;margin-bottom: -16px;\">Aministrador</p>\n" +
"                    </div>\n" +
"                </a>\n" +
"                <ul class=\"navbar-nav text-light\" id=\"accordionSidebar\">\n" +
"                    <li class=\"nav-item\"><a class=\"nav-link active\" href=\"adminPeliculas.html\"><i class=\"fa fa-video-camera\"></i><span style=\"margin-left: 8px;\">Películas</span></a><a class=\"nav-link\" href=\"adminConfitería.html\"><i class=\"fa fa-cutlery\"></i><span style=\"margin-left: 8px;\">Confitería</span></a><a class=\"nav-link\" href=\"adminPersonal.html\"><i class=\"fa fa-user-plus\"></i><span style=\"margin-left: 8px;\">Personal</span></a></li>\n" +
"                    <li class=\"nav-item\"></li>\n" +
"                    <li class=\"nav-item\"></li>\n" +
"                    <li class=\"nav-item\"></li>\n" +
"                    <li class=\"nav-item\"></li>\n" +
"                </ul><a href=\"index.html\"><button class=\"btn btn-primary\" type=\"button\" style=\"background: rgb(194,23,0);font-family: Aldrich, sans-serif;width: 149px;height: 38px;padding-left: 0px;padding-top: 4px;\">Cerrar sesión</button></a>\n" +
"                <div class=\"text-center d-none d-md-inline\"></div>\n" +
"            </div>\n" +
"        </nav>\n" +
"        <div class=\"d-flex flex-column\" id=\"content-wrapper\">\n" +
"            <div id=\"content\">\n" +
"                <div id=\"content-1\">\n" +
"                    <div class=\"container-fluid\">\n" +
"                        <h3 class=\"text-dark mb-4\" style=\"margin-top: 22px;font-family: Aclonica, sans-serif;font-size: 28px;\">Películas&nbsp;</h3>\n" +
"                        <div class=\"card shadow\">\n" +
"                            <div class=\"card-header py-3\">\n" +
"                                <p class=\"text-primary m-0 fw-bold\" style=\"color: rgb(0,0,0);--bs-primary: #000000;--bs-primary-rgb: 0,0,0;font-family: Aldrich, sans-serif;\">Modificación de las funciones</p>\n" +
"                            </div>\n" +
"                            <div class=\"card-body\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"background: rgb(194,23,0);font-family: Aldrich, sans-serif;width: 150px;height: 38px;\">Añadir película</button>\n" +
"                                <div class=\"table-responsive table mt-2\" id=\"dataTable-1\" role=\"grid\" aria-describedby=\"dataTable_info\">\n" +
"                                    <table class=\"table my-0\" id=\"dataTable\">\n" +
"                                        <thead>\n" +
"                                            <tr>\n" +
"                                                <th>ID</th>\n" +
"                                                <th>Nombre</th>\n" +
"                                                <th>Descripción</th>\n" +
"                                            </tr>\n" +
"                                        </thead>\n" +
"                                        <tbody>\n" +
"                                            <tr>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                            </tr>\n" +
"                                            <tr>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                            </tr>\n" +
"                                            <tr>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                            </tr>\n" +
"                                            <tr>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                            </tr>\n" +
"                                            <tr>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                            </tr>\n" +
"                                            <tr>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                            </tr>\n" +
"                                            <tr>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                            </tr>\n" +
"                                            <tr>\n" +
"                                                <td></td>\n" +
"                                                <td><br></td>\n" +
"                                                <td></td>\n" +
"                                            </tr>\n" +
"                                            <tr>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                            </tr>\n" +
"                                            <tr>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                                <td></td>\n" +
"                                            </tr>\n" +
"                                            <tr></tr>\n" +
"                                        </tbody>\n" +
"                                        <tfoot>\n" +
"                                            <tr></tr>\n" +
"                                        </tfoot>\n" +
"                                    </table>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"            <footer class=\"bg-white sticky-footer\">\n" +
"                <div class=\"container my-auto\">\n" +
"                    <div class=\"text-center my-auto copyright\"><span>Cine Jungla S.A.S</span></div>\n" +
"                </div>\n" +
"            </footer>\n" +
"        </div>\n" +
"    </div>\n" +
"    <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n" +
"    <script src=\"assets/js/theme.js\"></script>\n" +
"</body>\n" +
"\n" +
"</html>");
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
