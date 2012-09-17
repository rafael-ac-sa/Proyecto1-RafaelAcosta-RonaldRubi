package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.SuscriptorModule;

public class ListaSuscriptores extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    SuscriptorModule module = (SuscriptorModule) context.getBean("suscriptorModule");
    try {
      List data = module.listado();
      request.setAttribute("suscriptores",data);
      forward("/listaSuscriptores.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}