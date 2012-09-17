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
                <h2>Nueva Averia</h2>
                <% List servicios = (List) request.getAttribute("servicios");%>
                <form name="AgregarAveria" action="/averias/agregarAveria" method="get">
                    <input type="hidden" name="codAveria" value=""/>
                    <table>
                        <tr><td>descripcion:</td><td><input type="text" name="descripcion" value=""/></td></tr>
                        <tr><td>fecha:</td><td><input type="text" name="fecha" value=""/></td></tr>
                        <tr><td>servicio:</td>
                            <td>
                                <select name="servicio_codServicio">
                                    <% for (int i = 0, n = servicios.size(); i < n; i++) {
                                                                Map servicio = (Map) servicios.get(i);%>
                                    <option value="<%= servicio.get("codServicio")%>"><%= servicio.get("nombre")%></option>
                                    <% }%>
                                </select>
                            </td></tr>
                        <tr><td>estado:</td>
                            <td>
                                <select name="estado">
                                    <option value="pendiente">Pendiente</option>
                                    <option value="revision">En revision</option>
                                    <option value="resuelto">Resuelto</option>
                                </select>
                            </td>
                        </tr>
                        <tr><td></td><td><input type="submit" value="Agregar" /></td></tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>