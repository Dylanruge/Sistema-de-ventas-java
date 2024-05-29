<%-- 
    Document   : Principal
    Created on : 29/05/2024, 12:44:46 p. m.
    Author     : dylan
--%>

<%@page import="Modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesion = request.getSession();
    Empleado e = (Empleado) sesion.getAttribute("user");

    if (e != null){
%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="Estilos/estiloPrincipal.css"/>
        <title>Principal</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg d-flex">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#"><span class="sr-only">(current)</span></a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left:10px; border:none; border-radius: 20px" class="btn btn-outline-light" 
                           href="Controlador?menu=Inicio&accion=default" target="frame">Inicio</a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none; border-radius: 20px" class="btn btn-outline-light" 
                           href="Controlador?menu=Producto&accion=Listar" target="frame">Productos</a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none; border-radius: 20px" class="btn btn-outline-light" 
                           href="Controlador?menu=Empleado&accion=Listar" target="frame">Empleados</a>
                    </li>

                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none; border-radius: 20px" class="btn btn-outline-light" 
                           href="Controlador?menu=Cliente&accion=Listar" target="frame">Clientes</a>
                    </li>

                    <li style="margin-left: 10px; border:none" class="nav-item">
                        <a style="margin-left: 10px; border:none; border-radius: 20px" class="btn btn-outline-light" 
                           href="Controlador?menu=NuevaVenta&accion=default" target="frame">Nueva Venta</a>
                    </li>
                </ul>
            </div>

            <div class="dropdown">
                <button style="border:none; border-radius: 20px" class="btn btn-outline-light dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
                    ${user.getNombre()}
                </button>

                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="#">
                        <img src="Estilos/Imgs/logoUsuario.jpg" alt="LogoUsuario" height="50" width="50"/>
                    </a>

                    <a class="dropdown-item" href="#">${user.getUsuario()}</a>
                    <a class="dropdown-item" href="#">usuario@correo.co</a>
                    <div class="dropdown-divider"></div>

                    <form action="Validar" method="post">
                        <button class="dropdown-item" name="accion" value="Salir">Salir</button>
                    </form>
                </div>
            </div>
        </nav>

        <div class="m-4">
            <iframe class="frame" name="frame" style="width:100%;height:100vh;border:none"></iframe>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
<%
    }
    else{
        sesion.invalidate();
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>