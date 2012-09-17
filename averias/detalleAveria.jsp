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
                <h2>Detalle de Averia</h2>
                <% Map averia = (Map) request.getAttribute("averia");%>
                <form name="ActualizarAveria" action="/averias/actualizarAveria" method="get">
                    <input type="hidden" name="codAveria" value="<%= averia.get("codAveria")%>"/>
                    <table>
                        <tr><td>descripcion:</td><td><input type="text" name="descripcion" value="<%= averia.get("descripcion")%>"/></td></tr>
                        <tr><td>fecha:</td><td><input type="text" name="fecha" value="<%= averia.get("fecha")%>"/></td></tr>
                        <tr><td>estado:</td><td><input type="text" name="estado" value="<%= averia.get("nombre")%>"/></td></tr>
                        <tr><td></td><td><input type="submit" value="Actualizar" /></td></tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>