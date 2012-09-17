package domain;

import data.TableGateway;
import data.RegionGateway;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

public class RegionModule {

  private RegionGateway gateway;

  public void setGateway(TableGateway gateway) {
    this.gateway = (RegionGateway)gateway;
  }
  
  public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> regiones = gateway.findAll();
    return regiones;
  }
}