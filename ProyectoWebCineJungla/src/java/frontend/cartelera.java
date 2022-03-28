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
public class cartelera extends HttpServlet {

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
"    <title>Projects - Brand</title>\n" +
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
"                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"usuario.html\">*usuario*</a></li>\n" +
"                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"index.html\">Cerrar sesión</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </div>\n" +
"    </nav>\n" +
"    <main class=\"page projects-page\">\n" +
"        <section class=\"portfolio-block projects-cards\" style=\"padding-top: 40px;padding-bottom: 60px;\">\n" +
"            <div class=\"container\">\n" +
"                <div class=\"heading\" style=\"margin-bottom: 28px;\">\n" +
"                    <h2 style=\"font-size: 45px;font-family: Aclonica, sans-serif;margin-bottom: 0px;padding-bottom: 0px;\">cartelera</h2>\n" +
"                    <div class=\"dropdown\"><button class=\"btn btn-primary dropdown-toggle border rounded-pill\" aria-expanded=\"false\" data-bs-toggle=\"dropdown\" type=\"button\" style=\"width: 235px;height: 45px;margin: 19px 0px 0px 168px;margin-top: 20px;margin-right: 0px;margin-left: 0px;padding: 0px 0px;font-size: 20px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);border: 2px solid rgb(180,182,186);\">Centro Comercial</button>\n" +
"                        <div class=\"dropdown-menu\"><a class=\"dropdown-item\" href=\"#\">Titán Plaza</a><a class=\"dropdown-item\" href=\"#\">Plaza Central</a><a class=\"dropdown-item\" href=\"#\">Unicentro</a><a class=\"dropdown-item\" href=\"#\">Gran Estación</a><a class=\"dropdown-item\" href=\"#\">Embajador</a><a class=\"dropdown-item\" href=\"#\">Plaza de las Ámericas</a></div>\n" +
"                    </div>\n" +
"                </div>\n" +
"                <div class=\"row\" style=\"padding-top: 0px;\">\n" +
"                    <div class=\"col-md-6 col-lg-4\" style=\"border: 2px solid rgb(180,182,186);padding: 18px;height: 790px;width: 415px;margin: 4px;\">\n" +
"                        <div class=\"card border-0\">\n" +
"                            <div class=\"card-body\" style=\"padding: 0px;\"><img style=\"width: 300px;height: 470px;padding: 0px;\">\n" +
"                                <h6 style=\"margin-top: 20px;\">fdgdfgdf</h6>\n" +
"                                <p class=\"text-muted card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna.fdsfsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff</p><a class=\"card-link\" href=\"funcion.html\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"width: 203px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;\">Comprar boletas</button></a>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"col-md-6 col-lg-4\" style=\"border: 2px solid rgb(180,182,186);padding: 18px;height: 790px;width: 415px;margin: 4px;\">\n" +
"                        <div class=\"card border-0\">\n" +
"                            <div class=\"card-body\" style=\"padding: 0px;\"><img style=\"width: 300px;height: 470px;padding: 0px;\">\n" +
"                                <h6 style=\"margin-top: 20px;\">fdgdfgdf</h6>\n" +
"                                <p class=\"text-muted card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna.fdsfsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff</p><a class=\"card-link\" href=\"funcion.html\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"width: 203px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;\">Comprar boletas</button></a>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"col-md-6 col-lg-4\" style=\"border: 2px solid rgb(180,182,186);padding: 18px;height: 790px;width: 415px;margin: 4px;\">\n" +
"                        <div class=\"card border-0\">\n" +
"                            <div class=\"card-body\" style=\"padding: 0px;\"><img style=\"width: 300px;height: 470px;padding: 0px;\">\n" +
"                                <h6 style=\"margin-top: 20px;\">fdgdfgdf</h6>\n" +
"                                <p class=\"text-muted card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna.fdsfsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff</p><a class=\"card-link\" href=\"funcion.html\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"width: 203px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;\">Comprar boletas</button></a>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"col-md-6 col-lg-4\" style=\"border: 2px solid rgb(180,182,186);padding: 18px;height: 790px;width: 415px;margin: 4px;\">\n" +
"                        <div class=\"card border-0\">\n" +
"                            <div class=\"card-body\" style=\"padding: 0px;\"><img style=\"width: 300px;height: 470px;padding: 0px;\">\n" +
"                                <h6 style=\"margin-top: 20px;\">fdgdfgdf</h6>\n" +
"                                <p class=\"text-muted card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna.fdsfsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff</p><a class=\"card-link\" href=\"funcion.html\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"width: 203px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;\">Comprar boletas</button></a>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"col-md-6 col-lg-4\" style=\"border: 2px solid rgb(180,182,186);padding: 18px;height: 790px;width: 415px;margin: 4px;\">\n" +
"                        <div class=\"card border-0\">\n" +
"                            <div class=\"card-body\" style=\"padding: 0px;\"><img style=\"width: 300px;height: 470px;padding: 0px;\">\n" +
"                                <h6 style=\"margin-top: 20px;\">fdgdfgdf</h6>\n" +
"                                <p class=\"text-muted card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna.fdsfsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff</p><a class=\"card-link\" href=\"funcion.html\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"width: 203px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;\">Comprar boletas</button></a>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"col-md-6 col-lg-4\" style=\"border: 2px solid rgb(180,182,186);padding: 18px;height: 790px;width: 415px;margin: 4px;\">\n" +
"                        <div class=\"card border-0\">\n" +
"                            <div class=\"card-body\" style=\"padding: 0px;\"><img style=\"width: 300px;height: 470px;padding: 0px;\">\n" +
"                                <h6 style=\"margin-top: 20px;\">fdgdfgdf</h6>\n" +
"                                <p class=\"text-muted card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna.fdsfsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff</p><a class=\"card-link\" href=\"funcion.html\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"width: 203px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;\">Comprar boletas</button></a>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"col-md-6 col-lg-4\" style=\"border: 2px solid rgb(180,182,186);padding: 18px;height: 790px;width: 415px;margin: 4px;\">\n" +
"                        <div class=\"card border-0\">\n" +
"                            <div class=\"card-body\" style=\"padding: 0px;\"><img style=\"width: 300px;height: 470px;padding: 0px;\">\n" +
"                                <h6 style=\"margin-top: 20px;\">fdgdfgdf</h6>\n" +
"                                <p class=\"text-muted card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna.fdsfsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff</p><a class=\"card-link\" href=\"funcion.html\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"width: 203px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;\">Comprar boletas</button></a>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"col-md-6 col-lg-4\" style=\"border: 2px solid rgb(180,182,186);padding: 18px;height: 790px;width: 415px;margin: 4px;\">\n" +
"                        <div class=\"card border-0\">\n" +
"                            <div class=\"card-body\" style=\"padding: 0px;\"><img style=\"width: 300px;height: 470px;padding: 0px;\">\n" +
"                                <h6 style=\"margin-top: 20px;\">fdgdfgdf</h6>\n" +
"                                <p class=\"text-muted card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna.fdsfsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff</p><a class=\"card-link\" href=\"funcion.html\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"width: 203px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;\">Comprar boletas</button></a>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"col-md-6 col-lg-4\" style=\"border: 2px solid rgb(180,182,186);padding: 18px;height: 790px;width: 415px;margin: 4px;\">\n" +
"                        <div class=\"card border-0\">\n" +
"                            <div class=\"card-body\" style=\"padding: 0px;\"><img style=\"width: 300px;height: 470px;padding: 0px;\">\n" +
"                                <h6 style=\"margin-top: 20px;\">fdgdfgdf</h6>\n" +
"                                <p class=\"text-muted card-text\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna.fdsfsdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff</p><a class=\"card-link\" href=\"funcion.html\"><button class=\"btn btn-primary border rounded-pill\" type=\"button\" style=\"width: 203px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;\">Comprar boletas</button></a>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
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
