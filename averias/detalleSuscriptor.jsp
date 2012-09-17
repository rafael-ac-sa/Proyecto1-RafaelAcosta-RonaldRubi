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
                        <li class="active"><a href="/averias/listaSuscriptores">Suscriptores</a></li>
                        <li><a href="/averias/listaSucursales">Sucursales</a></li>
						<li><a href="/averias/listaServicios">Servicios</a></li>
                        <li><a href="/averias/listaAverias">Averias</a></li>
                    </ul>
                </div>
            </div>
            <div class="content">
                <h2>Detalle de Suscriptor</h2>
                <% Map suscriptor = (Map) request.getAttribute("suscriptor");%>
                <form name="ActualizarSuscriptor" action="/averias/actualizarSuscriptor" method="get">
                    <input type="hidden" name="idSuscriptor" value="<%= suscriptor.get("idSuscriptor")%>"/>
                    <table>
                        <tr><td>Nombre:</td><td><input type="text" name="nombre"
                                                       value="<%= suscriptor.get("nombre")%>"/></td></tr>
                        <tr><td>Identificacion:</td><td><input type="text" name="identificacion"
                                                               value="<%= suscriptor.get("identificacion")%>"/></td></tr>
                        <tr><td>Telefono:</td><td><input type="text" name="telefono"
                                                         value="<%= suscriptor.get("telefono")%>"/></td></tr>
                        <tr><td>Direccion:</td><td><input type="text" name="direccion"
                                                          value="<%= suscriptor.get("direccion")%>"/></td></tr>
                        <tr><td></td><td><input type="submit" value="Actualizar" /></td></tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>