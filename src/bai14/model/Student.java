package bai14.model;

import bai14.exception.InvalidDOBException;
import bai14.exception.InvalidFullNameException;
import bai14.exception.InvalidPhoneNumberException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Student class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public abstract class Student {
  private String fullName;
  private Date doB;
  private String sex;
  private String phoneNumber;
  private String universityName;
  private String gradeLevel;

  public Student(String fullName, String doB, String sex, String phoneNumber, String universityName,
                 String gradeLevel) throws InvalidFullNameException, InvalidDOBException,
      InvalidPhoneNumberException {
    setFullName(fullName);
    setDoB(doB);
    setSex(sex);
    setPhoneNumber(phoneNumber);
    setUniversityName(universityName);
    setGradeLevel(gradeLevel);
  }

  // Getter và setter cho các thuộc tính

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) throws InvalidFullNameException {
    if (fullName.length() < 10 || fullName.length() > 50) {
      throw new InvalidFullNameException("Invalid full name");
    }
    this.fullName = fullName;
  }

  public Date getDoB() {
    return doB;
  }

  public void setDoB(String doB) throws InvalidDOBException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    try {
      this.doB = sdf.parse(doB);
    } catch (ParseException e) {
      throw new InvalidDOBException("Invalid date of birth format");
    }
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
    if (!phoneNumber.matches("(090|098|091|031|035|038)\\d{7}")) {
      throw new InvalidPhoneNumberException("Invalid phone number");
    }
    this.phoneNumber = phoneNumber;
  }

  public String getUniversityName() {
    return universityName;
  }

  public void setUniversityName(String universityName) {
    this.universityName = universityName;
  }

  public String getGradeLevel() {
    return gradeLevel;
  }

  public void setGradeLevel(String gradeLevel) {
    this.gradeLevel = gradeLevel;
  }

  // Phương thức trừu tượng ShowMyInfo
  public abstract void ShowMyInfo();
}
