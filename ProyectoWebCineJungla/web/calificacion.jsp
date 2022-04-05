<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String user = (String) session.getAttribute("idCliente"); 
    String nombre = (String) session.getAttribute("Nombre");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Cine Jungla</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aclonica&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aldrich&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amarante&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amita&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
</head>

<body><nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient" style="--bs-primary: #000000;--bs-primary-rgb: 0,0,0;--bs-info: #ffffff;--bs-info-rgb: 255,255,255;--bs-danger: #000000;--bs-danger-rgb: 0,0,0;--bs-warning: #ffffff;--bs-warning-rgb: 255,255,255;--bs-success: #000000;--bs-success-rgb: 0,0,0;background: linear-gradient(94deg, black 27%, rgb(223,223,223) 206%, rgb(176,176,176) 251%, white 251%);">
        <div class="container"><a class="navbar-brand logo" style="font-family: Aclonica, sans-serif;font-size: 30px;color: var(--bs-body-bg);"><strong>Cine Jungla</strong></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navbarNav"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" action="servlet"><%out.println(nombre);%></a></li>
                    <li class="nav-item"><a class="nav-link" href="index.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="page cv-page">
        <section class="portfolio-block block-intro border-bottom" style="padding-top: 40px;padding-bottom: 60px;">
            <div class="container">
                <form action="servlet" method="post">
                    <div id="info" style="display:none">
                        <input id="idCliente" name="idCliente" type="text" value="<%out.println(user);%>">
                        <input id="idFuactura" name="idFactura" type="text" value="<%out.println(res1.getString("idFactura"));%>">
                    </div>
                    <h1 style="font-family: Aclonica, sans-serif;font-size: 41px;margin-bottom: 25px;">Califica la película</h1>
                    <div class="about-me">
                        <button class="btn btn-primary" type="button" style="width: 70px;height: 70px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 50px;padding: 0px 0px;padding-top: 0px;background: #c10416;border-style: none;">1</button>
                        <button class="btn btn-primary" type="button" style="width: 70px;height: 70px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 50px;padding: 0px 0px;padding-top: 0px;background: var(--bs-red);border-style: none;">2</button>
                        <button class="btn btn-primary" type="button" style="width: 70px;height: 70px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 50px;padding: 0px 0px;padding-top: 0px;background: var(--bs-orange);border-style: none;">3</button>
                        <button class="btn btn-primary" type="button" style="width: 70px;height: 70px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 50px;padding: 0px 0px;padding-top: 0px;background: var(--bs-teal);border-style: none;">4</button>
                        <button class="btn btn-primary" type="button" style="width: 70px;height: 70px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 50px;padding: 0px 0px;padding-top: 0px;background: var(--bs-green);border-style: none;">5</button>
                    </div>
                    <input type="radio" name="calPelicula" value="1" style="margin-top: 8px;margin-right: 80px;margin-left: 15px;">
                    <input type="radio" name="calPelicula" value="2" style="margin-top: 8px;margin-right: 75px;margin-left: 0px;">
                    <input type="radio" name="calPelicula" value="3" style="margin-top: 8px;margin-right: 80px;margin-left: 0px;">
                    <input type="radio" name="calPelicula" value="4" style="margin-top: 8px;margin-right: 80px;margin-left: 0px;">
                    <input type="radio" name="calPelicula" value="5" style="margin-top: 8px;margin-right: 15px;margin-left: 0px;">
                    <h1 style="font-family: Aclonica, sans-serif;font-size: 41px;margin-top: 52px;margin-bottom: 25px;">Califica nuestro servicio</h1>
                    <div class="about-me">
                        <button class="btn btn-primary" type="button" style="width: 70px;height: 70px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 50px;padding: 0px 0px;padding-top: 0px;background: #c10416;border-style: none;">1</button>
                        <button class="btn btn-primary" type="button" style="width: 70px;height: 70px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 50px;padding: 0px 0px;padding-top: 0px;background: var(--bs-red);border-style: none;">2</button>
                        <button class="btn btn-primary" type="button" style="width: 70px;height: 70px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 50px;padding: 0px 0px;padding-top: 0px;background: var(--bs-orange);border-style: none;">3</button>
                        <button class="btn btn-primary" type="button" style="width: 70px;height: 70px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 50px;padding: 0px 0px;padding-top: 0px;background: var(--bs-teal);border-style: none;">4</button>
                        <button class="btn btn-primary" type="button" style="width: 70px;height: 70px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 50px;padding: 0px 0px;padding-top: 0px;background: var(--bs-green);border-style: none;">5</button>
                    </div>
                    <input type="radio" name="calServicio" value="1" style="margin-top: 8px;margin-right: 80px;margin-left: 15px;">
                    <input type="radio" name="calServicio" value="2" style="margin-top: 8px;margin-right: 75px;margin-left: 0px;">
                    <input type="radio" name="calServicio" value="3" style="margin-top: 8px;margin-right: 80px;margin-left: 0px;">
                    <input type="radio" name="calServicio" value="4" style="margin-top: 8px;margin-right: 80px;margin-left: 0px;">
                    <input type="radio" name="calServicio" value="5" style="margin-top: 8px;margin-right: 15px;margin-left: 0px;">
                    <button class="btn btn-primary" type="submit" style="width: 150px;height: 55px;margin-right: 10px;margin-left: 10px;font-family: Aclonica, sans-serif;font-size: 31px;padding: 0px 0px;padding-top: 0px;background: #000000;border-style: none;margin-top: 60px;">Enviar</button>
                </form>
            </div>
        </section>
    </main>
    <footer class="page-footer" style="background: #000000;">
        <div class="container">
            <div class="links"><a href="#" style="color: rgb(255,255,255);">Quiénes somos</a><a href="#" style="color: rgb(255,255,255);">Términos y condiciones</a></div>
            <div class="social-icons"><a href="#"><i class="icon ion-social-facebook" style="color: rgb(0,0,0);"></i></a><a href="#"><i class="icon ion-social-instagram" style="color: rgb(0,0,0);"></i></a><a href="#"><i class="icon ion-social-github" style="color: rgb(0,0,0);"></i></a></div>
        </div>
    </footer>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js"></script>
    <script src="assets/js/theme.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>