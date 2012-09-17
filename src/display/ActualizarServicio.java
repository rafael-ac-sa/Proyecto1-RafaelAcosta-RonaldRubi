package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ServicioModule;
import domain.SuscriptorModule;

public class ActualizarServicio extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    ServicioModule module = (ServicioModule) context.getBean("servicioModule");
    try {
      String codServicio = request.getParameter("codServicio");
	  String nombre = request.getParameter("nombre");
	  String fechaInst = request.getParameter("fechaInst");
      String direccion = request.getParameter("direccion");
      String region_codRegion = request.getParameter("region_codRegion");
      String suscriptor_idSuscriptor = request.getParameter("suscriptor_idSuscriptor");
      module.actualizar(codServicio,nombre,fechaInst,direccion,region_codRegion,suscriptor_idSuscriptor);
      response.sendRedirect("listaServicios");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}