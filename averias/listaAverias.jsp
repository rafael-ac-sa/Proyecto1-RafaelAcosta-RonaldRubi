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
                        <li><a href="/averias/listaSucursales">Sucursales</a></li>
                        <li><a href="/averias/listaServicios">Servicios</a></li>
                        <li class="active"><a href="/averias/listaAverias">Averias</a></li>
                    </ul>
                </div>
            </div>
            <div class="content">
                <h2>Listado de averias</h2>
                <% List averias = (List) request.getAttribute("averias");%>
                <table class="list">
                    <tr><th>Descripcion</th><th>Fecha</th><th>Estado</th><th>Acciones</th></tr>
                    <% for (int i = 0, n = averias.size(); i < n; i++) {
                            Map averia = (Map) averias.get(i);%>
                    <tr><td><%= averia.get("descripcion")%></td>
                        <td><%= averia.get("fecha")%></td>
                        <td><%= averia.get("nombre")%></td>
                        <td><a href='/averias/detalleAveria?codAveria=<%= averia.get("codAveria")%>'>
                                <input type="submit" value="Detalle"/></a>
                            <a href='/averias/eliminarAveria?codAveria=<%= averia.get("codAveria")%>'>
                                <input type="submit" value="Eliminar"/></a>
                        </td>
                    </tr>
                    <% }%>
                </table>
                <table>
                    <tr><td><a href='/averias/nuevaAveria'>
                                <input type="submit" name="action" value="Agregar"/></a>
                        </td></tr>
                </table>
            </div>
        </div>
    </body>
</html>