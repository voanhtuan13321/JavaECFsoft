package bai13;

import bai13.model.Employee;
import bai13.model.Experience;
import bai13.model.Fresher;
import bai13.model.Intern;
import exam.InputUtil;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Main {
  public static void main(String[] args) {
    EmployeeManager employeeManager = new EmployeeManager();

    while (true) {
      System.out.println("Chọn chức năng:");
      System.out.println("1. Thêm nhân viên");
      System.out.println("2. Sửa thông tin nhân viên");
      System.out.println("3. Xóa nhân viên");
      System.out.println("4. Hiển thị danh sách nhân viên");
      System.out.println("5. Thoát");
      int choice = InputUtil.inputNumber("Nhập lựa chọn của bạn: ");

      switch (choice) {
        case 1:
          // Thêm nhân viên
          Employee newEmployee = inputEmployee();
          employeeManager.addEmployee(newEmployee);
          break;
        case 2:
          // Sửa thông tin nhân viên
          int employeeIDToEdit = InputUtil.inputNumber("Nhập ID nhân viên cần sửa: ");

          // Kiểm tra xem nhân viên có tồn tại không
          Employee existingEmployee = employeeManager.findEmployeeByID(employeeIDToEdit);
          if (existingEmployee != null) {
            System.out.println("Nhập thông tin mới:");
            Employee updateEmployee = inputEmployee();
            employeeManager.editEmployee(employeeIDToEdit, updateEmployee);
          } else {
            System.out.println("Không tìm thấy nhân viên có ID tương ứng.");
          }
          break;
        case 3:
          // Xóa nhân viên
          int employeeIDToRemove = InputUtil.inputNumber("Nhập ID nhân viên cần xóa: ");

          // Kiểm tra xem nhân viên có tồn tại không
          Employee employeeToRemove = employeeManager.findEmployeeByID(employeeIDToRemove);
          if (employeeToRemove != null) {
            employeeManager.removeEmployee(employeeIDToRemove);
            System.out.println("Xóa nhân viên thành công.");
          } else {
            System.out.println("Không tìm thấy nhân viên có ID tương ứng.");
          }
          break;
        case 4:
          // Hiển thị danh sách nhân viên
          employeeManager.showAllEmployees();
          break;
        case 5:
          // Thoát chương trình
          return;
        default:
          System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
      }
    }
  }

  private static Employee inputEmployee() {
    Employee employee = null;
    int employeeType = -1;
    while (true) {
      employeeType
          = InputUtil.inputNumber("Chọn loại nhân viên (0: Experience, 1: Fresher, 2: Intern): ");
      if (employeeType < 0 || employeeType > 2) {
        System.err.println("Chọn không hợp lệ, vui lòng chọn lại");
      } else {
        break;
      }
    }

    String fullName = "";
    while (true) {
      fullName = InputUtil.inputString("Nhập tên: ");
      if (isValidName(fullName)) {
        break;
      } else {
        System.err.println("Tên không hợp lệ, vui lòng nhập lại");
      }
    }
    String birthDay = "";
    while (true) {
      birthDay = InputUtil.inputString("Nhập ngày sinh (dd-MM-yyyy): ");
      if (isValidDateOfBirth(birthDay)) {
        break;
      } else {
        System.err.println("Ngày sinh không hợp lệ, vui lòng nhập lại");
      }
    }
    String phone = "";
    while (true) {
      phone = InputUtil.inputString("Nhập số điện thoại (10 số): ");
      if (isValidPhoneNumber(phone)) {
        break;
      } else {
        System.err.println("Số điện thoại không hợp lệ, vui lòng nhập lại");
      }
    }
    String email = "";
    while (true) {
      email = InputUtil.inputString("Nhập email: ");
      if (isValidEmail(email)) {
        break;
      } else {
        System.err.println("Email không hợp lệ, vui lòng nhập lại");
      }
    }

    if (employeeType == 0) {
      int expInYear = InputUtil.inputNumber("Nhập số năm kinh nghiệm: ");
      String proSkill = InputUtil.inputString("Nhập kỹ năng chuyên môn: ");

      employee = new Experience(fullName, birthDay, phone, email, expInYear, proSkill);
    } else if (employeeType == 1) {
      String graduationDate = InputUtil.inputString("Nhập ngày tốt nghiệp: ");
      String graduationRank = InputUtil.inputString("Nhập xếp loại tốt nghiệp: ");
      String education = InputUtil.inputString("Nhập trường tốt nghiệp: ");

      employee = new Fresher(fullName, birthDay, phone, email, graduationDate, graduationRank, education);
    } else {
      String majors = InputUtil.inputString("Nhập chuyên ngành đang học: ");
      String semester = InputUtil.inputString("Nhập học kì đang học: ");
      String universityName = InputUtil.inputString("Nhập tên trường đang học: ");

      employee = new Intern(fullName, birthDay, phone, email, majors, semester, universityName);
    }

    return employee;
  }

  public static boolean isValidDateOfBirth(String dateOfBirth) {
    // Ví dụ: dd-MM-yyyy
    String regex = "\\d{2}-\\d{2}-\\d{4}";
    return dateOfBirth.matches(regex);
  }

  public static boolean isValidEmail(String email) {
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    return email.matches(regex);
  }

  public static boolean isValidName(String name) {
    String regex = "^[A-Za-z\\s]+$";
    return name.matches(regex);
  }

  public static boolean isValidPhoneNumber(String phoneNumber) {
    String regex = "^\\d{10}$";
    return phoneNumber.matches(regex);
  }

}
