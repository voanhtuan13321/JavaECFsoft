package org.example.bai5;

/**
 * Person class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Person {
  // Họ tên, tuổi, số chứng minh nhân dân
  private String cmnd;
  private String name;
  private int age;

  public Person(String cmnd, String name, int age) {
    this.cmnd = cmnd;
    this.name = name;
    this.age = age;
  }

  public String getCmnd() {
    return cmnd;
  }

  public void setCmnd(String cmnd) {
    this.cmnd = cmnd;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "cmnd='" + cmnd + '\'' +
        ", name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
