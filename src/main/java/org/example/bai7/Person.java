package org.example.bai7;

/**
 * Person class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 14/09/2023
 */
public class Person {
  private String name;
  private int age;
  private String address;

  public Person() {
  }

  public Person(String name, int age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address;
  }
}
