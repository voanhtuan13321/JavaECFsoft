package bai4;

/**
 * Person class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class Person {
  //Họ tên, Tuổi, Nghề nghiệp, số chứng minh nhân dân
  private String cmnd;
  private String name;
  private int age;
  private String jobName;

  public Person(String cmnd, String name, int age, String jobName) {
    this.cmnd = cmnd;
    this.name = name;
    this.age = age;
    this.jobName = jobName;
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

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  @Override
  public String toString() {
    return "Person{" +
        "cmnd='" + cmnd + '\'' +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", jobName='" + jobName + '\'' +
        '}';
  }
}
