package domain;

import data.TableGateway;
import data.ServicioGateway;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

public class ServicioModule {

  private ServicioGateway gateway;

  public void setGateway(TableGateway gateway) {
    this.gateway = (ServicioGateway)gateway;
  }
  
  public void actualizar(String codServicio,String nombre,String fechaInst,String direccion,String region_codRegion,String suscriptor_idSuscriptor) throws Exception {
	int id = Integer.parseInt(codServicio);
    if (id <= 0)
      throw new Exception("Identificador de servicio incorrecto");
    gateway.update(codServicio,nombre,fechaInst,direccion,region_codRegion,suscriptor_idSuscriptor);
  }
  
  public void insertar(String nombre,String fechaInst,String direccion,String region_codRegion,String suscriptor_idSuscriptor) throws Exception {
    gateway.insert(nombre,fechaInst,direccion,region_codRegion,suscriptor_idSuscriptor);
  }
  
  public void eliminar(String codServicio) throws Exception {
      gateway.delete(codServicio);
  }

  public Map<String,Object> buscar(String codServicio) throws Exception {
	int id = Integer.parseInt(codServicio);
    if (id <= 0)
      throw new Exception("Identificador de servicio incorrecto");
    Map<String,Object> servicio = gateway.find(codServicio);
    return servicio;
  }

  public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> servicios = gateway.findAll();
    return servicios;
  }
}