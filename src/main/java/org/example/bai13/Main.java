package org.example.bai13;

import exam.InputUtil;
import org.example.bai13.exception.BirthdayException;
import org.example.bai13.exception.EmailException;
import org.example.bai13.exception.FullNameException;
import org.example.bai13.exception.PhoneException;
import org.example.bai13.model.Employee;
import org.example.bai13.model.Experience;
import org.example.bai13.model.Fresher;
import org.example.bai13.model.Intern;

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
      System.out.println("\n\n\nChọn chức năng:");
      System.out.println("1. Thêm nhân viên");
      System.out.println("2. Sửa thông tin nhân viên");
      System.out.println("3. Xóa nhân viên");
      System.out.println("4. Hiển thị danh sách nhân viên");
      System.out.println("5. Tìm tất cả nhân viên Intern");
      System.out.println("6. Tìm tất cả nhân viên Experience");
      System.out.println("7. Tìm tất cả nhân viên Fresher");
      System.out.println("8. Thoát");
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
          if (employeeManager.removeEmployee(employeeIDToRemove)) {
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
          employeeManager.findAllInterns().forEach(System.out::println);
          break;
        case 6:
          employeeManager.findAllExperience().forEach(System.out::println);
          break;
        case 7:
          employeeManager.findAllFresher().forEach(System.out::println);
          break;
        case 8:
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
      try {
        fullName = InputUtil.inputString("Nhập tên: ");
        Validator.fullName(fullName);
        break;
      } catch (FullNameException e) {
        System.err.println(e.getMessage());
      }
    }
    String birthDay = "";
    while (true) {
      try {
        birthDay = InputUtil.inputString("Nhập ngày sinh (dd-MM-yyyy): ");
        Validator.birthDate(birthDay);
        break;
      } catch (BirthdayException e) {
        System.err.println(e.getMessage());
      }
    }
    String phone = "";
    while (true) {
      try {
        phone = InputUtil.inputString("Nhập số điện thoại (10 số): ");
        Validator.phoneNumber(phone);
        break;
      } catch (PhoneException e) {
        System.err.println(e.getMessage());
      }
    }
    String email = "";
    while (true) {
      try {
        email = InputUtil.inputString("Nhập email: ");
        Validator.email(email);
        break;
      } catch (EmailException e) {
        System.err.println(e.getMessage());
      }
    }

    if (employeeType == 0) {
      int expInYear = InputUtil.inputNumber("Nhập số năm kinh nghiệm: ");
      String proSkill = InputUtil.inputString("Nhập kỹ năng chuyên môn: ");

      employee = new Experience(fullName, birthDay, phone, email, expInYear, proSkill);
    } else if (employeeType == 1) {
      String graduationDate = "";
      while (true) {
        try {
          graduationDate = InputUtil.inputString("Nhập ngày tốt nghiệp: ");
          Validator.birthDate(graduationDate);
          break;
        } catch (BirthdayException e) {
          System.err.println(e.getMessage());
        }
      }
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

}
