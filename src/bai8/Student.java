package bai8;

/**
 * Student class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 14/09/2023
 */
public class Student {
  private String name;
  private int age;
  private String className;

  public Student() {
  }

  public Student(String name, int age, String className) {
    this.name = name;
    this.age = age;
    this.className = className;
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

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", className='" + className + '\'' +
        '}';
  }
}
