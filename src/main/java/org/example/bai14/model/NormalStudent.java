package org.example.bai14.model;

import org.example.bai14.exception.InvalidDOBException;
import org.example.bai14.exception.InvalidFullNameException;
import org.example.bai14.exception.InvalidPhoneNumberException;

import java.util.Date;

/**
 * NormalStudent class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class NormalStudent extends Student {
  private double englishScore;
  private double entryTestScore;

  public NormalStudent(int id, String fullName, Date doB, String sex, String phoneNumber,
                       String universityName, String gradeLevel, double englishScore,
                       double entryTestScore) {
    super(id, fullName, doB, sex, phoneNumber, universityName, gradeLevel);
    this.englishScore = englishScore;
    this.entryTestScore = entryTestScore;
  }

  public double getEnglishScore() {
    return englishScore;
  }

  public void setEnglishScore(double englishScore) {
    this.englishScore = englishScore;
  }

  public double getEntryTestScore() {
    return entryTestScore;
  }

  public void setEntryTestScore(double entryTestScore) {
    this.entryTestScore = entryTestScore;
  }

  // Override phương thức ShowMyInfo để hiển thị thông tin riêng của NormalStudent
  @Override
  public void showMyInfo() {
    System.out.println("Full Name: " + getFullName());
    System.out.println("Date of Birth: " + getDoB());
    System.out.println("Sex: " + getSex());
    System.out.println("Phone Number: " + getPhoneNumber());
    System.out.println("University Name: " + getUniversityName());
    System.out.println("Grade Level: " + getGradeLevel());
    System.out.println("English Score: " + getEnglishScore());
    System.out.println("Entry Test Score: " + getEntryTestScore());
  }
}
