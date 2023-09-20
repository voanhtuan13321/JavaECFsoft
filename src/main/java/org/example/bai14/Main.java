package org.example.bai14;

import org.example.bai14.exception.InvalidDOBException;
import org.example.bai14.exception.InvalidFullNameException;
import org.example.bai14.exception.InvalidPhoneNumberException;
import org.example.bai14.model.GoodStudent;
import org.example.bai14.model.NormalStudent;
import org.example.common.InputUtil;

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
      System.out.println("Menu:");
      System.out.println("1. Thêm sinh viên");
      System.out.println("2. Chọn ứng viên trúng tuyển");
      System.out.println("3. Hiển thị thông tin tất cả sinh viên");
      System.out.println("4. Thoát");
      int choice = InputUtil.inputNumber("Chọn tùy chọn (1-4): ");

      switch (choice) {
        case 1:
          String studentType = InputUtil.inputString("Loại sinh viên (Good/Normal): ");
          String fullName = InputUtil.inputString("Họ tên: ");
          String doB = InputUtil.inputString("Ngày tháng năm sinh (dd/MM/yyyy): ");
          String sex = InputUtil.inputString("Giới tính: ");
          String phoneNumber = InputUtil.inputString("Số điện thoại: ");
          String universityName = InputUtil.inputString("Tên trường đã học: ");
          String gradeLevel = InputUtil.inputString("Xếp loại tốt nghiệp: ");

          if (studentType.equalsIgnoreCase("Good")) {
            double gpa = InputUtil.inputDouble("Điểm GPA: ");
            String bestRewardName = InputUtil.inputString("Tên giải thưởng cao nhất: ");

            try {
              GoodStudent goodStudent
                  = new GoodStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, gpa, bestRewardName);
              studentManager.addStudent(goodStudent);
              System.out.println("Sinh viên khá giỏi đã được thêm.");
            } catch (InvalidFullNameException | InvalidDOBException | InvalidPhoneNumberException e) {
              System.err.println("Lỗi: " + e.getMessage());
            }
          } else if (studentType.equalsIgnoreCase("Normal")) {
            int englishScore = InputUtil.inputNumber("Điểm TOEIC: ");
            int entryTestScore = InputUtil.inputNumber("Điểm thi đầu vào: ");

            try {
              NormalStudent normalStudent
                  = new NormalStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, englishScore, entryTestScore);
              studentManager.addStudent(normalStudent);
              System.out.println("Sinh viên trung bình đã được thêm.");
            } catch (InvalidFullNameException | InvalidDOBException | InvalidPhoneNumberException e) {
              System.err.println("Lỗi: " + e.getMessage());
            }
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

        default:
          System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
      }
    }
  }
}
