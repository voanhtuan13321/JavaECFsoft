package org.example.bai1;

/**
 * Officer class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class Officer {
  // Họ tên, tuổi, giới tính(name, nữ, khác), địa chỉ.
  private String fullName;
  private int age;
  private Sex sex;
  private String address;

  public Officer() {}

  public Officer(String fullName, int age, Sex sex, String address) {
    this.fullName = fullName;
    this.age = age;
    this.sex = sex;
    this.address = address;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Officer{" +
        "fullName='" + fullName + '\'' +
        ", age=" + age +
        ", sex=" + sex +
        ", address='" + address + '\'' +
        '}';
  }
}
