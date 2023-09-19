package bai14.model;

import bai14.exception.InvalidDOBException;
import bai14.exception.InvalidFullNameException;
import bai14.exception.InvalidPhoneNumberException;

/**
 * NormalStudent class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class NormalStudent extends Student {
  private int englishScore;
  private int entryTestScore;

  public NormalStudent(String fullName, String doB, String sex, String phoneNumber,
                       String universityName, String gradeLevel, int englishScore, int entryTestScore)
      throws InvalidFullNameException, InvalidDOBException, InvalidPhoneNumberException {
    super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
    setEnglishScore(englishScore);
    setEntryTestScore(entryTestScore);
  }

  public int getEnglishScore() {
    return englishScore;
  }

  public void setEnglishScore(int englishScore) {
    this.englishScore = englishScore;
  }

  public int getEntryTestScore() {
    return entryTestScore;
  }

  public void setEntryTestScore(int entryTestScore) {
    this.entryTestScore = entryTestScore;
  }

  // Override phương thức ShowMyInfo để hiển thị thông tin riêng của NormalStudent
  @Override
  public void ShowMyInfo() {
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
