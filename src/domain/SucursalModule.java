package domain;

import data.TableGateway;
import data.SucursalGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

public class SucursalModule {

  private SucursalGateway gateway;

  public void setGateway(TableGateway gateway) {
    this.gateway = (SucursalGateway)gateway;
  }

  public void actualizar(String codSucursal,String telefono,String ciudad,String direccion,String encargado) throws Exception {
	int id = Integer.parseInt(codSucursal);
    if (id <= 0)
      throw new Exception("Identificador de sucursal incorrecto");
    gateway.update(codSucursal,telefono,ciudad,direccion,encargado);
  }
  
  public void insertar(String telefono,String ciudad,String direccion,String encargado) throws Exception {
    gateway.insert(telefono,ciudad,direccion,encargado);    
  }
  
  public void eliminar(String codSucursal) throws Exception {
      gateway.delete(codSucursal);
  }

  public Map<String,Object> buscar(String codSucursal) throws Exception {
	int id = Integer.parseInt(codSucursal);
    if (id <= 0)
      throw new Exception("Identificador de sucursal incorrecto");
    Map<String,Object> sucursal = gateway.find(codSucursal);
    return sucursal;
  }

  public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> sucursales = gateway.findAll();
    return sucursales;
  }
}