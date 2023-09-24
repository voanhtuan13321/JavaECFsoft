package org.example.common;

import org.example.bai13.exception.BirthdayException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Input class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class InputUtil {
  public static int inputInteger(String message) {
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

  public static Date inputDate(String message) throws BirthdayException {
    System.out.print(message);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String date = ScannerSingletonPattern.getInstance().nextLine();
    try {
      return simpleDateFormat.parse(date);
    } catch (ParseException e) {
      throw new BirthdayException(e.getMessage());
    }
  }
}
