package org.example.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 24/09/2023
 */
public class ConnectionSigletonPattern {
  private static Connection instance = null;
  private static final String USERNAME = "sa";
  private static final String PASSWORD = "123456";

  private ConnectionSigletonPattern() {}

  public static Connection getInstance(String dbName) throws SQLException {
    if (instance == null) {
      String connectionURL = "jdbc:sqlserver://ANHTUAN\\TUANEXPRESS:1433;databaseName="
          + dbName + ";trustServerCertificate=true;encrypt=true;";
      instance = DriverManager.getConnection(connectionURL, USERNAME, PASSWORD);
    }
    return instance;
  }
}
