<%@ page import="java.util.*" %>
<html>
    <head>
        <title>Sistema de Averias</title>
        <style type="text/css">
            <%@ include file="css/reset.css" %>
            <%@ include file="css/all.css" %>
        </style>
    </head>
    <body>
        <div id="wrapper">
            <div  class="header">
                <div class="logo"><a href="<%=request.getContextPath()%>/index.html"><img src="<%=request.getContextPath()%>/images/logo.png" /></a></div>
                <div class="nav">
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/index.html">Inicio</a></li>
                        <li><a href="/averias/listaSuscriptores">Suscriptores</a></li>
                        <li class="active"><a href="/averias/listaSucursales">Sucursales</a></li>
                        <li><a href="/averias/listaServicios">Servicios</a></li>
                        <li><a href="/averias/listaAverias">Averias</a></li>
                    </ul>
                </div>
            </div>
            <div class="content">
                <h2>Nueva Sucursal</h2>
                <form name="AgregarSucursal" action="/averias/agregarSucursal" method="get">
                    <input type="hidden" name="codSucursal" value=""/>
                    <table>
                        <tr><td>telefono:</td><td><input type="text" name="telefono"
                                                         value=""/></td></tr>
                        <tr><td>ciudad:</td><td><input type="text" name="ciudad"
                                                       value=""/></td></tr>
                        <tr><td>direccion:</td><td><input type="text" name="direccion"
                                                          value=""/></td></tr>
                        <tr><td>encargado:</td><td><input type="text" name="encargado"
                                                          value=""/></td></tr>
                        <tr><td></td><td><input type="submit" value="Agregar" /></td></tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>