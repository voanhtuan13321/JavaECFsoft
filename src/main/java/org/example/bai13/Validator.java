package org.example.bai13;

import org.example.bai13.exception.BirthdayException;
import org.example.bai13.exception.EmailException;
import org.example.bai13.exception.FullNameException;
import org.example.bai13.exception.PhoneException;

/**
 * Validator class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class Validator {
  public static void fullName(String name) throws FullNameException {
    String regex = "^[A-Za-z\\s]+$";
    if(!name.matches(regex)) {
      throw new FullNameException("Tên không hợp lệ, vui lòng nhập lại");
    }
  }

  public static void birthDate(String birthDate) throws BirthdayException {
    String regex = "\\d{2}-\\d{2}-\\d{4}";
    if (!birthDate.matches(regex)) {
      throw new BirthdayException("Ngày sinh không hợp lệ, vui lòng nhập lại");
    }
  }

  public static void phoneNumber(String phoneNumber) throws PhoneException {
    String regex = "^\\d{10}$";
    if (!phoneNumber.matches(regex)) {
      throw new PhoneException("Số điện thoại không hợp lệ, vui lòng nhập lại");
    }
  }

  public static void email(String email) throws EmailException {
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    if (!email.matches(regex)) {
      throw new EmailException("Email không hợp lệ, vui lòng nhập lại");
    }
  }
}
