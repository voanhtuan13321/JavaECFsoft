package org.example.bai14;

import org.example.bai13.Validator;
import org.example.bai13.exception.BirthdayException;
import org.example.bai13.exception.PhoneException;
import org.example.bai14.model.GoodStudent;
import org.example.bai14.model.NormalStudent;
import org.example.common.InputUtil;

import java.util.Date;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class Main {
  public static void main(String[] args) {
    StudentManager studentManager = new StudentManager();

    while (true) {
      System.out.println("\n\n\nMenu:");
      System.out.println("1. Thêm sinh viên");
      System.out.println("2. Chọn ứng viên trúng tuyển");
      System.out.println("3. Hiển thị thông tin tất cả sinh viên");
      System.out.println("4. Thoát");
      int choice = InputUtil.inputNumber("Chọn tùy chọn (1-4): ");

      switch (choice) {
        case 1:
          String studentType = "";
          while (true) {
            studentType = InputUtil.inputString("Loại sinh viên (good/normal): ");
            if ("good".equalsIgnoreCase(studentType.trim())
                || "normal".equalsIgnoreCase(studentType.trim())) {
              break;
            } else {
              System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
          }
          String fullName = InputUtil.inputString("Họ tên: ");
          Date doB = null;
          while (true) {
            try {
              doB = InputUtil.inputDate("Ngày tháng năm sinh (dd/MM/yyyy): ");
              break;
            } catch (BirthdayException e) {
              System.err.println(e.getMessage());
            }
          }
          String sex = "";
          while (true) {
            sex = InputUtil.inputString("Giới tính (nam/nữ): ");
            if ("nam".equalsIgnoreCase(sex) || "nữ".equalsIgnoreCase(sex)) {
              break;
            } else {
              System.err.println("Nhập giới tính không hợp lệ, vui lòng nhập lại");
            }
          }
          String phoneNumber = "";
          while (true) {
            phoneNumber = InputUtil.inputString("Số điện thoại: ");
            try {
              Validator.phoneNumber(phoneNumber);
              break;
            } catch (PhoneException e) {
              System.err.println(e.getMessage());
            }
          }
          String universityName = InputUtil.inputString("Tên trường đã học: ");
          String gradeLevel = InputUtil.inputString("Xếp loại tốt nghiệp: ");

          if (studentType.equalsIgnoreCase("good")) {
            double gpa = 0;
            while (true) {
              gpa = InputUtil.inputDouble("Điểm GPA: ");
              if (gpa < 0 || gpa > 4) {
                System.err.println("Nhập gpa không hợp lệ, chỉ nhập trong khoản từ 0 -> 4");
              } else {
                break;
              }
            }
            String bestRewardName = InputUtil.inputString("Tên giải thưởng cao nhất: ");

            GoodStudent goodStudent = new GoodStudent(0, fullName, doB, sex, phoneNumber,
                universityName, gradeLevel, gpa, bestRewardName);
            studentManager.addStudent(goodStudent, studentType);
          } else if (studentType.equalsIgnoreCase("normal")) {
            int englishScore = InputUtil.inputNumber("Điểm TOEIC: ");
            int entryTestScore = InputUtil.inputNumber("Điểm thi đầu vào: ");

            NormalStudent normalStudent = new NormalStudent(0, fullName, doB, sex, phoneNumber,
                universityName, gradeLevel, englishScore, entryTestScore);
            studentManager.addStudent(normalStudent, studentType);
          } else {
            System.out.println("Loại sinh viên không hợp lệ.");
          }
          break;

        case 2:
          int numCandidatesToHire = InputUtil.inputNumber("Nhập số lượng ứng viên cần tuyển: ");
          studentManager.selectCandidates(numCandidatesToHire);
          break;

        case 3:
          studentManager.showAllStudentsInfo();
          break;

        case 4:
          System.out.println("Chương trình kết thúc.");
          System.exit(0);
          return;
        default:
          System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
      }
    }
  }
}
