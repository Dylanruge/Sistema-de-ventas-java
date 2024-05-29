<%-- 
    Document   : Inicio
    Created on : 29/05/2024, 12:45:02 p. m.
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
        <link rel="stylesheet" type="text/css" href="Estilos/estiloFunNav.css"/>
        <title>Inicio</title>
    </head>

    <body>
        <div class="container col-lg-7 vh-100 d-flex justify-content-center align-items-center">
            <div class="inicio col-sm-10 text-center">
                <div class="card-body">
                    <div class="form-group">
                        <h2>
                            <b>Bienvenido/a ${user.getNombre()}</b>
                        </h2>
                        
                        <hr style="border: 1
                            px solid white"> 
                        <p>
                            En el navegador superior podrá encontrar las diferentes
                            opciones que le brinda el aplicativo. Sin más que agregar,
                            disfrute su recorrido en el programa.
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
<%
    }
    else{
        sesion.removeAttribute("user");
        sesion.invalidate();
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>