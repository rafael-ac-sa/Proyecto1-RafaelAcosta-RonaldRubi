package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class SuscriptorGateway extends TableGateway {

  private final static String findStatement =
     "SELECT * "+
     "FROM suscriptor "+
     "WHERE idSuscriptor = ?";

  public Map<String, Object> find(String idSuscriptor) {
    List suscriptores = jdbcTemplate.queryForList(findStatement,idSuscriptor);
    return (Map<String, Object>)suscriptores.get(0);
  }

  private final static String findAllStatement =
     "SELECT * "+
     "FROM suscriptor ";

  public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement =
    "INSERT INTO suscriptor "+
  "VALUES (?,?,?,?,?)";

  public int insert(String nombre,String identificacion,String telefono,String direccion) {
    Random generator = new Random();
    int id = -1;
	while (id <= 0) {
	  id = generator.nextInt();
	}
	String idSuscriptor= id+"";
      jdbcTemplate.update(insertStatement,
         idSuscriptor,nombre,identificacion,telefono,direccion);
    return id;
  }

  private static final String updateStatement =
    "UPDATE suscriptor "+
    "SET nombre = ?, identificacion = ?, telefono = ?, "+
    "direccion = ? WHERE idSuscriptor = ?";

  public void update(String idSuscriptor,String nombre,String identificacion,String telefono,String direccion) {
      jdbcTemplate.update(updateStatement,
         nombre,identificacion,telefono,direccion,idSuscriptor);
  }

  private static final String deleteStatement =
    "DELETE FROM suscriptor "+
    "WHERE idSuscriptor = ?";

  public void delete(String idSuscriptor) {
      jdbcTemplate.update(deleteStatement,idSuscriptor);
  }
}