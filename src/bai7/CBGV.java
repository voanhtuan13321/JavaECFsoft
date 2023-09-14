package bai7;

import java.util.List;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 14/09/2023
 */
public class CBGV {
  private Teacher teacher;
  private List<Student> students;

  public CBGV() {
  }

  public CBGV(Teacher teacher, List<Student> students) {
    this.teacher = teacher;
    this.students = students;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  @Override
  public String toString() {
    return "MyClass{" +
        ", teacher=" + teacher +
        ", students=" + students +
        '}';
  }
}
