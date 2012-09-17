package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.AveriaModule;
import java.text.SimpleDateFormat;

public class ActualizarAveria extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    AveriaModule module = (AveriaModule) context.getBean("averiaModule");
    try {
      String codAveria = request.getParameter("codAveria");
      String descripcion = request.getParameter("descripcion");
      
      String fecha = request.getParameter("fecha");    
      module.actualizar(codAveria,descripcion,fecha);
      
      response.sendRedirect("listaAverias");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}