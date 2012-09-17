package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.SucursalModule;

public class ActualizarSucursal extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    SucursalModule module = (SucursalModule) context.getBean("sucursalModule");
    try {
      String codSucursal = request.getParameter("codSucursal");
      String telefono = request.getParameter("telefono");
      String ciudad = request.getParameter("ciudad");
      String direccion = request.getParameter("direccion");
      String encargado = request.getParameter("encargado");
      module.actualizar(codSucursal,telefono,ciudad,direccion,encargado);
      response.sendRedirect("listaSucursales");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}