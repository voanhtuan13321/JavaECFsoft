package org.example.bai15;

import org.example.bai13.exception.BirthdayException;
import org.example.bai15.dao.DepartmentDao;
import org.example.bai15.dao.StudentDao;
import org.example.bai15.model.AcademicResult;
import org.example.bai15.model.Department;
import org.example.bai15.model.PartTimeStudent;
import org.example.bai15.model.RegularStudent;
import org.example.common.InputUtil;

import java.sql.SQLException;
import java.util.*;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class Main {
  public static void main(String[] args) throws SQLException {
    while (true) {
      System.out.println("Chọn chức năng:");
      System.out.println("1. Nhập thông tin sinh viên");
      System.out.println("2. Xác định sinh viên chính quy");
      System.out.println("3. Lấy điểm trung bình theo học kỳ");
      System.out.println("4. Xác định tổng số sinh viên chính quy của khoa");
      System.out.println("5. Tìm sinh viên có điểm đầu vào cao nhất theo khoa");
      System.out.println("6. Danh sách sinh viên tại chức tại nơi liên kết đào tạo");
      System.out.println("7. Danh sách sinh viên có điểm trung bình >= 8.0");
      System.out.println("8. Sinh viên có điểm trung bình cao nhất");
      System.out.println("9. Sắp xếp danh sách sinh viên");
      System.out.println("10. Thống kê số lượng sinh viên theo năm vào học");
      System.out.println("0. Thoát");
      int choice = InputUtil.inputInteger("Nhâp lựa chọn: ");

      switch (choice) {
        case 1:
          int id = chooseDepartment();
          RegularStudent student = inputStudentInfo();
          StudentDao.getInstance().insertStudent(student, id);
          break;
        case 2:
          // Phương thức xác định sinh viên có phải là chính quy hay không
          // Gọi hàm để xác định
          break;
        case 3:
          // Phương thức lấy điểm trung bình theo học kỳ
          // Gọi hàm để lấy điểm trung bình
          String semester = InputUtil.inputString("semester: ");
          DepartmentDao.getInstance()
              .getAll()
              .forEach(dao -> dao.averageStudent(semester));
          break;
        case 4:
          // Phương thức xác định tổng số sinh viên chính quy của khoa
          // Gọi hàm để xác định
          DepartmentDao.getInstance()
              .getAll()
              .forEach(dao -> System.out.println("Khoa: " + dao.getDepartmentName() +
                  ", so luong: " + dao.countRegularStudents()));
          break;
        case 5:
          // Tìm sinh viên có điểm đầu vào cao nhất theo khoa
          // Gọi hàm để tìm
          DepartmentDao.getInstance()
              .getAll()
              .forEach(dao -> {
                RegularStudent student1 = dao.findStudentWithHighestEntranceScore();
                System.out.println("Khoa: " + dao.getDepartmentName() +
                    ", sinh vien: " + student1.getFullName());
              });
          break;
        case 6:
          // Danh sách sinh viên tại chức tại nơi liên kết đào tạo
          // Gọi hàm để lấy danh sách
          DepartmentDao.getInstance()
              .getAll()
              .forEach(dep -> {
                String location = InputUtil.inputString(">>> khoa: " + dep.getDepartmentName() + ", location: ");
                dep.findPartTimeStudentsByLocation(location)
                    .forEach(PartTimeStudent::output);
              });
          break;
        case 7:
          // Danh sách sinh viên có điểm trung bình >= 8.0
          // Gọi hàm để lấy danh sách
          DepartmentDao.getInstance()
              .getAll()
              .forEach(dep -> {
                System.out.println(">>> khoa: " + dep.getDepartmentName());
                dep.findStudentsWithHighGpa()
                    .forEach(RegularStudent::output);
              });
          break;
        case 8:
          // Sinh viên có điểm trung bình cao nhất
          // Gọi hàm để tìm
          DepartmentDao.getInstance()
              .getAll()
              .forEach(dep -> {
                System.out.println(">>> khoa: " + dep.getDepartmentName());
                RegularStudent student1 = dep.findStudentWithHighestGpa();
                student1.output();
              });
          break;
        case 9:
          // Sắp xếp danh sách sinh viên
          // Gọi hàm để sắp xếp
          DepartmentDao.getInstance()
              .getAll()
              .forEach(dep -> dep.getStudents()
                  .sort((student1, student2) -> Integer.compare(student2.getEnrollmentYear(), student1.getEnrollmentYear())));
          break;
        case 10:
          // Thống kê số lượng sinh viên theo năm vào học
          // Gọi hàm để thống kê
          DepartmentDao.getInstance()
              .getAll()
              .forEach(dep -> {
                System.out.println("khoa: " + dep.getDepartmentName());
                Map<Integer, Long> result = dep.countStudentsByEnrollmentYear();
                for (Map.Entry<Integer, Long> entry : result.entrySet()) {
                  System.out.println(entry.getKey() + ": " + entry.getValue());
                }
              });
          break;
        case 0:
          System.out.println("Kết thúc chương trình.");
          return;
        default:
          System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
      }
    }
  }

  private static int chooseDepartment() {
    List<Department> departments = DepartmentDao.getInstance().getAll();
    departments.forEach(System.out::println);
    int id = -1;
    while (true) {
      id = InputUtil.inputInteger(">>> chọn id khoa: ");
      int finalId = id;
      if (departments.stream().anyMatch(dep -> dep.getId() == finalId)) {
        return finalId;
      } else {
        System.err.println("chọn id không hợp lệ, vui lòng nhập lại");
      }
    }
  }

  public static RegularStudent inputStudentInfo() {
    System.out.println(">>> Nhập thông tin sinh viên:");
    String type = InputUtil.inputString("Student type: ");
    String fullName = InputUtil.inputString("Full Name: ");
    Date dob = null;
    try {
      dob = InputUtil.inputDate("Date of bith (dd/MM/yyyy): ");
    } catch (BirthdayException e) {
      throw new RuntimeException(e);
    }
    int enrollmentYear = InputUtil.inputInteger("Enrollment Year: ");
    double entranceScore = InputUtil.inputDouble("Entrance Score: ");
    String trainingLocation = "";

    if ("partTimeStudent".equalsIgnoreCase(type)) {
      trainingLocation = InputUtil.inputString("traning location: ");
    }
    int numOfResults = InputUtil.inputInteger(">>> Number of results: ");
    List<AcademicResult> academicResults = inputAcademicResults(numOfResults);

    return "partTimeStudent".equalsIgnoreCase(type)
        ? new RegularStudent("", fullName, dob, enrollmentYear, entranceScore, academicResults)
        : new PartTimeStudent("", fullName, dob, enrollmentYear, entranceScore, academicResults, trainingLocation);
  }

  private static List<AcademicResult> inputAcademicResults(int numOfResults) {
    List<AcademicResult> ademicResults = new ArrayList<>();
    for (int i = 1; i <= numOfResults; i++) {
      String semester = InputUtil.inputString("semester: ");
      double gpa = InputUtil.inputDouble("gpa: ");
      ademicResults.add(new AcademicResult(semester, gpa));
    }
    return ademicResults;
  }
}
