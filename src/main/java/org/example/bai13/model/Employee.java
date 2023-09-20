package org.example.bai13.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public abstract class Employee {
  private int id;
  private String fullName;
  private String birthDay;
  private String phone;
  private String email;
  private int employeeType;
  private static int employeeCount = 0;
  private List<Certificate> certificates;

  public Employee(String fullName, String birthDay, String phone, String email, int employeeType) {
    this.id = ++employeeCount;
    this.fullName = fullName;
    this.birthDay = birthDay;
    this.phone = phone;
    this.email = email;
    this.employeeType = employeeType;
    this.certificates = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(String birthDay) {
    this.birthDay = birthDay;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getEmployeeType() {
    return employeeType;
  }

  public void setEmployeeType(int employeeType) {
    this.employeeType = employeeType;
  }

  public static int getEmployeeCount() {
    return employeeCount;
  }

  public static void setEmployeeCount(int employeeCount) {
    Employee.employeeCount = employeeCount;
  }

  public List<Certificate> getCertificates() {
    return certificates;
  }

  public void setCertificates(List<Certificate> certificates) {
    this.certificates = certificates;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "ID=" + id +
        ", fullName='" + fullName + '\'' +
        ", birthDay='" + birthDay + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        ", employeeType=" + employeeType +
        ", certificates=" + certificates +
        '}';
  }

  public abstract void showInfo();
}
