package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ServicioModule;
public class EliminarServicio extends PageController {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    ServicioModule module = (ServicioModule) context.getBean("servicioModule");
    try {
      String codServicio = request.getParameter("codServicio");
      module.eliminar(codServicio);
      response.sendRedirect("listaServicios");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}