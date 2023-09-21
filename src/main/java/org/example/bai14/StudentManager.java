package org.example.bai14;

import org.example.bai14.exception.InvalidDOBException;
import org.example.bai14.exception.InvalidFullNameException;
import org.example.bai14.exception.InvalidPhoneNumberException;
import org.example.bai14.model.GoodStudent;
import org.example.bai14.model.NormalStudent;
import org.example.bai14.model.Student;
import org.example.common.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * StudentManager class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class StudentManager {
  public List<Student> getAllStudent() {
    List<Student> students = new ArrayList<>();
    Student student = null;
    try (Connection connection = ConnectDB.getConnection(Properties.DB_NAME);
         PreparedStatement preparedStatement
             = connection.prepareStatement(Properties.Query.SELECT_ALL);
         ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        int id = resultSet.getInt(Properties.ColumnNames.ID);
        String fullName = resultSet.getString(Properties.ColumnNames.FULL_NAME);
        java.util.Date dob = new java.util.Date(resultSet.getDate(Properties.ColumnNames.DOB).getTime());
        String sex = resultSet.getInt(Properties.ColumnNames.SEX) == 0 ? "Name" : "Nữ";
        String phoneNumber = resultSet.getString(Properties.ColumnNames.PHONE_NUMBER);
        String universityName = resultSet.getString(Properties.ColumnNames.UNIVERSITY_NAME);
        String gradeLevel = resultSet.getString(Properties.ColumnNames.GRADE_LEVEL);
        int type = resultSet.getInt(Properties.ColumnNames.TYPE);

        if (type == 0) {
          double gpa = resultSet.getDouble(Properties.ColumnNames.GPA);
          String bestRewardName = resultSet.getString(Properties.ColumnNames.BEST_REWARD_NAME);
          student = new GoodStudent(id, fullName, dob, sex, phoneNumber, universityName, gradeLevel,
              gpa, bestRewardName);
        } else {
          double englishScore = resultSet.getDouble(Properties.ColumnNames.ENGLISH_SCORE);
          double entryTestScore = resultSet.getDouble(Properties.ColumnNames.ENTRY_TEST_SCORE);
          student = new NormalStudent(id, fullName, dob, sex, phoneNumber, universityName,
              gradeLevel, englishScore, entryTestScore);
        }
        students.add(student);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return students;
  }

  public List<GoodStudent> getGoodStudents() {
    List<GoodStudent> students = new ArrayList<>();
    GoodStudent student = null;
    try (Connection connection = ConnectDB.getConnection(Properties.DB_NAME);
         PreparedStatement preparedStatement
             = connection.prepareStatement(Properties.Query.SELECT_GOOD);
         ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        int id = resultSet.getInt(Properties.ColumnNames.ID);
        String fullName = resultSet.getString(Properties.ColumnNames.FULL_NAME);
        java.util.Date dob = new java.util.Date(resultSet.getDate(Properties.ColumnNames.DOB).getTime());
        String sex = resultSet.getInt(Properties.ColumnNames.SEX) == 0 ? "Name" : "Nữ";
        String phoneNumber = resultSet.getString(Properties.ColumnNames.PHONE_NUMBER);
        String universityName = resultSet.getString(Properties.ColumnNames.UNIVERSITY_NAME);
        String gradeLevel = resultSet.getString(Properties.ColumnNames.GRADE_LEVEL);
        double gpa = resultSet.getDouble(Properties.ColumnNames.GPA);
        String bestRewardName = resultSet.getString(Properties.ColumnNames.BEST_REWARD_NAME);
        student = new GoodStudent(id, fullName, dob, sex, phoneNumber, universityName, gradeLevel,
            gpa, bestRewardName);

        students.add(student);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return students;
  }

  public List<NormalStudent> getNormalStudents() {
    List<NormalStudent> students = new ArrayList<>();
    NormalStudent student = null;
    try (Connection connection = ConnectDB.getConnection(Properties.DB_NAME);
         PreparedStatement preparedStatement
             = connection.prepareStatement(Properties.Query.SELECT_GOOD);
         ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        int id = resultSet.getInt(Properties.ColumnNames.ID);
        String fullName = resultSet.getString(Properties.ColumnNames.FULL_NAME);
        java.util.Date dob = new java.util.Date(resultSet.getDate(Properties.ColumnNames.DOB).getTime());
        String sex = resultSet.getInt(Properties.ColumnNames.SEX) == 0 ? "Name" : "Nữ";
        String phoneNumber = resultSet.getString(Properties.ColumnNames.PHONE_NUMBER);
        String universityName = resultSet.getString(Properties.ColumnNames.UNIVERSITY_NAME);
        String gradeLevel = resultSet.getString(Properties.ColumnNames.GRADE_LEVEL);
        double englishScore = resultSet.getDouble(Properties.ColumnNames.ENGLISH_SCORE);
        double entryTestScore = resultSet.getDouble(Properties.ColumnNames.ENTRY_TEST_SCORE);
        student = new NormalStudent(id, fullName, dob, sex, phoneNumber, universityName,
            gradeLevel, englishScore, entryTestScore);

        students.add(student);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return students;
  }

  public void addStudent(Student student, String type) {
    System.err.println(student);
    try (Connection connection = ConnectDB.getConnection(Properties.DB_NAME);
         PreparedStatement preparedStatement =
             connection.prepareStatement(Properties.Query.INSERT_STUDENT)) {

      preparedStatement.setString(1, student.getFullName());
      preparedStatement.setDate(2, new java.sql.Date(student.getDoB().getTime()));
      preparedStatement.setInt(3, "nam".equals(student.getSex().trim()) ? 0 : 1);
      preparedStatement.setString(4, student.getPhoneNumber());
      preparedStatement.setString(5, student.getUniversityName());
      preparedStatement.setString(6, student.getGradeLevel());
      preparedStatement.setInt(7, "good".equals(type.trim()) ? 0 : 1);

      if ("good".equalsIgnoreCase(type.trim())) {
        GoodStudent g = (GoodStudent) student;
        preparedStatement.setDouble(8, g.getGpa());
        preparedStatement.setString(9, g.getBestRewardName());
        preparedStatement.setDouble(10, 10);
        preparedStatement.setDouble(11, 0);
      } else {
        NormalStudent n = (NormalStudent) student;
        preparedStatement.setString(8, null);
        preparedStatement.setString(9, null);
        preparedStatement.setDouble(10, n.getEnglishScore());
        preparedStatement.setDouble(11, n.getEntryTestScore());
      }

      int rowsInserted = preparedStatement.executeUpdate();
      if (rowsInserted > 0) {
        System.out.println("Thêm bản ghi thành công!");
      } else {
        System.out.println("Không thể thêm bản ghi!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void selectCandidates(int numCandidatesToHire) {
    if (numCandidatesToHire < 11 || numCandidatesToHire > 15) {
      System.out.println("Nhập không hợp lệ, phải nhập trong khoản 11 đến 15");
      return;
    }

    if (numCandidatesToHire > getAllStudent().size()) {
      System.out.println("Số học sinh ít hơn số lượng bạn muốn chọn");
      return;
    }

    // Tạo danh sách riêng cho các sinh viên khá giỏi
    List<GoodStudent> goodStudents = getGoodStudents();

    // Sắp xếp danh sách sinh viên khá giỏi theo GPA và sau đó theo họ tên
    goodStudents.sort((s1, s2) -> {
      if (s1.getGpa() != s2.getGpa()) {
        return Double.compare(s2.getGpa(), s1.getGpa()); // Sắp xếp giảm dần theo GPA
      }
      return s1.getFullName().compareTo(s2.getFullName()); // Sắp xếp tăng dần theo họ tên
    });

    // Chọn các ứng viên khá giỏi cho công ty
    int numGoodCandidates = Math.min(numCandidatesToHire, goodStudents.size());
    System.out.println("Selected Good Students:");
    for (int i = 0; i < numGoodCandidates; i++) {
      GoodStudent selectedStudent = goodStudents.get(i);
      System.out.println("Name: " + selectedStudent.getFullName() + ", Phone: " + selectedStudent.getPhoneNumber());
    }

    // Kiểm tra xem còn cần tuyển thêm sinh viên trung bình không
    if (numCandidatesToHire > numGoodCandidates) {
      List<NormalStudent> normalStudents = getNormalStudents();

      // Sắp xếp danh sách sinh viên trung bình theo điểm thi đầu vào, TOEIC và sau đó theo họ tên
      normalStudents.sort((s1, s2) -> {
        if (s1.getEntryTestScore() != s2.getEntryTestScore()) {
          return Double.compare(s2.getEntryTestScore(), s1.getEntryTestScore()); // Sắp xếp giảm dần
          // theo điểm thi đầu vào
        }
        if (s1.getEnglishScore() != s2.getEnglishScore()) {
          return Double.compare(s2.getEnglishScore(), s1.getEnglishScore()); // Sắp xếp giảm dần theo
          // điểm TOEIC
        }
        return s1.getFullName().compareTo(s2.getFullName()); // Sắp xếp tăng dần theo họ tên
      });

      // Chọn các ứng viên trung bình cho công ty
      int numNormalCandidates = Math.min(numCandidatesToHire - numGoodCandidates, normalStudents.size());
      System.out.println("Selected Normal Students:");
      for (int i = 0; i < numNormalCandidates; i++) {
        NormalStudent selectedStudent = normalStudents.get(i);
        System.out.println("Name: " + selectedStudent.getFullName() + ", Phone: " + selectedStudent.getPhoneNumber());
      }
    }
  }

  public void showAllStudentsInfo() {
    List<Student> students = getAllStudent();

    System.out.println("All Students Info:");
    for (Student student : students) {
      System.out.println();
      student.ShowMyInfo();
    }
  }
}
