package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.SuscriptorModule;

public class DetalleSuscriptor extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    SuscriptorModule module = (SuscriptorModule) context.getBean("suscriptorModule");
    try {
      String idSuscriptor = request.getParameter("idSuscriptor");	  
      Map suscriptor = module.buscar(idSuscriptor);
      request.setAttribute("suscriptor",suscriptor);
      forward("/detalleSuscriptor.jsp",request,response);
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}