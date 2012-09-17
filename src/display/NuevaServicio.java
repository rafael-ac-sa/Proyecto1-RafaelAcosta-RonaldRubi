package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.SuscriptorModule;
import domain.RegionModule;

public class NuevaServicio extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    SuscriptorModule module = (SuscriptorModule) context.getBean("suscriptorModule");
	RegionModule module_region = (RegionModule) context.getBean("regionModule");
    try {
      List data = module.listado();
      request.setAttribute("suscriptores",data);
	  List data_regiones = module_region.listado();
      request.setAttribute("regiones",data_regiones);
      forward("/nuevaServicio.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}