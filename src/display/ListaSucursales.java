package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.SucursalModule;

public class ListaSucursales extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    SucursalModule module = (SucursalModule) context.getBean("sucursalModule");
    try {
      List data = module.listado();
      request.setAttribute("sucursales",data);
      forward("/listaSucursales.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}