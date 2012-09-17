package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ServicioModule;

public class NuevaAveria extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    ServicioModule module = (ServicioModule) context.getBean("servicioModule");
    try {
      List data = module.listado();
      request.setAttribute("servicios",data);
      forward("/nuevaAveria.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}