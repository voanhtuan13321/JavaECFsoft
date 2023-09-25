package org.example.bai15.dao;

import org.example.bai15.Properties;
import org.example.bai15.model.AcademicResult;
import org.example.bai15.model.PartTimeStudent;
import org.example.bai15.model.RegularStudent;
import org.example.common.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 23/09/2023
 */
public class StudentDao {
  private static StudentDao instance = null;

  private StudentDao() { }

  public static StudentDao getInstance() {
    if (instance == null) {
      instance = new StudentDao();
    }
    return instance;
  }

  public void insertStudent(RegularStudent student, int departmentId) {
    String insertSQL = "INSERT INTO Students (full_name, date_of_birth, enrollment_year," +
        " entry_score, student_type, training_location, department_id) VALUES (?, ?, ?, ?, ?, ?, ?);" +
        " SELECT SCOPE_IDENTITY()";
    try (Connection conn = ConnectDB.getConnection(Properties.DB_NAME);
         PreparedStatement preparedStatement = conn.prepareStatement(insertSQL)) {
      preparedStatement.setString(1, student.getFullName());
      preparedStatement.setDate(2, new java.sql.Date(student.getDob().getTime()));
      preparedStatement.setInt(3, student.getEnrollmentYear());
      preparedStatement.setFloat(4, (float) student.getEntranceScore());
      if (student instanceof PartTimeStudent) {
        preparedStatement.setString(5, "partTimeStudent");
        preparedStatement.setString(6, ((PartTimeStudent) student).getTrainingLocation());
      } else {
        preparedStatement.setString(5, "regularStudent");
        preparedStatement.setNull(6, Types.NULL);
      }
      preparedStatement.setInt(7, departmentId);
      preparedStatement.executeUpdate();
      ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
      int studentId;

      if (generatedKeys.next()) {
        studentId = generatedKeys.getInt(1);
      } else {
        studentId = 0;
      }

      student.getAcademicResults().forEach(result -> {
        try {
          AcademicResultDao.getInstance().insertAcademicResult(result, studentId);
        } catch (SQLException e) {
          e.printStackTrace();
        }
      });
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<RegularStudent> getAllStudent(int departmentId) {
    List<RegularStudent> students = new ArrayList<>();
    String selectSQL = "SELECT * FROM Students WHERE department_id = ?";
    try (Connection conn = ConnectDB.getConnection(Properties.DB_NAME);
         PreparedStatement preparedStatement = conn.prepareStatement(selectSQL)) {
      preparedStatement.setInt(1, departmentId);
      ResultSet resultSet = preparedStatement.executeQuery();

      // Lặp qua kết quả và thêm sinh viên vào danh sách
      while (resultSet.next()) {
        String id = resultSet.getString("id");
        String fullName = resultSet.getString("full_name");
        java.util.Date dob = resultSet.getDate("date_of_birth");
        int enrollmentYear = resultSet.getInt("enrollment_year");
        double entranceScore = resultSet.getDouble("entry_score");
        List<AcademicResult> academicResults = AcademicResultDao.getInstance()
            .getAcademicResultsForStudent(resultSet.getInt("id"));

        String type = resultSet.getString("student_type");
        if ("partTimeStudent".equalsIgnoreCase(type)) {
          String trainingLocation = resultSet.getString("training_location");
          students.add(new PartTimeStudent(id, fullName, dob, enrollmentYear, entranceScore,
              academicResults, trainingLocation));
        } else {
          students.add(new RegularStudent(id, fullName, dob, enrollmentYear, entranceScore,
              academicResults));
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return students;
  }

}