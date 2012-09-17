<%@ page import="java.util.Map" %>
<%@ page import="java.lang.String" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sistema de Averias</title>
  </head>
  <h1>Sistema de Averias</h1>
  <h2>ERROR</h2>
  <% String mensaje = (String)request.getAttribute("mensaje"); %>
  <tr><td>Mensaje:</td><td><%= mensaje %></td></tr>
  </table>
</html>