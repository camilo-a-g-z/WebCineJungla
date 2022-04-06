<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   ResultSet res1 = (ResultSet) session.getAttribute("medioPago");
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

<body>
    <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient" style="--bs-primary: #000000;--bs-primary-rgb: 0,0,0;--bs-info: #ffffff;--bs-info-rgb: 255,255,255;--bs-danger: #000000;--bs-danger-rgb: 0,0,0;--bs-warning: #ffffff;--bs-warning-rgb: 255,255,255;--bs-success: #000000;--bs-success-rgb: 0,0,0;background: linear-gradient(94deg, black 27%, rgb(223,223,223) 206%, rgb(176,176,176) 251%, white 251%);">
        <div class="container"><a class="navbar-brand logo" style="font-family: Aclonica, sans-serif;font-size: 30px;color: var(--bs-body-bg);"><strong>Cine Jungla</strong></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navbarNav"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        </div>
    </nav>
    <main class="page hire-me-page">
        <section class="portfolio-block hire-me" style="padding-top: 40px;padding-bottom: 60px;">
            <div class="container">
                <div class="heading">
                    <h2 style="font-family: Aclonica, sans-serif;font-size: 40px;margin-bottom: -40px;">Registro</h2>
                </div>
                <form style="padding-top: 30px;padding-bottom: 30px;" action="AddCliente">
                    <div class="mb-3">
                        <div class="row">
                            <div class="col"><label class="form-label" for="text" style="font-family: Aldrich, sans-serif;font-size: 20px;">Nombre</label><input class="form-control" type="text" id="nombre" name="nombre" style="font-family: Aldrich, sans-serif;height: 45px;"></div>
                        </div>
                    </div>
                    <div class="mb-3"><label class="form-label" for="email" style="font-family: Aldrich, sans-serif;font-size: 20px;">Correo electrónico</label><input class="form-control" type="email" id="correo" name="correo" style="font-family: Aldrich, sans-serif;height: 45px;"></div>
                    <div class="mb-3"><label class="form-label" for="message" style="font-family: Aldrich, sans-serif;font-size: 20px;">Contraseña</label><input class="form-control" type="password" id="pass" name="pass" style="height: 45px;"></div><label class="form-label" for="message" style="font-family: Aldrich, sans-serif;font-size: 20px;">Método de pago</label>
                    <div class="mb-3">
                        <div class="row">
                            <%while(res1.next()){%>
                                <div class="col">
                                    <input type="radio" name="medioPago" value="<%out.println(res1.getString("idMedioPago"));%>" style="margin-top: 8px;margin-right: 5px;margin-left: 15px;"><%out.println(res1.getString("Nombre"));%>
                                </div>
                            <%}%>
                            <div class="col">
                                <button class="btn btn-primary border rounded-pill" type="submit" style="font-size: 25px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);width: 190px;height: 65px;margin-right: 0px;margin-left: 170px;padding: 0px 0px;margin-top: 15px;">Registrarse</button>
                            </div>
                        </div>
                    </div>
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
</body>

</html>