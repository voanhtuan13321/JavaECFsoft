package bai7;

import exam.ScannerSingletonPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 14/09/2023
 */
public class Main {
  public static void main(String[] args) {
    List<CBGV> cbgvs = new ArrayList<>();

    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. add new teacher");
      System.out.println("2. show list students by teacherCode");
      System.out.println("3. remove teacher by teacherCode");
      System.out.println("4. calculate ActualSalary of teacher");
      System.out.println("5. stop");
      System.out.print(">>> input your choose: ");
      String choose = ScannerSingletonPattern.getInstance().nextLine();

      switch (choose) {
        case "1": {
          addNewTeacher(cbgvs);
          break;
        }

        case "2": {
          System.out.print(">>> input teacherCode: ");
          String teacherCode = ScannerSingletonPattern.getInstance().nextLine();
          showListStudentByTeacherCode(cbgvs, teacherCode);
          break;
        }

        case "3": {
          System.out.print(">>> input teacherCode: ");
          String teacherCode = ScannerSingletonPattern.getInstance().nextLine();
          removeTeacherByTeacherCode(cbgvs, teacherCode);
          break;
        }

        case "4": {
          showActualSalaryOfTeacher(cbgvs);
          break;
        }

        case "5": {
          System.out.println("Stop");
          return;
        }

        default:
          break;
      }
    }
  }

  private static void showActualSalaryOfTeacher(List<CBGV> cbgvs) {
    cbgvs.forEach(cbgv -> {
      Teacher teacher = cbgv.getTeacher();
      System.out.println("Teacher: { name: " + teacher.getName() + ", actual salary: " + teacher.getActualSalary() + "}");
    });
  }

  private static void removeTeacherByTeacherCode(List<CBGV> cbgvs, String teacherCode) {
    int index = findTeacherByTeacherCode(cbgvs, teacherCode);

    if (index == -1) {
      System.err.println("don't find any teacher have code: " + teacherCode);
    } else {
      cbgvs.remove(index);
      System.out.println("Removed " + teacherCode + " successfully");
    }
  }

  private static int findTeacherByTeacherCode(List<CBGV> cbgvs, String teacherCode) {
    int length = cbgvs.size();
    for (int i = 0; i < length; i++) {
      if (cbgvs.get(i).getTeacher().getTeacherCode().equals(teacherCode)) {
        return i;
      }
    }
    return -1;
  }

  private static void showListStudentByTeacherCode(List<CBGV> cbgvs, String teacherCode) {
    List<CBGV> resultList = cbgvs.stream().filter(cbgv -> cbgv.getTeacher().getTeacherCode().equals(teacherCode)).collect(Collectors.toList());

    if (resultList.size() == 0) {
      System.err.println("Don't find any teacher have teacherCode=" + teacherCode);
    } else {
      CBGV temp = resultList.get(0);
      System.out.println(temp.getTeacher());
      temp.getStudents().forEach(System.out::println);
    }
  }

  private static void addNewTeacher(List<CBGV> cbgvs) {
    Teacher teacher = null;
    List<Student> students = new ArrayList<>();

    try {
      teacher = inputTeacher(cbgvs);
      System.out.print(">>> number of students: ");
      int numberOfStudent = Integer.parseInt(ScannerSingletonPattern.getInstance().nextLine());

      for (int i = 1; i <= numberOfStudent; i++) {
        Student student = null;
        try {
          student = inputStudent(students, i, teacher.getTeacherCode());
          students.add(student);
        } catch (ExistStudentCodeException e) {
          System.err.println(e.getMessage());
        }
      }

      CBGV cbgv = new CBGV(teacher, students);
      cbgvs.add(cbgv);
    } catch (ExistTeacherCodeException e) {
      System.err.println(e.getMessage());
    }
  }

  private static Student inputStudent(List<Student> students, int i, String teacherCode) throws ExistStudentCodeException {
    System.out.println(">>> input infor student " + i);
    // input infor person
    Person person = inputPerson();

    // input infor student
    System.out.print("studentCode: ");
    String studentCode = ScannerSingletonPattern.getInstance().nextLine();

    if (isExistStudentCode(students, studentCode)) {
      throw new ExistStudentCodeException("already exists student");
    }
    return new Student(studentCode, person.getName(), person.getAge(), person.getAddress());
  }

  private static boolean isExistStudentCode(List<Student> students, String studentCode) {
    if (students.size() == 0) {
      return false;
    }
    return !(students.stream()
        .filter(cbg -> cbg.getStudentCode().equals(studentCode))
        .count() == 0);
  }

  private static Teacher inputTeacher(List<CBGV> cbgvs) throws ExistTeacherCodeException {
    System.out.println(">>> input infor teacher: ");
    // input infor person
    Person person = inputPerson();

    // input infor teacher
    System.out.print("teacherCode: ");
    String teacherCode = ScannerSingletonPattern.getInstance().nextLine();

    if (isExistTeacherCode(cbgvs, teacherCode)) {
      throw new ExistTeacherCodeException("already teacher code");
    }

    System.out.print("fixedSalary: ");
    double fixedSalary = Double.parseDouble(ScannerSingletonPattern.getInstance().nextLine());
    System.out.print("bonus: ");
    double bonus = Double.parseDouble(ScannerSingletonPattern.getInstance().nextLine());
    System.out.print("fine: ");
    double fine = Double.parseDouble(ScannerSingletonPattern.getInstance().nextLine());
    return new Teacher(person.getName(), person.getAge(), person.getAddress(), teacherCode, fixedSalary, bonus, fine);
  }

  private static boolean isExistTeacherCode(List<CBGV> cbgvs, String teacherCode) {
    return !(cbgvs.stream()
        .filter(cbg -> cbg.getTeacher().getTeacherCode().equals(teacherCode))
        .count() == 0);
  }

  private static Person inputPerson() {
    System.out.print("name: ");
    String name = ScannerSingletonPattern.getInstance().nextLine();
    System.out.print("age: ");
    int age = Integer.parseInt(ScannerSingletonPattern.getInstance().nextLine());
    System.out.print("address: ");
    String address = ScannerSingletonPattern.getInstance().nextLine();
    return new Person(name, age, address);
  }
}
