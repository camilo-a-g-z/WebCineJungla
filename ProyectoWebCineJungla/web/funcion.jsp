<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String user = (String) session.getAttribute("idCliente"); 
    ResultSet res1 = (ResultSet) session.getAttribute("pelicula");
    ResultSet res2 = (ResultSet) session.getAttribute("multiplex");
    res1.next();
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
    <script>
        var date = new Date();
        var año = document.getElementById("año");
        año.value = date.getFullYear();
        var mes = document.getElementById("mes");
        mes.value = date.getMonth() +1;
        var dia = document.getElementById("mes");
        dia.value = date.getDate();
    </script>
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
    <main class="d-inline-flex page cv-page">
        <div class="container d-inline" style="padding-left: 0px;padding-right: 0px;width: 440px;"><img style="width: 360px;height: 500px;margin: 25px;" src="<%out.println(res1.getString("UrlPelicula"));%>"></div>
        <div class="d-table-cell group" style="margin-top: 25px;">
            <h1 class="text-break"><%out.println(res1.getString("Nombre"));%></h1>
            <p class="text-break">Clasificacion edad: <%out.println(res1.getString("ClasificacionEdad"));%></p>
            <div></div>
            <p class="text-break">Duracion: <%out.println(res1.getString("Duracion"));%></p>
            <p class="text-break">Director: <%out.println(res1.getString("Director"));%></p>
            <p class="text-break">Sinopsis: <%out.println(res1.getString("Sinopsis"));%></p>
            <form method="post" action="FuncionesEspecificas">
                <div id="info" style="display:none">
                    <input id="idCliente" name="idCliente" type="text" value="<%out.println(user);%>">
                    <input id="idPelicula" name="idPelicula" type="text" value="<%out.println(res1.getString("idPelicula"));%>">
                    <input id="año" name="año" type="text" value="Año">
                    <input id="mes" name="mes" type="text" value="Mes">
                    <input id="dia" name="dia" type="text" value="Dia">
                </div>
                <select name="idMultiplex" class="border rounded-pill" style="width: 220px;height: 40px;margin: 19px 0px 0px 168px;margin-top: 5px;margin-bottom: 20px;margin-right: 0px;margin-left: 0px;padding: 0px 0px;font-size: 20px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);border: 2px solid rgb(180,182,186);color: rgb(255,255,255);">
                    <%while(res2.next()){%>
                        <option value="<%out.println(res2.getString("idMultiplex"));%>"><%out.println(res2.getString("Nombre"));%></option>
                    <%}%>
                  </select>
                  <p>Número de sillas deseadas:</p>
                  <select name="cantidad" class="border rounded-pill" style="width: 220px;height: 40px;margin: 19px 0px 0px 168px;margin-top: 5px;margin-right: 0px;margin-left: 0px;padding: 0px 0px;font-size: 20px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(0,0,0);border: 2px solid rgb(180,182,186);color: rgb(255,255,255);">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                  </select>
                  <button class="btn btn-primary border rounded-pill" type="submit" style="width: 155px;height: 38px;margin-top: 0px;margin-bottom: 5px;margin-left: 37px;padding: 0px 0px;font-size: 16px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);border: 2px solid rgb(180,182,186);">Seguir</button>
            </form>
        </div>
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