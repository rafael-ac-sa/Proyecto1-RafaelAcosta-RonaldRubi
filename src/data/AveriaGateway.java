package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class AveriaGateway extends TableGateway {

  private final static String findStatement =
     "SELECT * FROM averia as a,estadoAveria as e WHERE a.codAveria =e.averia_codAveria and a.codAveria = ?";
	   
  public Map<String, Object> find(String codAveria) {
    List averias = jdbcTemplate.queryForList(findStatement,codAveria);
    return (Map<String, Object>)averias.get(0);
  }

  private final static String findAllStatement =
     "SELECT * FROM averia as a,estadoAveria as e WHERE a.codAveria =e.averia_codAveria";

  public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement =
    "INSERT INTO averia VALUES (?,?,?,?)";
  
  private static final String insertEstadoStatement =
    "INSERT INTO estadoAveria VALUES (?,?,?)";

  public int insert(String descripcion,String fecha,String servicio_codServicio,String estado) {
    java.lang.System.out.println("Estado: "+estado);
    Random generator = new Random();
    int id = -1;
    int idEst = -1;
	while (id <= 0 && idEst <= 0) {
		  id = generator.nextInt();
          idEst = generator.nextInt();
	}	
    String codAveria= id+"";
    String codEst= idEst+"";
    jdbcTemplate.update(insertStatement,codAveria,descripcion,fecha,servicio_codServicio);
    jdbcTemplate.update(insertEstadoStatement,codEst,estado,codAveria);
    return id;
  }

  private static final String updateStatement =
    "UPDATE averia SET descripcion = ?, fecha = ? WHERE codAveria = ?";

  public void update(String codAveria,String descripcion,String fecha) {
      jdbcTemplate.update(updateStatement,
         descripcion,fecha,codAveria);
  }

  private static final String deleteStatement =
    "DELETE FROM averia WHERE codAveria = ?";

  public void delete(String codAveria) {
      jdbcTemplate.update(deleteStatement,codAveria);
  }
}