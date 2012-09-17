package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ServicioModule;
import domain.SuscriptorModule;
import domain.RegionModule;

public class DetalleServicio extends PageController {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    ServicioModule module = (ServicioModule) context.getBean("servicioModule");
	SuscriptorModule module_suscriptor = (SuscriptorModule) context.getBean("suscriptorModule");
	RegionModule module_region = (RegionModule) context.getBean("regionModule");
    try {
      String codServicio = request.getParameter("codServicio");
      Map servicio = module.buscar(codServicio);
      request.setAttribute("servicio",servicio);
	  List data = module_suscriptor.listado();
      request.setAttribute("suscriptores",data);
	  List data_regiones = module_region.listado();
      request.setAttribute("regiones",data_regiones);
      forward("/detalleServicio.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}