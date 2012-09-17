package domain;

import data.TableGateway;
import data.SuscriptorGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

public class SuscriptorModule {

  private SuscriptorGateway gateway;

  public void setGateway(TableGateway gateway) {
    this.gateway = (SuscriptorGateway)gateway;
  }

  public void actualizar(String idSuscriptor,String nombre,String identificacion,String telefono,String direccion) throws Exception {
	int id = Integer.parseInt(idSuscriptor);
    if (id <= 0)
      throw new Exception("Identificador de suscriptor incorrecto");
    gateway.update(idSuscriptor,nombre,identificacion,telefono,direccion);
  }
  
  public void insertar(String nombre,String identificacion,String telefono,String direccion) throws Exception {
    gateway.insert(nombre,identificacion,telefono,direccion);    
  }
  
  public void eliminar(String idSuscriptor) throws Exception {
      gateway.delete(idSuscriptor);
  }

  public Map<String,Object> buscar(String idSuscriptor) throws Exception {
	int id = Integer.parseInt(idSuscriptor);
    if (id <= 0)
      throw new Exception("Identificador de suscriptor incorrecto");
    Map<String,Object> suscriptor = gateway.find(idSuscriptor);
    return suscriptor;
  }

  public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> suscriptores = gateway.findAll();
    return suscriptores;
  }
}