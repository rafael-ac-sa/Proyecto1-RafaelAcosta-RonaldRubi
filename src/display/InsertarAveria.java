package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.AveriaModule;
import java.text.SimpleDateFormat;

public class InsertarAveria extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    AveriaModule module = (AveriaModule) context.getBean("averiaModule");
    try {
      String descripcion = request.getParameter("descripcion");
      
      String fecha = request.getParameter("fecha");
	  String servicio_codServicio = request.getParameter("servicio_codServicio");
      String estado = request.getParameter("estado");
      
      module.insertar(descripcion,fecha,servicio_codServicio,estado);
      response.sendRedirect("listaAverias");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}