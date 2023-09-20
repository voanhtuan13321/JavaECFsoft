package org.example.bai15.model;

/**
 * Result class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class Result {
  private String semester;
  private double averageScore;
  private int credits;

  public Result(String semester, double averageScore, int credits) {
    this.semester = semester;
    this.averageScore = averageScore;
    this.credits = credits;
  }

  public String getSemester() {
    return semester;
  }

  public double getAverageScore() {
    return averageScore;
  }

  public int getCredits() {
    return credits;
  }
}
