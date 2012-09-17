package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegionGateway extends TableGateway {

   private final static String findAllStatement =
     "SELECT * "+
     "FROM region ";

  public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

}