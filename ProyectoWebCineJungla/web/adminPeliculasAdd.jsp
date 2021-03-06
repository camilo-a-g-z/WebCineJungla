<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String empleado = (String) session.getAttribute("idEmpleado"); 

%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Cine Jungla</title>
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
                    <li class="nav-item">
                        <form class="nav-link active" action="ListarPeliculas">
                            <div id="info" style="display:none">
                                <input id="idEmpleado" name="idEmpleado" type="text" value="<%out.println(empleado);%>">
                            </div>
                            <i class="fa fa-video-camera"></i><button class="btn btn-primary" type="submit" style="background: rgb(0,0,0);font-size: 14px;border-style: none;">Pel??culas</button>
                        </form>
                        <form class="nav-link" action="ListarConfiteria">
                            <div id="info" style="display:none">
                                <input id="idEmpleado" name="idEmpleado" type="text" value="<%out.println(empleado);%>">
                            </div>
                            <i class="fa fa-cutlery"></i><button class="btn btn-primary" type="submit" style="background: rgb(0,0,0);font-size: 14px;border-style: none;">Confiter??a</button>
                        </form>
                        <form class="nav-link" action="ListarEmpleado">
                            <div id="info" style="display:none">
                                <input id="idEmpleado" name="idEmpleado" type="text" value="<%out.println(empleado);%>">
                            </div>
                            <i class="fa fa-user-plus"></i><button class="btn btn-primary" type="submit" style="background: rgb(0,0,0);font-size: 14px;border-style: none;">Personal</button>
                        </form>
                        <form class="nav-link" action="ListarMultiplex">
                            <div id="info" style="display:none">
                                <input id="idEmpleado" name="idEmpleado" type="text" value="<%out.print(empleado);%>">
                            </div>
                            <i class="fa fa-shopping-bag"></i><button class="btn btn-primary" type="submit" style="background: rgb(0,0,0);font-size: 14px;border-style: none;">Multiplex</button>
                        </form>
                    </li>
                </ul><a href="index.jsp"><button class="btn btn-primary" type="button" style="background: rgb(194,23,0);font-family: Aldrich, sans-serif;width: 149px;height: 38px;padding-left: 0px;padding-top: 4px;">Cerrar sesi??n</button></a>
                <div class="text-center d-none d-md-inline"></div>
            </div>
        </nav>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
                <div id="content-1">
                    <div class="container-fluid">
                        <h3 class="text-dark mb-4" style="margin-top: 22px;font-family: Aclonica, sans-serif;font-size: 28px;">Pel??culas&nbsp;</h3>
                        <div class="card shadow">
                            <div class="card-header py-3">
                                <p class="text-primary m-0 fw-bold" style="color: rgb(0,0,0);--bs-primary: #000000;--bs-primary-rgb: 0,0,0;font-family: Aldrich, sans-serif;">Modificaci??n de las funciones</p>
                            </div>
                            <div class="card-body">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h4 class="text-dark mb-4" style="font-family: Aldrich, sans-serif;font-size: 25px;">Datos de la pel??cula</h4>
                                    </div>
                                    <form class="d-inline user" action="AddPelicula">
                                        <div id="info" style="display:none"><input id="id_empleado" name="id_empleado" type="text" value="<%out.println(empleado);%>"></div>
                                        <div class="row mb-3">
                                            <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="text" id="nombre" placeholder="Nombre" name="nombre"></div>
                                            <div class="col-sm-6"><input class="form-control form-control-user" type="text" id="director" placeholder="Director" name="director"></div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="col-sm-6 col-xl-4 mb-3 mb-sm-0"><input class="form-control form-control-user" type="text" id="duracion" placeholder="Duraci??n (minutos)" name="duracion"></div>
                                            <div class="col-sm-6 col-xl-4"><input class="form-control form-control-user" type="text" id="clasificacionEdad" placeholder="Clasificaci??n de edad" name="clasificacionEdad"></div>
                                            <div class="col-xl-4"><input class="form-control form-control-user" type="text" id="estado" placeholder="Estado" name="estado"></div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="col-sm-6 mb-3 mb-sm-0"><input class="form-control form-control-user" type="text" id="sinopsis" placeholder="Sinopsis" name="sinopsis"></div>
                                            <div class="col-sm-6"><input class="form-control form-control-user" type="text" id="imagen" placeholder="Imagen" name="imagen"></div>
                                        </div><button class="btn btn-primary border rounded-pill" type="submit" style="background: rgb(194,23,0);font-family: Aldrich, sans-serif;width: 180px;height: 38px;">A??adir pel??cula</button>
                                        <hr>
                                    </form>
                                    <div class="text-center"></div>
                                    <div class="text-center"></div>
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