package org.example.bai1;

/**
 * employee class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class Employee extends Officer {
  private String workName;

  public Employee(String fullName, int age, Sex sex, String address, String workName) {
    super(fullName, age, sex, address);
    this.workName = workName;
  }

  public String getWorkName() {
    return workName;
  }

  public void setWorkName(String workName) {
    this.workName = workName;
  }

  @Override
  public String toString() {
    return "Employee{" +
        super.toString() + ", " +
        "workName='" + workName + '\'' +
        '}';
  }
}
