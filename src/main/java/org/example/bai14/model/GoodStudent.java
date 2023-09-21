package org.example.bai14.model;

import org.example.bai14.exception.InvalidDOBException;
import org.example.bai14.exception.InvalidFullNameException;
import org.example.bai14.exception.InvalidPhoneNumberException;

import java.util.Date;

/**
 * GoodStudent class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class GoodStudent extends Student {
  private double gpa;
  private String bestRewardName;

  public GoodStudent(int id, String fullName, Date doB, String sex, String phoneNumber,
                     String universityName, String gradeLevel, double gpa, String bestRewardName) {
    super(id, fullName, doB, sex, phoneNumber, universityName, gradeLevel);
    this.gpa = gpa;
    this.bestRewardName = bestRewardName;
  }

  // Getter và setter cho các thuộc tính riêng của GoodStudent

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    this.gpa = gpa;
  }

  public String getBestRewardName() {
    return bestRewardName;
  }

  public void setBestRewardName(String bestRewardName) {
    this.bestRewardName = bestRewardName;
  }

  // Override phương thức ShowMyInfo để hiển thị thông tin riêng của GoodStudent
  @Override
  public void showMyInfo() {
    System.out.println("Full Name: " + getFullName());
    System.out.println("Date of Birth: " + getDoB());
    System.out.println("Sex: " + getSex());
    System.out.println("Phone Number: " + getPhoneNumber());
    System.out.println("University Name: " + getUniversityName());
    System.out.println("Grade Level: " + getGradeLevel());
    System.out.println("GPA: " + getGpa());
    System.out.println("Best Reward Name: " + getBestRewardName());
  }
}
