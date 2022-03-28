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
public class registro extends HttpServlet {

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
"    <title>Hire me - Brand</title>\n" +
"    <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700\">\n" +
"    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Aclonica&amp;display=swap\">\n" +
"    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Aldrich&amp;display=swap\">\n" +
"    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Amarante&amp;display=swap\">\n" +
"    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Amita&amp;display=swap\">\n" +
"    <link rel=\"stylesheet\" href=\"assets/fonts/fontawesome-all.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"assets/fonts/ionicons.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css\">\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"    <nav class=\"navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient\" style=\"--bs-primary: #000000;--bs-primary-rgb: 0,0,0;--bs-info: #ffffff;--bs-info-rgb: 255,255,255;--bs-danger: #000000;--bs-danger-rgb: 0,0,0;--bs-warning: #ffffff;--bs-warning-rgb: 255,255,255;--bs-success: #000000;--bs-success-rgb: 0,0,0;background: linear-gradient(94deg, black 27%, rgb(223,223,223) 206%, rgb(176,176,176) 251%, white 251%);\">\n" +
"        <div class=\"container\"><a class=\"navbar-brand logo\" href=\"index.html\" style=\"font-family: Aclonica, sans-serif;font-size: 30px;color: var(--bs-body-bg);\"><strong>Cine Jungla</strong></a><button data-bs-toggle=\"collapse\" class=\"navbar-toggler\" data-bs-target=\"#navbarNav\"><span class=\"visually-hidden\">Toggle navigation</span><span class=\"navbar-toggler-icon\"></span></button>\n" +
"            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n" +
"                <ul class=\"navbar-nav ms-auto\">\n" +
"                    <li class=\"nav-item\"></li>\n" +
"                    <li class=\"nav-item\"></li>\n" +
"                    <li class=\"nav-item\"></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </div>\n" +
"    </nav>\n" +
"    <main class=\"page hire-me-page\">\n" +
"        <section class=\"portfolio-block hire-me\" style=\"padding-top: 40px;padding-bottom: 60px;\">\n" +
"            <div class=\"container\">\n" +
"                <div class=\"heading\">\n" +
"                    <h2 style=\"font-family: Aclonica, sans-serif;font-size: 40px;margin-bottom: -40px;\">Registro</h2>\n" +
"                </div>\n" +
"                <form style=\"width: 650px;height: 670px;padding: 38px;\">\n" +
"                    <div class=\"mb-3\">\n" +
"                        <div class=\"row\">\n" +
"                            <div class=\"col\"><label class=\"form-label\" for=\"email\" style=\"font-family: Aldrich, sans-serif;font-size: 20px;\">Nombre</label><input class=\"form-control\" type=\"email\" id=\"email-2\" style=\"font-family: Aldrich, sans-serif;height: 45px;\"></div>\n" +
"                            <div class=\"col\">\n" +
"                                <div class=\"mb-3\"><label class=\"form-label\" for=\"email\" style=\"font-family: Aldrich, sans-serif;font-size: 20px;\">Apellido</label><input class=\"form-control\" type=\"email\" id=\"email-3\" style=\"font-family: Aldrich, sans-serif;height: 45px;\"></div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"mb-3\"></div>\n" +
"                    <div class=\"mb-3\"><label class=\"form-label\" for=\"email\" style=\"font-family: Aldrich, sans-serif;font-size: 20px;\">Nombre de usuario</label><input class=\"form-control\" type=\"email\" id=\"email\" style=\"font-family: Aldrich, sans-serif;height: 45px;\"></div>\n" +
"                    <div class=\"mb-3\"><label class=\"form-label\" for=\"email\" style=\"font-family: Aldrich, sans-serif;font-size: 20px;\">Correo electrónico</label><input class=\"form-control\" type=\"email\" id=\"email\" style=\"font-family: Aldrich, sans-serif;height: 45px;\"></div>\n" +
"                    <div class=\"mb-3\"><label class=\"form-label\" for=\"message\" style=\"font-family: Aldrich, sans-serif;font-size: 20px;\">Contraseña</label><input class=\"form-control\" type=\"password\" style=\"height: 45px;\"></div><label class=\"form-label\" for=\"message\" style=\"font-family: Aldrich, sans-serif;font-size: 20px;\">Método de pago</label>\n" +
"                    <div class=\"mb-3\">\n" +
"                        <div class=\"row\">\n" +
"                            <div class=\"col\"><a href=\"index1.html\"></a><button class=\"btn btn-primary border rounded-0\" type=\"button\" style=\"font-size: 20px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(109,102,101);width: 162px;height: 42px;margin-right: 0px;margin-left: 77px;padding: 0px 0px;margin-top: 20px;\">Efectivo</button><button class=\"btn btn-primary border rounded-0\" type=\"button\" style=\"font-size: 20px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(109,102,101);width: 162px;height: 42px;margin-right: 0px;margin-left: 65px;padding: 0px 0px;margin-top: 20px;\">Tarjeta</button></div>\n" +
"                            <div class=\"col\"><a href=\"index1.html\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"font-size: 25px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);width: 190px;height: 65px;margin-right: 0px;margin-left: 170px;padding: 0px 0px;margin-top: 27px;\">Registrarse</button></a></div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </form>\n" +
"            </div>\n" +
"        </section>\n" +
"    </main>\n" +
"    <footer class=\"page-footer\" style=\"background: #000000;\">\n" +
"        <div class=\"container\">\n" +
"            <div class=\"links\"><a href=\"#\" style=\"color: rgb(255,255,255);\">Quienes somos</a><a href=\"#\" style=\"color: rgb(255,255,255);\">Términos y condiciones</a></div>\n" +
"            <div class=\"social-icons\"><a href=\"#\"><i class=\"icon ion-social-facebook\" style=\"color: rgb(0,0,0);\"></i></a><a href=\"#\"><i class=\"icon ion-social-instagram\" style=\"color: rgb(0,0,0);\"></i></a><a href=\"#\"><i class=\"icon ion-social-github\" style=\"color: rgb(0,0,0);\"></i></a></div>\n" +
"        </div>\n" +
"    </footer>\n" +
"    <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n" +
"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js\"></script>\n" +
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
