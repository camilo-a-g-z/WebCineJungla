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
            <div class="container">
                <div class="heading" style="margin-bottom: 28px;">
                    <h2 style="font-size: 45px;font-family: Aclonica, sans-serif;margin-bottom: 0px;padding-bottom: 0px;">cartelera</h2>
                </div>
                <%while(res.next()){%>
                    <form>
                    <div id="info" style="display:none"><input id="id_usuario" name="id_usuario" type="text" value="<%out.println(user);%>"></div>
                    <div class="row" style="padding-top: 0px;">
                        <div class="col-md-6 col-lg-4" style="border: 2px solid rgb(180,182,186);padding: 18px;height: 790px;width: 415px;margin: 4px;">
                            <div class="card border-0">
                                <div class="card-body" style="padding: 0px;"><img src="<%out.println(res.UrlPelicula);%>" style="width: 300px;height: 470px;padding: 0px;">
                                    <h6 style="margin-top: 20px;"><%out.println(res.Nombre);%></h6>
                                    <p class="text-muted card-text"><%out.println(res.Sinopsis);%></p><a class="card-link" action><button class="btn btn-primary border rounded-pill" type="submit" style="width: 203px;height: 43px;margin-left: 0px;padding: 0px 0px;font-size: 17px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);margin-bottom: 0px;margin-top: 5px;">Comprar boletas</button></a>
                                </div>
                            </div>
                        </div>
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