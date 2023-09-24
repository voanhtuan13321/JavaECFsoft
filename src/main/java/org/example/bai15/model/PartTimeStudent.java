package org.example.bai15.model;

import org.example.common.InputUtil;

import java.util.Date;
import java.util.List;

/**
 * PartTimeStudent  class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 21/09/2023
 */
public class PartTimeStudent extends RegularStudent {
  private String trainingLocation;

  public PartTimeStudent(String studentID, String fullName, Date dob, int enrollmentYear,
                         double entranceScore, List<AcademicResult> ademicResults,
                         String trainingLocation) {
    super(studentID, fullName, dob, enrollmentYear, entranceScore, ademicResults);
    this.trainingLocation = trainingLocation;
  }

  public String getTrainingLocation() {
    return trainingLocation;
  }

  public void setTrainingLocation(String trainingLocation) {
    this.trainingLocation = trainingLocation;
  }

  @Override
  public String toString() {
    return "PartTimeStudent{" +
        super.toString() + ", " +
        "trainingLocation='" + trainingLocation + '\'' +
        '}';
  }

  @Override
  public void output() {
    System.out.println(this.toString());
  }

  @Override
  public void input() {
    super.input();
    String trainingLocation = InputUtil.inputString("enter trainingLocation: ");
    this.trainingLocation = trainingLocation;
  }

  @Override
  public boolean isRegularStudent() {
    return false;
  }
}
