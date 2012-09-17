package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class ServicioGateway extends TableGateway {

  private final static String findStatement =
     "SELECT * "+
     "FROM servicio "+
     "WHERE codServicio = ?";

  public Map<String, Object> find(String codServicio) {
    List servicios = jdbcTemplate.queryForList(findStatement,codServicio);
    return (Map<String, Object>)servicios.get(0);
  }

  private final static String findAllStatement =
     "SELECT * "+
     "FROM servicio ";

  public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement =
    "INSERT INTO servicio "+
  "VALUES (?,?,?,?,?,?)";

  public int insert(String nombre,String fechaInst,String direccion,String region_codRegion,String suscriptor_idSuscriptor) {
    Random generator = new Random();
    int id = -1;
	while (id <= 0) {
	  id = generator.nextInt();
	}
	String codServicio= id+"";
      jdbcTemplate.update(insertStatement,
         codServicio,fechaInst,direccion,region_codRegion,suscriptor_idSuscriptor,nombre);
    return id;
  }

  private static final String updateStatement =
    "UPDATE servicio "+
    "SET nombre = ?, fechaInst = ?, direccion = ?, region_codRegion = ?, "+
    "suscriptor_idSuscriptor = ? WHERE codServicio = ?";

  public void update(String codServicio,String nombre,String fechaInst,String direccion,String region_codRegion,String suscriptor_idSuscriptor) {
      jdbcTemplate.update(updateStatement,
         nombre,fechaInst,direccion,region_codRegion,suscriptor_idSuscriptor,codServicio);
  }

  private static final String deleteStatement =
    "DELETE FROM servicio "+
    "WHERE codServicio = ?";

  public void delete(String codServicio) {
      jdbcTemplate.update(deleteStatement,codServicio);
  }
}