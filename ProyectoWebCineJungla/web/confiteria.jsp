<%@page import="java.sql.ResultSet"%>
<%String user = (String) session.getAttribute("idCliente");
  String nombre = (String) session.getAttribute("Nombre");
  ResultSet res1 = (ResultSet) session.getAttribute("comida");
  String idCliente = (String) session.getAttribute("idCliente");
  String idFactura = (String) session.getAttribute("idFactura");
  String idPelicula = (String) session.getAttribute("idPelicula");
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
                    <li class="nav-item"><a class="nav-link" action="servlet"><%out.println(nombre);%></a></li>
                    <li class="nav-item"><a class="nav-link" action="servlet">Cerrar sesión</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="page projects-page">
        <section class="portfolio-block projects-cards" style="padding-top: 40px;padding-bottom: 60px;">
            <div class="heading" style="margin-bottom: 28px;">
                <h2 style="font-size: 45px;font-family: Aclonica, sans-serif;margin-bottom: 0px;padding-bottom: 0px;">Confitería</h2>
            </div>
            <div class="container d-inline-flex flex-wrap">
                <%while(res1.next()){%>
                    <form method="post" action="ResumenCompra" class="shadow" style="width: 286px;margin-right: 0px;margin-left: 0px;padding: 6px;"> 
                        <div id="info" style="display:none">
                            <input id="idCliente" name="idCliente" type="text" value="<%out.println(idCliente);%>">
                            <input id="idFactura" name="idFactura" type="text" value="<%out.println(idFactura);%>">
                            <input id="idPelicula" name="idPelicula" type="text" value="<%out.println(idPelicula);%>">
                            <input id="idComida" name="idComida" type="text" value="<%out.println(res1.getString("idComida"));%>">
                        </div>
                        <div style="width: 233px;height: 407px;padding: 15px;margin: 10px;"><img style="width: 200px;height: 240px;" src="<%out.println(res1.getString("UrlImagen"));%>"/>
                            <select name="cantidad" id="cantidad" class="border rounded-pill" style="width: 60px;height: 40px;margin: 19px 0px 0px 168px;margin-top: 5px;margin-right: 0px;margin-left: 0px;padding: 0px 0px;font-size: 20px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(0,0,0);border: 2px solid rgb(180,182,186);color: rgb(255,255,255);">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                            </select>
                            <h1><%out.println(res1.getString("Nombre"));%></h1>
                            <p><%out.println(res1.getString("Precio"));%></p><button class="btn btn-primary border rounded-pill" type="submit" style="font-size: 16px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);border: 2px solid rgb(180,182,186);">Comprar</button>
                        </div>   
                    </form>
                <%}%>
            </div>
        </section>
    </main>
    <footer class="page-footer" style="background: #000000;">
        <div class="container">
            <div class="links"><a href="#" style="color: rgb(255,255,255);">Quienes somos</a><a href="#" style="color: rgb(255,255,255);">Términos y condiciones</a></div>
            <div class="social-icons"><a href="#"><i class="icon ion-social-facebook" style="color: rgb(0,0,0);"></i></a><a href="#"><i class="icon ion-social-instagram" style="color: rgb(0,0,0);"></i></a><a href="#"><i class="icon ion-social-github" style="color: rgb(0,0,0);"></i></a></div>
        </div>
    </footer>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>