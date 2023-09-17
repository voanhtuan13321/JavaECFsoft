package bai4;

import exam.InputUtil;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class Main {
  private static final Town town = new Town();

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. add family");
      System.out.println("2. display information family");
      System.out.println("5. stop");
      String choose = InputUtil.inputString(">>> input your choose: ");

      switch (choose) {
        case "1": {
          int numOfFamilies = InputUtil.inputNumber("numOfFamilies: ");
          town.addFamily(numOfFamilies);
          break;
        }

        case "2": {
          town.showInformationFamilies();
          break;
        }

        case "3": {
          return;
        }

        default:
          break;
      }
    }
  }
}
