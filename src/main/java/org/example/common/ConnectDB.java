package org.example.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectDB class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 20/09/2023
 */
public class ConnectDB {
  private static final String USERNAME = "sa";
  private static final String PASSWORD = "123456";

  public static Connection getConnection(final String dbName) {
    Connection conn = null;
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      String connectionURL = "jdbc:sqlserver://ANHTUAN\\TUANEXPRESS:1433;databaseName="
          + dbName + ";trustServerCertificate=true;encrypt=true;";
      conn = DriverManager.getConnection(connectionURL, USERNAME, PASSWORD);
      System.out.println("Ket noi thanh cong!");
      return conn;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void closeConnection(AutoCloseable... autoCloseables) {
    for (AutoCloseable closeable : autoCloseables) {
      try {
        if (closeable != null) {
          closeable.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
