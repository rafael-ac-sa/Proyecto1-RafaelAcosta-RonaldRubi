package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.AveriaModule;
public class EliminarAveria extends PageController {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    AveriaModule module = (AveriaModule) context.getBean("averiaModule");
    try {
      String codAveria = request.getParameter("codAveria");
      module.eliminar(codAveria);
      response.sendRedirect("listaAverias");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}