package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.SucursalModule;

public class DetalleSucursal extends PageController {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    SucursalModule module = (SucursalModule) context.getBean("sucursalModule");
    try {
      String codSucursal = request.getParameter("codSucursal");
      Map sucursal = module.buscar(codSucursal);
      request.setAttribute("sucursal",sucursal);
      forward("/detalleSucursal.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}