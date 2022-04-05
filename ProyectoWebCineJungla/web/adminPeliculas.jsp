<%@page import="java.sql.ResultSet"%>
<%
  ResultSet res1 = (ResultSet) session.getAttribute("resPeliculas");
  String empleado = (String) session.getAttribute("idEmpleado");;
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
                    <li class="nav-item"><a class="nav-link active" action="servlet"><i class="fa fa-video-camera"></i><span style="margin-left: 8px;">PelÃ­culas</span></a><a class="nav-link" action="servlet"><i class="fa fa-cutlery"></i><span style="margin-left: 8px;">Confitería</span></a><a class="nav-link" action="servlet"><i class="fa fa-user-plus"></i><span style="margin-left: 8px;">Personal</span></a></li>
                    <li class="nav-item"></li>
                    <li class="nav-item"></li>
                    <li class="nav-item"></li>
                    <li class="nav-item"></li>
                </ul><a href="index.html"><button class="btn btn-primary" type="button" style="background: rgb(194,23,0);font-family: Aldrich, sans-serif;width: 149px;height: 38px;padding-left: 0px;padding-top: 4px;">Cerrar sesión</button></a>
                <div class="text-center d-none d-md-inline"></div>
            </div>
        </nav>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
                <div id="content-1">
                    <div class="container-fluid">
                        <h3 class="text-dark mb-4" style="margin-top: 22px;font-family: Aclonica, sans-serif;font-size: 28px;">Películas</h3>
                        <div class="card shadow">
                            <div class="card-header py-3">
                                <p class="text-primary m-0 fw-bold" style="color: rgb(0,0,0);--bs-primary: #000000;--bs-primary-rgb: 0,0,0;font-family: Aldrich, sans-serif;">Modificación de las funciones</p>
                            </div>
                            <div class="card-body"><a class="card-link" href="adminPeliculasAdd.html"><button class="btn btn-primary border rounded-pill" type="button" style="background: rgb(194,23,0);font-family: Aldrich, sans-serif;width: 150px;height: 38px;">Añadir película</button></a>
                                <div class="table-responsive table mt-2" id="dataTable-1" role="grid" aria-describedby="dataTable_info">
                                    <table class="table my-0" id="dataTable">
                                        <thead>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Duración</th>
                                                <th>Clasificación de edad</th>
                                                <th>Director</th>
                                                <th>Sinopsis</th>
                                                <th>Estado</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%while(res1.next()){%>
                                                <tr>
                                                    <td><%out.println(res1.getString("Nombre"));%></td>
                                                    <td><%out.println(res1.getString("Duracion"));%></td>
                                                    <td><%out.println(res1.getString("ClasificacionEdad"));%></td>
                                                    <td><%out.println(res1.getString("Director"));%></td>
                                                    <td><%out.println(res1.getString("Sinopsis"));%></td>
                                                    <td><%out.println(res1.getString("Estado"));%></td>
                                                    <td>
                                                        <form action="servlet">
                                                            <div id="info" style="display:none"><input id="id_empleado" name="id_empleado" type="text" value="<%out.println(empleado);%>"></div>
                                                            <button type="submit" class="btn btn-primary border rounded-pill" style="background: rgb(194,23,0);font-family: Aldrich, sans-serif;width: 85px;height: 38px;">Eliminar</button>
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
                        <div class="card shadow">
                            <div class="card-header py-3">
                                <form action="servlet">
                                    <select class="border rounded-pill" style="font-size: 24px;font-family: Aldrich, sans-serif;text-align: center;background: rgb(194,23,0);border: 2px solid rgb(180,182,186);color: rgb(255,255,255);margin-bottom: 6px;margin-left: -2px;">
                                        <optgroup label="Múltiplex">
                                            <option value="1" selected>Titán Plaza</option>
                                            <option value="2">Unicentro</option>
                                            <option value="3">Plaza Central</option>
                                            <option value="4">Gran Estación</option>
                                            <option value="5">Embajador</option>
                                            <option value="6">Plaza de las Ámericas</option>
                                        </optgroup>
                                    </select>
                                </form>
                                <p class="text-primary m-0 fw-bold" style="color: rgb(0,0,0);--bs-primary: #000000;--bs-primary-rgb: 0,0,0;font-family: Aldrich, sans-serif;margin-top: 0px;">Salas disponibles</p>
                            </div>
                            <div class="card-body d-flex">
                                <%while(res1.next()){%>
                                    <h1 class="border rounded-pill" style="width: 50px;height: 34px;font-size: 20px;color: rgb(0,0,0);margin: 5px;margin-bottom: 0px;background: #ebebeb;padding: 5px;"><%out.println(res1.getString("numero"));%></h1>
                                <%}%> 
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