package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.SuscriptorModule;

public class InsertarSuscriptor extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    SuscriptorModule module = (SuscriptorModule) context.getBean("suscriptorModule");
    try {
      String nombre = request.getParameter("nombre");
      String identificacion = request.getParameter("identificacion");
      String telefono = request.getParameter("telefono");
      String direccion = request.getParameter("direccion");
      module.insertar(nombre,identificacion,telefono,direccion);
      response.sendRedirect("listaSuscriptores");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}