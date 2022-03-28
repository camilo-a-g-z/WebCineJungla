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
public class usuario extends HttpServlet {

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
"    <title>CV - Brand</title>\n" +
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
"        <div class=\"container\"><a class=\"navbar-brand logo\" href=\"inicio.html\" style=\"font-family: Aclonica, sans-serif;font-size: 30px;color: var(--bs-body-bg);\"><strong>Cine Jungla</strong></a><button data-bs-toggle=\"collapse\" class=\"navbar-toggler\" data-bs-target=\"#navbarNav\"><span class=\"visually-hidden\">Toggle navigation</span><span class=\"navbar-toggler-icon\"></span></button>\n" +
"            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n" +
"                <ul class=\"navbar-nav ms-auto\">\n" +
"                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"confiteria.html\">Confitería</a></li>\n" +
"                    <li class=\"nav-item\"><a class=\"nav-link active\" href=\"usuario.html\">*usuario*</a></li>\n" +
"                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"index.html\">Cerrar sesión</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </div>\n" +
"    </nav>\n" +
"    <main class=\"page cv-page\">\n" +
"        <div id=\"content\" style=\"padding: 50px;\">\n" +
"            <div class=\"container-fluid\">\n" +
"                <h3 class=\"text-dark mb-4\" style=\"font-family: Aclonica, sans-serif;font-size: 30px;\">Perfil de usuario</h3>\n" +
"                <div class=\"row mb-3\">\n" +
"                    <div class=\"col-lg-4\">\n" +
"                        <div class=\"card shadow mb-4\">\n" +
"                            <div class=\"card-body\"><img style=\"width: 350px;height: 350px;\" src=\"assets/img/nature/usuario.png\"></div>\n" +
"                        </div>\n" +
"                        <div class=\"card shadow mb-4\">\n" +
"                            <div class=\"card-body\" style=\"width: 400px;height: 115px;\">\n" +
"                                <h4 class=\"small fw-bold\">Puntos obtenidos<span class=\"float-end\"></span></h4>\n" +
"                                <h1>1451541</h1>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"col-lg-8\">\n" +
"                        <div class=\"row mb-3 d-none\">\n" +
"                            <div class=\"col\">\n" +
"                                <div class=\"card textwhite bg-primary text-white shadow\">\n" +
"                                    <div class=\"card-body\">\n" +
"                                        <div class=\"row mb-2\">\n" +
"                                            <div class=\"col\">\n" +
"                                                <p class=\"m-0\">Peformance</p>\n" +
"                                                <p class=\"m-0\"><strong>65.2%</strong></p>\n" +
"                                            </div>\n" +
"                                            <div class=\"col-auto\"><i class=\"fas fa-rocket fa-2x\"></i></div>\n" +
"                                        </div>\n" +
"                                        <p class=\"text-white-50 small m-0\"><i class=\"fas fa-arrow-up\"></i>&nbsp;5% since last month</p>\n" +
"                                    </div>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                            <div class=\"col\">\n" +
"                                <div class=\"card textwhite bg-success text-white shadow\">\n" +
"                                    <div class=\"card-body\">\n" +
"                                        <div class=\"row mb-2\">\n" +
"                                            <div class=\"col\">\n" +
"                                                <p class=\"m-0\">Peformance</p>\n" +
"                                                <p class=\"m-0\"><strong>65.2%</strong></p>\n" +
"                                            </div>\n" +
"                                            <div class=\"col-auto\"><i class=\"fas fa-rocket fa-2x\"></i></div>\n" +
"                                        </div>\n" +
"                                        <p class=\"text-white-50 small m-0\"><i class=\"fas fa-arrow-up\"></i>&nbsp;5% since last month</p>\n" +
"                                    </div>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                        <div class=\"row\">\n" +
"                            <div class=\"col\">\n" +
"                                <div class=\"card shadow mb-3\">\n" +
"                                    <div class=\"card-header py-3\">\n" +
"                                        <p class=\"m-0 fw-bold\" style=\"font-family: Aldrich, sans-serif;font-size: 25px;\">Datos del usuario</p>\n" +
"                                    </div>\n" +
"                                    <div class=\"card-body\">\n" +
"                                        <form>\n" +
"                                            <div class=\"row\">\n" +
"                                                <div class=\"col\" style=\"height: 100px;\">\n" +
"                                                    <div class=\"mb-3\"><label class=\"form-label\" for=\"username\" style=\"font-family: Aldrich, sans-serif;font-size: 18px;\"><strong>Nombre de usuario</strong></label><input class=\"form-control\" type=\"text\" id=\"username\" placeholder=\"user.name\" name=\"username\"></div>\n" +
"                                                </div>\n" +
"                                                <div class=\"col\">\n" +
"                                                    <div class=\"mb-3\"><label class=\"form-label\" for=\"email\" style=\"font-family: Aldrich, sans-serif;font-size: 18px;\"><strong>Correo eléctronico</strong></label><input class=\"form-control\" type=\"email\" id=\"email\" placeholder=\"user@example.com\" name=\"email\"></div>\n" +
"                                                </div>\n" +
"                                            </div>\n" +
"                                            <div class=\"row\">\n" +
"                                                <div class=\"col\" style=\"height: 100px;\">\n" +
"                                                    <div class=\"mb-3\"><label class=\"form-label\" for=\"first_name\" style=\"font-family: Aldrich, sans-serif;font-size: 18px;\"><strong>Nombre</strong><br></label><input class=\"form-control\" type=\"text\" id=\"first_name\" placeholder=\"name\" name=\"first_name\"></div>\n" +
"                                                </div>\n" +
"                                                <div class=\"col\">\n" +
"                                                    <div class=\"mb-3\"><label class=\"form-label\" for=\"last_name\" style=\"font-family: Aldrich, sans-serif;font-size: 18px;\"><strong>Apellido</strong></label><input class=\"form-control\" type=\"text\" id=\"last_name\" placeholder=\"lastname\" name=\"last_name\"></div>\n" +
"                                                </div>\n" +
"                                            </div>\n" +
"                                            <div class=\"mb-3\"><button class=\"btn btn-primary btn-sm\" type=\"submit\" style=\"background: rgb(194,23,0);font-family: Aldrich, sans-serif;font-size: 20px;width: 225px;height: 42px;\">Guardar cambios</button></div>\n" +
"                                        </form>\n" +
"                                    </div>\n" +
"                                </div>\n" +
"                                <div class=\"card shadow\"></div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"                <div class=\"card shadow mb-5\"></div>\n" +
"            </div>\n" +
"        </div>\n" +
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
