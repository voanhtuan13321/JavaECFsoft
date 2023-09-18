package bai13.model;

import bai13.model.Certificate;
import bai13.model.Employee;

/**
 * Fresher  class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Fresher extends Employee {
  private String graduationDate;
  private String graduationRank;
  private String education;

  public Fresher(String fullName, String birthDay, String phone, String email, String graduationDate, String graduationRank, String education) {
    super(fullName, birthDay, phone, email, 1); // 1 corresponds to Fresher
    this.graduationDate = graduationDate;
    this.graduationRank = graduationRank;
    this.education = education;
  }

  public String getGraduationDate() {
    return graduationDate;
  }

  public void setGraduationDate(String graduationDate) {
    this.graduationDate = graduationDate;
  }

  public String getGraduationRank() {
    return graduationRank;
  }

  public void setGraduationRank(String graduationRank) {
    this.graduationRank = graduationRank;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  @Override
  public String toString() {
    return "Fresher{" +
        super.toString() + ", " +
        "graduationDate='" + graduationDate + '\'' +
        ", graduationRank='" + graduationRank + '\'' +
        ", education='" + education + '\'' +
        '}';
  }

  @Override
  public void showInfo() {
    System.out.println("Employee Type: Fresher");
    System.out.println("ID: " + getID());
    System.out.println("Full Name: " + getFullName());
    // Add more specific info for Fresher employees
    System.out.println("Graduation Date: " + graduationDate);
    System.out.println("Graduation Rank: " + graduationRank);
    System.out.println("Education: " + education);
    // Print certificates
    for (Certificate certificate : getCertificates()) {
      System.out.println("Certificate: " + certificate.getCertificateName());
    }
  }
}
