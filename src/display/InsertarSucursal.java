package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.SucursalModule;

public class InsertarSucursal extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    SucursalModule module = (SucursalModule) context.getBean("sucursalModule");
    try {
      String telefono = request.getParameter("telefono");
      String ciudad = request.getParameter("ciudad");
      String direccion = request.getParameter("direccion");
      String encargado = request.getParameter("encargado");
      module.insertar(telefono,ciudad,direccion,encargado);
      response.sendRedirect("listaSucursales");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}