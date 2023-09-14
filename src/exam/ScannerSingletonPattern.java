package exam;

import java.util.Scanner;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 14/09/2023
 */
public class ScannerSingletonPattern {
  private static Scanner instance = null;

  // Private constructor to avoid client applications to use constructor
  private ScannerSingletonPattern() {

  }

  public static Scanner getInstance() {
    if (instance == null) {
      instance = new Scanner(System.in);
    }
    return instance;
  }
}
