package org.example.common;

import java.sql.Connection;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 20/09/2023
 */
public class Main {
  public static void main(String[] args) {
    Connection conn = ConnectDB.getConnection("ec_java_bai14");
  }
}
