package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class SucursalGateway extends TableGateway {

  private final static String findStatement =
     "SELECT * "+
     "FROM sucursal "+
     "WHERE codSucursal = ?";
	   
  public Map<String, Object> find(String codSucursal) {
    List sucursales = jdbcTemplate.queryForList(findStatement,codSucursal);
    return (Map<String, Object>)sucursales.get(0);
  }

  private final static String findAllStatement =
     "SELECT * "+
     "FROM sucursal ";

  public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement =
    "INSERT INTO sucursal "+
  "VALUES (?,?,?,?,?)";

  public int insert(String telefono,String ciudad,String direccion,String encargado) {
    Random generator = new Random();
    int id = -1;
	while (id <= 0) {
	  id = generator.nextInt();
	}	
	String codSucursal= id+"";
      jdbcTemplate.update(insertStatement,
         codSucursal,telefono,ciudad,direccion,encargado);
    return id;
  }

  private static final String updateStatement =
    "UPDATE sucursal "+
    "SET telefono = ?, ciudad = ?, direccion = ?, "+
    "encargado = ? WHERE codSucursal = ?";

  public void update(String codSucursal,String telefono,String ciudad,String direccion,String encargado) {
      jdbcTemplate.update(updateStatement,
         telefono,ciudad,direccion,encargado,codSucursal);
  }

  private static final String deleteStatement =
    "DELETE FROM sucursal "+
    "WHERE codSucursal = ?";

  public void delete(String codSucursal) {
      jdbcTemplate.update(deleteStatement,codSucursal);
  }
}