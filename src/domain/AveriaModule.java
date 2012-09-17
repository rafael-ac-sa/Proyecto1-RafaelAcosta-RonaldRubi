package domain;

import data.TableGateway;
import data.AveriaGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;

public class AveriaModule {

  private AveriaGateway gateway;

  public void setGateway(TableGateway gateway) {
    this.gateway = (AveriaGateway)gateway;
  }

  public void actualizar(String codAveria,String descripcion,String fecha) throws Exception {
	int id = Integer.parseInt(codAveria);
    if (id <= 0)
      throw new Exception("Identificador de averia incorrecto");
    gateway.update(codAveria,descripcion,fecha);
  }
  
  public void insertar(String descripcion,String fecha,String servicio_codServicio,String estado) throws Exception {
    gateway.insert(descripcion,fecha,servicio_codServicio,estado);
  }
  
  public void eliminar(String codAveria) throws Exception {
      gateway.delete(codAveria);
  }

  public Map<String,Object> buscar(String codAveria) throws Exception {
	int id = Integer.parseInt(codAveria);
    if (id <= 0)
      throw new Exception("Identificador de averia incorrecto");
    Map<String,Object> sucursal = gateway.find(codAveria);
    return sucursal;
  }

  public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> averias = gateway.findAll();
    return averias;
  }
}