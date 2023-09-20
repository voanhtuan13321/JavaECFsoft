package org.example.bai7;

/**
 * Student class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 14/09/2023
 */
public class Student extends Person {
  private String studentCode;

  public Student() {
  }

  public Student(String studentCode, String name, int age, String address) {
    super(name, age, address);
    this.studentCode = studentCode;
  }

  public String getStudentCode() {
    return studentCode;
  }

  public void setStudentCode(String studentCode) {
    this.studentCode = studentCode;
  }

  @Override
  public String toString() {
    return "Student{" +
        "studentCode='" + studentCode + '\'' +
        super.toString() +
        '}';
  }
}
