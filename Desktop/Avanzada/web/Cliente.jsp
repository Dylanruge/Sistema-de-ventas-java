<%-- 
    Document   : Cliente
    Created on : 29/05/2024, 12:45:33 p. m.
    Author     : dylan
--%>

<%@page import="Modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <title>Cliente</title>
    </head>

    <body>
        <div class="form-group text-center pt-4">
            <h3>Clientes</h3>
        </div>
        
        <div class="d-flex pr-5 pl-5 pb-5 pt-1">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Cliente" method="post">
                        <div class="form-group">
                            <input class="form-control rounded-pill" type="hidden" name="id" value="${c.getId()}">
                        </div>

                        <div class="form-group">
                            <label>Dni</label>
                            <input class="form-control rounded-pill" type="text" name="dni" value="${c.getDni()}" required>
                        </div>

                        <div class="form-group">
                            <label>Nombres</label>
                            <input class="form-control rounded-pill" type="text" name="nombre" value="${c.getNombre()}" required>
                        </div>

                        <div class="form-group">
                            <label>Direccion</label>
                            <input class="form-control rounded-pill" type="text" name="direccion" value="${c.getDireccion()}" required>
                        </div>

                        <div class="form-group">
                            <label>Estado</label>
                            <input class="form-control rounded-pill" type="text" name="estado" value="${c.getEstado()}" required>
                        </div>

                        <input class="btn btn-info rounded-pill" type="submit" name="accion" value="Agregar">
                        <input class="btn btn-success rounded-pill" type="submit" name="accion" value="Actualizar">
                        <a class="btn btn-secondary rounded-pill" href="Controlador?menu=Cliente&accion=Listar">Limpiar</a>
                    </form>
                </div>
            </div>

            <div class="col-sm-8">
                <table class="table table-hover table-dark">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Dni</th>
                            <th>Nombres</th>
                            <th>Direccion</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cl" items="${listaC}">
                            <tr>
                                <td>${cl.getId()}</td>
                                <td>${cl.getDni()}</td>
                                <td>${cl.getNombre()}</td>
                                <td>${cl.getDireccion()}</td>
                                <td>${cl.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning rounded-pill" href="Controlador?menu=Cliente&accion=Editar&id=${cl.getId()}">Editar</a>
                                    <a class="btn btn-danger rounded-pill" href="Controlador?menu=Cliente&accion=Eliminar&id=${cl.getId()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
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