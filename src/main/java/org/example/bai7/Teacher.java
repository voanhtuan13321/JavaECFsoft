package org.example.bai7;

/**
 * Teacher class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 14/09/2023
 */
public class Teacher extends Person {
  private String teacherCode;
  private double fixedSalary;
  private double bonus;
  private double fine;

  public Teacher() {
  }

  public Teacher(String name, int age, String address, String teacherCode, double fixedSalary, double bonus, double fine) {
    super(name, age, address);
    this.teacherCode = teacherCode;
    this.fixedSalary = fixedSalary;
    this.bonus = bonus;
    this.fine = fine;
  }

  public String getTeacherCode() {
    return teacherCode;
  }

  public void setTeacherCode(String teacherCode) {
    this.teacherCode = teacherCode;
  }

  public double getFixedSalary() {
    return fixedSalary;
  }

  public void setFixedSalary(double fixedSalary) {
    this.fixedSalary = fixedSalary;
  }

  public double getBonus() {
    return bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  public double getFine() {
    return fine;
  }

  public void setFine(double fine) {
    this.fine = fine;
  }

  @Override
  public String toString() {
    return "Teacher{" +
        "teacherCode='" + teacherCode + '\'' +
        ", fixedSalary=" + fixedSalary +
        ", bonus=" + bonus +
        ", fine=" + fine +
        super.toString() +
        '}';
  }

  public double getActualSalary() {
    return fixedSalary + bonus - fine;
  }
}
