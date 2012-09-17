package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.AveriaModule;

public class DetalleAveria extends PageController {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    AveriaModule module = (AveriaModule) context.getBean("averiaModule");
    try {
      String codAveria = request.getParameter("codAveria");
      Map averia = module.buscar(codAveria);
      request.setAttribute("averia",averia);
      forward("/detalleAveria.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}