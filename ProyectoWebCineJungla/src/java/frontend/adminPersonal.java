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
public class adminPersonal extends HttpServlet {

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
"    <title>Profile - Brand</title>\n" +
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
"                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"adminPeliculas.html\"><i class=\"fa fa-video-camera\"></i><span style=\"margin-left: 8px;\">Películas</span></a><a class=\"nav-link\" href=\"adminConfitería.html\"><i class=\"fa fa-cutlery\"></i><span style=\"margin-left: 8px;\">Confitería</span></a><a class=\"nav-link active\" href=\"adminPersonal.html\"><i class=\"fa fa-user-plus\"></i><span style=\"margin-left: 8px;\">Personal</span></a></li>\n" +
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
"                <div id=\"content-2\">\n" +
"                    <div id=\"content-1\"></div>\n" +
"                </div>\n" +
"                <div id=\"content-3\">\n" +
"                    <div id=\"content-4\">\n" +
"                        <div class=\"container-fluid\">\n" +
"                            <h3 class=\"text-dark mb-4\" style=\"margin-top: 22px;font-family: Aclonica, sans-serif;font-size: 28px;\">Registro de empleados</h3>\n" +
"                            <div class=\"card shadow\">\n" +
"                                <div class=\"card-header py-3\">\n" +
"                                    <p class=\"text-primary m-0 fw-bold\" style=\"color: rgb(0,0,0);--bs-primary: #000000;--bs-primary-rgb: 0,0,0;font-family: Aldrich, sans-serif;\">Agregar empleado nuevo</p>\n" +
"                                </div>\n" +
"                                <div class=\"card-body\">\n" +
"                                    <div class=\"p-5\" style=\"height: 400px;width: 888px;\">\n" +
"                                        <div class=\"text-center\">\n" +
"                                            <h4 class=\"text-dark mb-4\" style=\"font-family: Aldrich, sans-serif;font-size: 25px;\">Datos del empleado</h4>\n" +
"                                        </div>\n" +
"                                        <form class=\"d-inline user\">\n" +
"                                            <div class=\"row mb-3\">\n" +
"                                                <div class=\"col-sm-6 mb-3 mb-sm-0\"><input class=\"form-control form-control-user\" type=\"text\" id=\"exampleFirstName-1\" placeholder=\"Nombre\" name=\"first_name\"></div>\n" +
"                                                <div class=\"col-sm-6\"><input class=\"form-control form-control-user\" type=\"text\" id=\"exampleFirstName-2\" placeholder=\"Apellido\" name=\"last_name\"></div>\n" +
"                                            </div>\n" +
"                                            <div class=\"row mb-3\">\n" +
"                                                <div class=\"col-sm-6 mb-3 mb-sm-0\"><input class=\"form-control form-control-user\" type=\"password\" id=\"examplePasswordInput-1\" placeholder=\"Cédula\" name=\"password\"></div>\n" +
"                                                <div class=\"col-sm-6\"><input class=\"form-control form-control-user\" type=\"password\" id=\"exampleRepeatPasswordInput-1\" placeholder=\"Teléfono\" name=\"password_repeat\"></div>\n" +
"                                            </div>\n" +
"                                            <div class=\"row mb-3\">\n" +
"                                                <div class=\"col-sm-6 mb-3 mb-sm-0\"><input class=\"form-control form-control-user\" type=\"password\" id=\"examplePasswordInput\" placeholder=\"Correo electrónico\" name=\"password\"></div>\n" +
"                                                <div class=\"col-sm-6\"><input class=\"form-control form-control-user\" type=\"password\" id=\"exampleRepeatPasswordInput\" placeholder=\"Contraseña\" name=\"password_repeat\"></div>\n" +
"                                            </div><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"background: rgb(194,23,0);font-family: Aldrich, sans-serif;width: 180px;height: 38px;\">Añadir empleado</button>\n" +
"                                            <hr>\n" +
"                                        </form>\n" +
"                                        <div class=\"text-center\"></div>\n" +
"                                        <div class=\"text-center\"></div>\n" +
"                                    </div>\n" +
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
