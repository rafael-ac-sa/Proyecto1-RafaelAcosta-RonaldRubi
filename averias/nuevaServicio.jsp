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
                        <li class="active"><a href="/averias/listaServicios">Servicios</a></li>
                        <li><a href="/averias/listaAverias">Averias</a></li>
                    </ul>
                </div>
            </div>
            <div class="content">
                <h2>Nuevo Servicio</h2>
                <% List suscriptores = (List) request.getAttribute("suscriptores");%>
                <% List regiones = (List) request.getAttribute("regiones");%>
                <form name="AgregarServicio" action="/averias/agregarServicio" method="get">
                    <input type="hidden" name="codServicio" value=""/>
                    <table>
                        <tr><td>Nombre:</td><td><input type="text" name="nombre"
                                                       value=""/></td></tr>
                        <tr><td>Fecha Instalacion:</td><td><input type="text" name="fechaInst"
                                                                  value=""/></td></tr>
                        <tr><td>Direccion:</td><td><input type="text" name="direccion"
                                                          value=""/></td></tr>
                        <tr><td>Region:</td>
                            <td>
                                <select name="region_codRegion">
                                    <% for (int j = 0, k = regiones.size(); j < k; j++) {
                                                                Map region = (Map) regiones.get(j);%>
                                    <option value="<%= region.get("codRegion")%>"><%= region.get("encargado")%></option>
                                    <% }%>
                                </select>
                            </td></tr>
                        <tr><td>Suscriptor:</td>
                            <td>
                                <select name="suscriptor_idSuscriptor">
                                    <% for (int i = 0, n = suscriptores.size(); i < n; i++) {
                                                                Map suscriptor = (Map) suscriptores.get(i);%>
                                    <option value="<%= suscriptor.get("idSuscriptor")%>"><%= suscriptor.get("nombre")%></option>
                                    <% }%>
                                </select>
                            </td></tr>
                        <tr><td></td><td><input type="submit" value="Agregar" /></td></tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>