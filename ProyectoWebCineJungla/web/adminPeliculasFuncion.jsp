<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Table - Brand</title>
    <link rel="stylesheet" href="assetsAdmin/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aclonica&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aldrich&amp;display=swap">
    <link rel="stylesheet" href="assetsAdmin/fonts/font-awesome.min.css">
</head>

<body id="page-top">
    <div id="wrapper">
        <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0" style="background: rgb(0,0,0);">
            <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#" style="font-size: 23px;font-family: Aclonica, sans-serif;margin-top: 0px;">
                    <div class="sidebar-brand-text mx-3"><span style="font-size: 23px;font-family: Aclonica, sans-serif;margin-top: 0px;">cine jungla</span>
                        <p style="font-size: 8px;font-family: Aldrich, sans-serif;margin-top: 0px;margin-bottom: -16px;">Aministrador</p>
                    </div>
                </a>
                <ul class="navbar-nav text-light" id="accordionSidebar">
                    <li class="nav-item"><a class="nav-link active" action="servlet"><i class="fa fa-video-camera"></i><span style="margin-left: 8px;">Películas</span></a>
                    <a class="nav-link" action="servlet"><i class="fa fa-cutlery"></i><span style="margin-left: 8px;">Confitería</span></a>
                    <a class="nav-link" action="servlet"><i class="fa fa-user-plus"></i><span style="margin-left: 8px;">Personal</span></a></li>
                </ul><a href="index.html"><button class="btn btn-primary" type="button" style="background: rgb(194,23,0);font-family: Aldrich, sans-serif;width: 149px;height: 38px;padding-left: 0px;padding-top: 4px;">Cerrar sesiÃ³n</button></a>
                <div class="text-center d-none d-md-inline"></div>
            </div>
        </nav>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
                <div id="content-1">
                    <div class="container-fluid">
                        <h3 class="text-dark mb-4" style="margin-top: 22px;font-family: Aclonica, sans-serif;font-size: 28px;">PelÃ­culas&nbsp;</h3>
                        <div class="card shadow">
                            <div class="card-header py-3">
                                <p class="text-primary m-0 fw-bold" style="color: rgb(0,0,0);--bs-primary: #000000;--bs-primary-rgb: 0,0,0;font-family: Aldrich, sans-serif;">Funciones de la pelicula</p>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive table mt-2" id="dataTable-1" role="grid" aria-describedby="dataTable_info">
                                    <table class="table my-0" id="dataTable">
                                        <thead>
                                            <tr>
                                                <th>Sala</th>
                                                <th>Duración</th>
                                                <th>Año</th>
                                                <th>Mes</th>
                                                <th>Día</th>
                                                <th>Hora</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%while(res.next()){%>
                                                <tr>
                                                    <td><%out.println(res.getString(""));%></td>
                                                    <td><%out.println(res.getString(""));%></td>
                                                    <td><%out.println(res.getString(""));%></td>
                                                    <td><%out.println(res.getString(""));%></td>
                                                    <td><%out.println(res.getString(""));%></td>
                                                    <td><%out.println(res.getString(""));%></td>
                                                </tr>
                                            <%}%>
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
            <footer class="bg-white sticky-footer">
                <div class="container my-auto">
                    <div class="text-center my-auto copyright"><span>Cine Jungla S.A.S</span></div>
                </div>
            </footer>
        </div>
    </div>
    <script src="assetsAdmin/bootstrap/js/bootstrap.min.js"></script>
    <script src="assetsAdmin/js/theme.js"></script>
</body>

</html>