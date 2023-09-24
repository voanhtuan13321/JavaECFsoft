package org.example.bai15.model;

import org.example.bai13.exception.BirthdayException;
import org.example.common.InputUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Student  class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 21/09/2023
 */
public class RegularStudent implements CheckTypeStudentable {
  private String studentID;
  private String fullName;
  private Date dob;
  private int enrollmentYear;
  private double entranceScore;
  private List<AcademicResult> academicResults;

  public RegularStudent(String studentID, String fullName, Date dob, int enrollmentYear,
                        double entranceScore, List<AcademicResult> ademicResults) {
    this.studentID = studentID;
    this.fullName = fullName;
    this.dob = dob;
    this.enrollmentYear = enrollmentYear;
    this.entranceScore = entranceScore;
    this.academicResults = ademicResults;
  }

  public String getStudentID() {
    return studentID;
  }

  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public int getEnrollmentYear() {
    return enrollmentYear;
  }

  public void setEnrollmentYear(int enrollmentYear) {
    this.enrollmentYear = enrollmentYear;
  }

  public double getEntranceScore() {
    return entranceScore;
  }

  public void setEntranceScore(double entranceScore) {
    this.entranceScore = entranceScore;
  }

  public List<AcademicResult> getAcademicResults() {
    return academicResults;
  }

  public void setAcademicResults(List<AcademicResult> academicResults) {
    this.academicResults = academicResults;
  }

  @Override
  public String toString() {
    return "Student{" +
        "studentID='" + studentID + '\'' +
        ", fullName='" + fullName + '\'' +
        ", dob='" + dob + '\'' +
        ", enrollmentYear=" + enrollmentYear +
        ", entranceScore=" + entranceScore +
        ", academicResults=" + academicResults +
        '}';
  }

  public void input() {
    String fullName = InputUtil.inputString("enter full name: ");
    Date dob = null;
    while (true) {
      try {
        dob = InputUtil.inputDate("enter dob: ");
        break;
      } catch (BirthdayException e) {
        System.err.println(e.getMessage());
      }
    }
    int enrollmentYear = InputUtil.inputInteger("enter enrollment year: ");
    double entranceScore = InputUtil.inputDouble("enter entrance score: ");
    List<AcademicResult> academicResults = inputAcademicResults();

    this.fullName = fullName;
    this.dob = dob;
    this.enrollmentYear = enrollmentYear;
    this.entranceScore = entranceScore;
    this.academicResults = academicResults;
  }

  private List<AcademicResult> inputAcademicResults() {
    List<AcademicResult> results = new ArrayList<>();
    int size = InputUtil.inputInteger(">>> enter number of Academic results: ");
    for (int i = 1; i <= size; i++) {
      System.out.println("Academic results " + i);
      String semester = InputUtil.inputString("enter semester: ");
      double gpa = InputUtil.inputDouble("enter gpa: ");
      results.add(new AcademicResult(semester, gpa));
    }
    return results;
  }

  public void output() {
    System.out.println(this.toString());
  }

  @Override
  public boolean isRegularStudent() {
    return true;
  }
}
