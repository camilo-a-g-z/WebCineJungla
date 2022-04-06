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

<body>
    <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient" style="--bs-primary: #000000;--bs-primary-rgb: 0,0,0;--bs-info: #ffffff;--bs-info-rgb: 255,255,255;--bs-danger: #000000;--bs-danger-rgb: 0,0,0;--bs-warning: #ffffff;--bs-warning-rgb: 255,255,255;--bs-success: #000000;--bs-success-rgb: 0,0,0;background: linear-gradient(94deg, black 27%, rgb(223,223,223) 206%, rgb(176,176,176) 251%, white 251%);">
        <div class="container"><a class="navbar-brand logo" style="font-family: Aclonica, sans-serif;font-size: 30px;color: var(--bs-body-bg);"><strong>Cine Jungla</strong></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navbarNav"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <form action="ShowUserInfo" method="post">
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
    <main class="page hire-me-page">
        <section class="portfolio-block hire-me" style="padding-top: 40px;padding-bottom: 60px;">
            <div class="container">
                <div class="heading">
                    <h2 style="font-family: Aclonica, sans-serif;font-size: 40px;margin-bottom: -40px;">Pago</h2>
                </div>
                <form style="padding-top: 30px;padding-bottom: 30px;">
                    <div id="info" style="display:none"><input id="id_usuario" name="id_usuario" type="text" value="<%out.println(user);%>"></div>
                    <div class="mb-3"></div>
                    <div class="mb-3">
                        <label class="form-label" for="email" style="font-family: Aldrich, sans-serif;font-size: 24px;">FACTURA</label>
                        <p style="font-size: 22px;font-family: Lato, sans-serif;">AQUI VA LA FACTURA</p>
                        <label class="form-label" for="email" style="font-family: Aldrich, sans-serif;font-size: 24px;">Lista de productos</label>
                        <p style="font-size: 22px;">AQUI VA LA LISTA DE PRODUCTOS</p>
                        <label class="form-label" for="email" style="font-family: Aldrich, sans-serif;font-size: 24px;">Lista de comestibles</label>
                        <p style="font-size: 22px;">AQUI VA LA LISTA DE COMIDA</p>
                        <label class="form-label" for="email" style="font-family: Aldrich, sans-serif;font-size: 24px;">Valor total</label>
                        <p style="font-size: 22px;">AQUI VA EL VALOR TOTAL</p>
                        <label class="form-label" for="email" style="font-family: Aldrich, sans-serif;font-size: 24px;">Total de puntos adquiridos</label>
                        <p style="font-size: 22px;">AQUI VAN LOS PUNTOS</p>
                    </div>
                    <div class="col"><button class="btn btn-primary border rounded-pill" type="submit" style="font-size: 25px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);width: 260px;height: 65px;margin-right: 0px;margin-left: 148px;padding: 0px 0px;margin-top: 20px;">Imprimir factura</button></div>
                    <div class="col"><button class="btn btn-primary border rounded-0" type="submit" style="font-size: 20px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(109,102,101);width: 202px;height: 43px;margin: 19px 0px 0px 168px;margin-right: 0px;margin-left: 180px;padding: 0px 0px;margin-top: 20px;">Cancelar compra</button></div>
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