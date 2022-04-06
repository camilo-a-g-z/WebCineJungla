<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String user = (String) session.getAttribute("idEmpleado"); 
  ResultSet res = (ResultSet) session.getAttribute("peliculas");
  String nombre = (String) session.getAttribute("Nombre");
%>
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

<body>
    <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient" style="--bs-primary: #000000;--bs-primary-rgb: 0,0,0;--bs-info: #ffffff;--bs-info-rgb: 255,255,255;--bs-danger: #000000;--bs-danger-rgb: 0,0,0;--bs-warning: #ffffff;--bs-warning-rgb: 255,255,255;--bs-success: #000000;--bs-success-rgb: 0,0,0;background: linear-gradient(94deg, black 27%, rgb(223,223,223) 206%, rgb(176,176,176) 251%, white 251%);">
        <div class="container"><a class="navbar-brand logo"  style="font-family: Aclonica, sans-serif;font-size: 30px;color: var(--bs-body-bg);"><strong>Cine Jungla</strong></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navbarNav"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <form method="post">
                        <div id="info" style="display:none">
                            <input id="idCliente" name="idCliente" type="text" value="<%out.println(user);%>">
                        </div>
                        <li class="nav-item"><button class="nav-link" type="submit" style="background: none;font-size: 16px;border-style: none;"><%out.println(nombre);%></button></li>
                    </form>
                    <li class="nav-item"><a class="nav-link" href="index.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="page projects-page">
        <section class="portfolio-block projects-cards" style="padding-top: 40px;padding-bottom: 60px;">
            <div class="heading">
                <h2 style="font-size: 45px;font-family: Aclonica, sans-serif;margin-bottom: 0px;">Últimos estrenos</h2>
            </div>
            <div class="container d-inline-flex flex-wrap" style="max-width: fit-content">
                <%while(res.next()){%>
                    <form method="post" action="PeliculaMultiplexE" class="shadow" style="width: 368px;margin-right: 0px;margin-left: 0px;padding: 20px;">
                        <div class="card-body" style="padding: 0px;"><img style="width: 280px;height: 450px;padding: 0px;" src="<%out.println(res.getString("UrlPelicula"));%>"/>
                            <h6 style="margin-top: 20px;"><%out.println(res.getString("Nombre"));%></h6>
                            <button class="btn btn-primary border rounded-0" type="submit" style="width: 280px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;">Ver funciones</button></a>
                            <div id="info" style="display:none">
                                <input id="idEmpleado" name="idEmpleado" type="text" value="<%out.println(user);%>">
                                <input id="idPelicula" name="idPelicula" type="text" value="<%out.println(res.getString("idPelicula"));%>">
                            </div>
                        </div>
                    </form>
                <%}%>
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
</body>

</html>