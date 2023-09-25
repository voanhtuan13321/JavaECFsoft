package org.example.bai15.dao;

import org.example.bai15.Properties;
import org.example.bai15.model.Department;
import org.example.bai15.model.RegularStudent;
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
public class DepartmentDao {
  private static DepartmentDao instance = null;

  private DepartmentDao() {}
  public static DepartmentDao getInstance() {
    if (instance == null) {
      instance = new DepartmentDao();
    }
    return instance;
  }

  public List<Department> getAll() {
    List<Department> departments = new ArrayList<>();
    String selectSQL = "SELECT * FROM Departments";
    try (Connection conn = ConnectDB.getConnection(Properties.DB_NAME);
         PreparedStatement preparedStatement = conn.prepareStatement(selectSQL)) {
      ResultSet resultSet = preparedStatement.executeQuery();

      // Lặp qua kết quả và thêm thông tin phòng ban vào danh sách
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("department_name");
        List<RegularStudent> students = StudentDao.getInstance().getAllStudent(id);
        departments.add(new Department(id, name, students));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return departments;
  }
}
