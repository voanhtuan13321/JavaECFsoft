package org.example.bai15.dao;

import org.example.bai15.Properties;
import org.example.bai15.model.AcademicResult;
import org.example.common.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 24/09/2023
 */
public class AcademicResultDao {
  private static AcademicResultDao instance = null;

  private AcademicResultDao() { }

  public static AcademicResultDao getInstance() {
    if (instance == null) {
      instance = new AcademicResultDao();
    }
    return instance;
  }

  public List<AcademicResult> getAcademicResultsForStudent(int id) {
    List<AcademicResult> academicResults = new ArrayList<>();
    String selectSQL = "SELECT * FROM AcademicResult WHERE student_id = ?";

    try (Connection conn = ConnectDB.getConnection(Properties.DB_NAME);
         PreparedStatement preparedStatement = conn.prepareStatement(selectSQL)) {
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      // Lặp qua kết quả và thêm thông tin học tập vào danh sách
      while (resultSet.next()) {
//        academicResult.setId(resultSet.getInt("id"));
//        academicResult.setStudentId(resultSet.getInt("student_id"));

        String semester = resultSet.getString("semester_name");
        double gpa = resultSet.getDouble("average_score");
        academicResults.add(new AcademicResult(semester, gpa));
      }
      resultSet.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return academicResults;
  }

  public void insertAcademicResult(AcademicResult academicResult, int studentId) throws SQLException {
    String sql = "INSERT INTO AcademicResult (student_id, semester_name, average_score) VALUES (?, ?, ?)";
    try (Connection conn = ConnectDB.getConnection(Properties.DB_NAME);
         PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

      preparedStatement.setInt(1, studentId);
      preparedStatement.setString(2, academicResult.getSemester());
      preparedStatement.setFloat(3, academicResult.getGpa());

      int rowsInserted = preparedStatement.executeUpdate();
      if (rowsInserted < 0) {
        throw new SQLException();
      }
    }
  }

}
