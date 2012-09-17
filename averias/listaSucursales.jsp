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
                <h2>Listado de sucursales</h2>
                <% List sucursales = (List) request.getAttribute("sucursales");%>
                <table class="list">
                    <tr><th>Telefono</th><th>Ciudad</th><th>Direccion</th><th>Encargado</th><th>Acciones</th></tr>
                    <% for (int i = 0, n = sucursales.size(); i < n; i++) {
                            Map sucursal = (Map) sucursales.get(i);%>
                    <tr><td><%= sucursal.get("telefono")%></td>
                        <td><%= sucursal.get("ciudad")%></td>
                        <td><%= sucursal.get("direccion")%></td>
                        <td><%= sucursal.get("encargado")%></td>
                        <td><a href='/averias/detalleSucursal?codSucursal=<%= sucursal.get("codSucursal")%>'>
                                <input type="submit" value="Detalle"/></a>
                            <a href='/averias/eliminarSucursal?codSucursal=<%= sucursal.get("codSucursal")%>'>
                                <input type="submit" value="Eliminar"/></a></td></tr>
                                <% }%>
                </table>
                <table>
                    <tr><td><a href='../nuevaSucursal.jsp'>
                                <input type="submit" name="action" value="Agregar"/></a>
                        </td></tr>
                </table>
            </div>
        </div>
    </body>
</html>