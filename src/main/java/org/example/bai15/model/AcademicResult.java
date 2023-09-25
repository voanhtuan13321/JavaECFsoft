package org.example.bai15.model;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 21/09/2023
 */
public class AcademicResult {
  private String semester;
  private double gpa;

  public AcademicResult(String semester, double gpa) {
    this.semester = semester;
    this.gpa = gpa;
  }

  public String getSemester() {
    return semester;
  }

  public float getGpa() {
    return (float) gpa;
  }

  @Override
  public String toString() {
    return "AcademicResult{" +
        "semester='" + semester + '\'' +
        ", gpa=" + gpa +
        '}';
  }
}
