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
    <title>CV - Brand</title>
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
                    <li class="nav-item"><a class="nav-link active" action="servlet"><%out.println(nombre);%></a></li>
                    <li class="nav-item"><a class="nav-link" action="servlet">Cerrar sesión</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="page cv-page">
        <div id="content" style="padding: 50px;">
            <div class="container-fluid">
                <h3 class="text-dark mb-4" style="font-family: Aclonica, sans-serif;font-size: 30px;">Perfil de usuario</h3>
                <div class="row mb-3">
                    <div class="col-lg-4">
                        <div class="card shadow mb-4">
                            <div class="card-body" style="background: url('usuario.png') center / contain no-repeat;height: 408px;"></div>
                        </div>
                        <div class="card shadow mb-4">
                            <div class="card-body">
                                <h4 class="small fw-bold">Puntos obtenidos</h4>
                                <h1>1451541</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="row">
                            <div class="col">
                                <div class="card shadow mb-3">
                                    <div class="card-header py-3">
                                        <p class="m-0 fw-bold" style="font-family: Aldrich, sans-serif;font-size: 25px;">Datos del usuario</p>
                                    </div>
                                    <div class="card-body">
                                        <form>
                                            <div class="row">
                                                <div class="col" style="height: 100px;">
                                                    <div class="mb-3"><label class="form-label" for="username" style="font-family: Aldrich, sans-serif;font-size: 18px;"><strong>Nombre de usuario</strong></label><input id="username" class="form-control" type="text" placeholder="user.name" name="username" /></div>
                                                </div>
                                                <div class="col">
                                                    <div class="mb-3"><label class="form-label" for="email" style="font-family: Aldrich, sans-serif;font-size: 18px;"><strong>Correo eléctronico</strong></label><input id="correo" class="form-control" type="email" placeholder="user@example.com" name="correo" /></div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col" style="height: 100px;">
                                                    <div class="mb-3"><label class="form-label" for="first_name" style="font-family: Aldrich, sans-serif;font-size: 18px;"><strong>Nombre</strong><br /></label><input id="nombre" class="form-control" type="text" placeholder="name" name="nombre" /></div>
                                                </div>
                                                <div class="col">
                                                    <div class="mb-3"><label class="form-label" for="last_name" style="font-family: Aldrich, sans-serif;font-size: 18px;"><strong>Apellido</strong></label><input id="apellido" class="form-control" type="text" placeholder="lastname" name="apellido" /></div>
                                                </div>
                                            </div>
                                            <div class="mb-3"><button class="btn btn-primary btn-sm" type="submit" style="background: rgb(194,23,0);font-family: Aldrich, sans-serif;font-size: 20px;width: 225px;height: 42px;">Guardar cambios</button></div>
                                        </form>
                                    </div>
                                    <div class="card-body"><label class="form-label" for="username" style="font-family: Aldrich, sans-serif;font-size: 18px;"><strong>Historial de facturas</strong><br /></label>
                                        <div id="dataTable-2" class="table-responsive table mt-2" role="grid" aria-describedby="dataTable_info">
                                            <table id="dataTable" class="table my-0">
                                                <thead>
                                                    <tr>
                                                        <th>Factura</th>
                                                        <th>Detalles</th>
                                                        <th>Valor</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%while(res.next()){%>
                                                        <tr>
                                                            <td><%out.println(res.getString("idFacturaCliente"));%></td>
                                                            <td><%out.println(res.getString("productos"));%></td>
                                                            <td><%out.println(res.getString("total"));%></td>
                                                            <td>
                                                                <form action="servlet">
                                                                    <div id="info" style="display:none"><input id="id_empleado" name="id_empleado" type="text" value="<%out.println(user);%>"></div>
                                                                    <button type="submit" class="btn btn-primary border rounded-pill" style="background: rgb(194,23,0);font-family: Aldrich, sans-serif;width: 85px;height: 38px;">Calificar</button>
                                                                </form>
                                                            </td>
                                                        </tr>
                                                    <%}%>
                                                    <tr></tr>
                                                </tbody>
                                                <tfoot>
                                                    <tr></tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card shadow mb-5"></div>
            </div>
        </div>
    </main>
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