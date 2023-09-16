package bai11;

import exam.InputUtil;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class Main {
  public static void main(String[] args) {
    ComplexNumber complexNumber = null;

    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. input a complex number");
      System.out.println("2. display a complex number");
      System.out.println("3. plus a complex number");
      System.out.println("4. multiply a complex number");
      System.out.println("5. stop");
      String choose = InputUtil.inputString(">>> input your choose: ");

      switch (choose) {
        case "1": {
          complexNumber = inputComplexNumber();
          break;
        }

        case "2": {
          if (complexNumber == null) {
            System.err.println("please enter a complex number");
          } else {
            System.out.println(complexNumber);
          }
          break;
        }

        case "3": {
          if (complexNumber == null) {
            System.err.println("please enter a complex number");
          } else {
            System.out.println(">>> input complex number you want to plus");
            ComplexNumber newComplexNumber = inputComplexNumber();
            System.out.println("result of plus: " + complexNumber.plus(newComplexNumber));
          }
          break;
        }

        case "4": {
          if (complexNumber == null) {
            System.err.println("please enter a complex number");
          } else {
            System.out.println(">>> input complex number you want to multiply");
            ComplexNumber newComplexNumber = inputComplexNumber();
            System.out.println("result of multiply: " + complexNumber.multiply(newComplexNumber));
          }
          break;
        }

        case "5": {
          return;
        }

        default:
          break;
      }
    }
  }

  private static ComplexNumber inputComplexNumber() {
    double real = InputUtil.inputDouble("real: ");
    double virtual = InputUtil.inputDouble("virtual: ");
    return new ComplexNumber(real, virtual);
  }
}
