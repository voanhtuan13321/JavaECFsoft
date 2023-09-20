package org.example.bai15.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Student class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class Student {
  private String studentID;
  private String fullName;
  private String dob;
  private int entranceYear;
  private double entranceScore;
  private List<Result> results;
  private boolean isFullTime;

  public Student(String studentID, String fullName, String dob, int entranceYear, double entranceScore, boolean isFullTime) {
    this.studentID = studentID;
    this.fullName = fullName;
    this.dob = dob;
    this.entranceYear = entranceYear;
    this.entranceScore = entranceScore;
    this.results = new ArrayList<>();
    this.isFullTime = isFullTime;
  }

  public double calculateGPA() {
    if (results.isEmpty()) {
      return 0.0;
    }
    double totalScore = 0.0;
    int totalCredits = 0;
    for (Result result : results) {
      totalScore += result.getAverageScore();
      totalCredits += result.getCredits();
    }
    return totalScore / totalCredits;
  }

  public boolean isFullTimeStudent() {
    return isFullTime;
  }

  public Result getLastSemesterGPA() {
    if (results.isEmpty()) {
      return null;
    }
    return results.get(results.size() - 1);
  }

  public String getStudentID() {
    return studentID;
  }

  public String getFullName() {
    return fullName;
  }

  public String getDob() {
    return dob;
  }

  public int getEntranceYear() {
    return entranceYear;
  }

  public double getEntranceScore() {
    return entranceScore;
  }

  public void addResult(Result result) {
    results.add(result);
  }

  @Override
  public String toString() {
    return "Student{" +
        "studentID='" + studentID + '\'' +
        ", fullName='" + fullName + '\'' +
        ", dob='" + dob + '\'' +
        ", entranceYear=" + entranceYear +
        ", entranceScore=" + entranceScore +
        ", results=" + results +
        ", isFullTime=" + isFullTime +
        '}';
  }
}
