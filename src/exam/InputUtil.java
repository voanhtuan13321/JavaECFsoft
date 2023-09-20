package exam;

/**
 * Input class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class InputUtil {

  public static int inputNumber(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Integer.parseInt(ScannerSingletonPattern.getInstance().nextLine());
      } catch (NumberFormatException ex) {
        System.err.println("input invalid number, please enter again");
      }
    }
  }

  public static String inputString(String message) {
    System.out.print(message);
    return ScannerSingletonPattern.getInstance().nextLine();
  }

  public static double inputDouble(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Double.parseDouble(ScannerSingletonPattern.getInstance().nextLine());
      } catch (NumberFormatException ex) {
        System.err.println("input invalid number, please enter again");
      }
    }
  }

  public static boolean inputBoolean(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Boolean.getBoolean(ScannerSingletonPattern.getInstance().nextLine());
      } catch (NumberFormatException ex) {
        System.err.println("input invalid boolean, please enter again");
      }
    }
  }
}
