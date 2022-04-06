package servlets;

import datos.DBCliente;
import datos.DBPelicula;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Automatizacion.GenerateAllMultiplex;
import logica.Automatizacion.rellenoSalas;

/**
 * Esta clase ejecuta en el servidor lo referente a los Datos para el acceso de 
 * usuarios a cuentas.
 *
 * @author Camilo A. Garcia - Miguel A. Naranjo - Laura A. Riobueno - Cristian
 * C. Tuso
 * @version 1.0
 * @since 06/04/2022
 */
public class LoginUser extends HttpServlet {

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
        DBCliente DBc = new DBCliente();
        DBPelicula DBp = new DBPelicula();
        ResultSet resP;
        rellenoSalas re = new rellenoSalas(54,1,2022,4,5,7,0);
        System.out.println("PAso");
        try {
            //GenerateAllMultiplex generate = new GenerateAllMultiplex("Portal","Por ahi", 1);
            //se llama y guardan los datos recividos segun el parametro recivido
            ResultSet res = DBc.getClienteLogin(request.getParameter("correo"));
            out.println("<html>");
            out.println("<body>");
            
            //se consulta si la respuesta esta vacia
            if (!res.next()) {
                out.println("<meta http-equiv='refresh' content='3;URL=Cliente.jsp'>");//redirects after 3 seconds
                out.println("<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "\n" +
                            "<head>\n" +
                            "    <meta charset=\"utf-8\">\n" +
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\n" +
                            "    <title>Cine Jungla</title>\n" +
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
                            "        <div class=\"container\"><a class=\"navbar-brand logo\" style=\"font-family: Aclonica, sans-serif;font-size: 30px;color: var(--bs-body-bg);\"><strong>Cine Jungla</strong></a><button data-bs-toggle=\"collapse\" class=\"navbar-toggler\" data-bs-target=\"#navbarNav\"><span class=\"visually-hidden\">Toggle navigation</span><span class=\"navbar-toggler-icon\"></span></button>\n" +
                            "        </div>\n" +
                            "    </nav>\n" +
                            "    <main class=\"page cv-page\">\n" +
                            "        <section class=\"portfolio-block block-intro border-bottom\" style=\"padding-top: 40px;padding-bottom: 60px;\">\n" +
                            "            <div class=\"container\">\n" +
                            "                <h1 style=\"font-family: Aclonica, sans-serif;font-size: 45px;\">Contraseña o usuario incorrectos</h1><img style=\"width: 190px;height: 190px;margin-bottom: 70px;margin-top: 5px;\" src=\"usuario.png\">\n" +
                            "            </div>\n" +
                            "        </section>\n" +
                            "    </main>\n" +
                            "    <footer class=\"page-footer\" style=\"background: #000000;\">\n" +
                            "        <div class=\"container\">\n" +
                            "            <div class=\"links\"><a href=\"#\" style=\"color: rgb(255,255,255);\">Quiénes somos</a><a href=\"#\" style=\"color: rgb(255,255,255);\">Términos y condiciones</a></div>\n" +
                            "            <div class=\"social-icons\"><a href=\"#\"><i class=\"icon ion-social-facebook\" style=\"color: rgb(0,0,0);\"></i></a><a href=\"#\"><i class=\"icon ion-social-instagram\" style=\"color: rgb(0,0,0);\"></i></a><a href=\"#\"><i class=\"icon ion-social-github\" style=\"color: rgb(0,0,0);\"></i></a></div>\n" +
                            "        </div>\n" +
                            "    </footer>\n" +
                            "    <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n" +
                            "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js\"></script>\n" +
                            "    <script src=\"assets/js/theme.js\"></script>\n" +
                            "</body>\n" +
                            "\n" +
                            "</html>");
            } else {
                if (res.getString("HashPsw") == null ? request.getParameter("contraseña") == null : res.getString("HashPsw").equals(request.getParameter("contraseña"))) {
                    
                    resP = DBp.getPeliculaByEstado("Cartelera");
                    request.getSession().setAttribute("idCliente", res.getString("idCliente"));
                    request.getSession().setAttribute("Nombre", res.getString("Nombre"));
                    request.getSession().setAttribute("peliculas", resP);
                    out.println("<meta http-equiv='refresh' content='3;URL=inicio.jsp'>");//redirects after 3 seconds
                    out.println("<!DOCTYPE html>\n" +
                                "<html>\n" +
                                "\n" +
                                "<head>\n" +
                                "    <meta charset=\"utf-8\">\n" +
                                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\n" +
                                "    <title>Cine Jungla</title>\n" +
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
                                "        <div class=\"container\"><a class=\"navbar-brand logo\" style=\"font-family: Aclonica, sans-serif;font-size: 30px;color: var(--bs-body-bg);\"><strong>Cine Jungla</strong></a><button data-bs-toggle=\"collapse\" class=\"navbar-toggler\" data-bs-target=\"#navbarNav\"><span class=\"visually-hidden\">Toggle navigation</span><span class=\"navbar-toggler-icon\"></span></button>\n" +
                                "        </div>\n" +
                                "    </nav>\n" +
                                "    <main class=\"page cv-page\">\n" +
                                "        <section class=\"portfolio-block block-intro border-bottom\" style=\"padding-top: 40px;padding-bottom: 60px;\">\n" +
                                "            <div class=\"container\">\n" +
                                "                <h1 style=\"font-family: Aclonica, sans-serif;font-size: 45px;\">Bienvenido " + res.getString("Nombre") + "</h1><img style=\"width: 190px;height: 190px;margin-bottom: 70px;margin-top: 5px;\" src=\"usuario.png\">\n" +
                                "            </div>\n" +
                                "        </section>\n" +
                                "    </main>\n" +
                                "    <footer class=\"page-footer\" style=\"background: #000000;\">\n" +
                                "        <div class=\"container\">\n" +
                                "            <div class=\"links\"><a href=\"#\" style=\"color: rgb(255,255,255);\">Quiénes somos</a><a href=\"#\" style=\"color: rgb(255,255,255);\">Términos y condiciones</a></div>\n" +
                                "            <div class=\"social-icons\"><a href=\"#\"><i class=\"icon ion-social-facebook\" style=\"color: rgb(0,0,0);\"></i></a><a href=\"#\"><i class=\"icon ion-social-instagram\" style=\"color: rgb(0,0,0);\"></i></a><a href=\"#\"><i class=\"icon ion-social-github\" style=\"color: rgb(0,0,0);\"></i></a></div>\n" +
                                "        </div>\n" +
                                "    </footer>\n" +
                                "    <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n" +
                                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js\"></script>\n" +
                                "    <script src=\"assets/js/theme.js\"></script>\n" +
                                "</body>\n" +
                                "\n" +
                                "</html>");
                } else {
                    out.println("<meta http-equiv='refresh' content='3;URL=ingresoC.jsp'>");//redirects after 3 seconds
                    out.println("<!DOCTYPE html>\n" +
                                "<html>\n" +
                                "\n" +
                                "<head>\n" +
                                "    <meta charset=\"utf-8\">\n" +
                                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\n" +
                                "    <title>Cine Jungla</title>\n" +
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
                                "        <div class=\"container\"><a class=\"navbar-brand logo\" style=\"font-family: Aclonica, sans-serif;font-size: 30px;color: var(--bs-body-bg);\"><strong>Cine Jungla</strong></a><button data-bs-toggle=\"collapse\" class=\"navbar-toggler\" data-bs-target=\"#navbarNav\"><span class=\"visually-hidden\">Toggle navigation</span><span class=\"navbar-toggler-icon\"></span></button>\n" +
                                "        </div>\n" +
                                "    </nav>\n" +
                                "    <main class=\"page cv-page\">\n" +
                                "        <section class=\"portfolio-block block-intro border-bottom\" style=\"padding-top: 40px;padding-bottom: 60px;\">\n" +
                                "            <div class=\"container\">\n" +
                                "                <h1 style=\"font-family: Aclonica, sans-serif;font-size: 45px;\">Contraseña o usuario incorrectos</h1><img style=\"width: 190px;height: 190px;margin-bottom: 70px;margin-top: 5px;\" src=\"usuario.png\">\n" +
                                "            </div>\n" +
                                "        </section>\n" +
                                "    </main>\n" +
                                "    <footer class=\"page-footer\" style=\"background: #000000;\">\n" +
                                "        <div class=\"container\">\n" +
                                "            <div class=\"links\"><a href=\"#\" style=\"color: rgb(255,255,255);\">Quiénes somos</a><a href=\"#\" style=\"color: rgb(255,255,255);\">Términos y condiciones</a></div>\n" +
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
            out.println("</body>");
            out.println("</html>");
        }catch (Exception e){
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>error at " + e.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
