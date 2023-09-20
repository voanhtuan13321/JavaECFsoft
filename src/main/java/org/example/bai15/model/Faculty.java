package org.example.bai15.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Faculty class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class Faculty {
  private String name;
  private List<Student> students;

  public Faculty(String name) {
    this.name = name;
    students = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public List<Student> getStudentsByStatus(boolean isFullTime) {
    List<Student> filteredStudents = new ArrayList<>();
    for (Student student : students) {
      if (student.isFullTimeStudent() == isFullTime) {
        filteredStudents.add(student);
      }
    }
    return filteredStudents;
  }

  public List<Student> getStudentsByEntranceYear(int year) {
    List<Student> filteredStudents = new ArrayList<>();
    for (Student student : students) {
      if (student.getEntranceYear() == year) {
        filteredStudents.add(student);
      }
    }
    return filteredStudents;
  }

  public Student getStudentWithMaxEntranceScore() {
    Student maxEntranceScoreStudent = null;
    double maxScore = -1.0;

    for (Student student : students) {
      if (student.getEntranceScore() > maxScore) {
        maxScore = student.getEntranceScore();
        maxEntranceScoreStudent = student;
      }
    }
    return maxEntranceScoreStudent;
  }

  public List<Student> getTopStudents() {
    List<Student> topStudents = new ArrayList<>();
    for (Student student : students) {
      if (student.calculateGPA() >= 8.0) {
        topStudents.add(student);
      }
    }
    return topStudents;
  }

  public List<Student> getStudentsWithGPA(double gpa) {
    List<Student> studentsWithGPA = new ArrayList<>();
    for (Student student : students) {
      if (student.calculateGPA() >= gpa) {
        studentsWithGPA.add(student);
      }
    }
    return studentsWithGPA;
  }

  public List<Student> getStudentsWithMaxGPA() {
    List<Student> studentsWithMaxGPA = new ArrayList<>();
    double maxGPA = -1.0;
    for (Student student : students) {
      double studentGPA = student.calculateGPA();
      if (studentGPA > maxGPA) {
        maxGPA = studentGPA;
        studentsWithMaxGPA.clear();
        studentsWithMaxGPA.add(student);
      } else if (studentGPA == maxGPA) {
        studentsWithMaxGPA.add(student);
      }
    }
    return studentsWithMaxGPA;
  }

  public List<Student> getStudentsWithMinGPA() {
    List<Student> studentsWithMinGPA = new ArrayList<>();
    double minGPA = Double.MAX_VALUE;
    for (Student student : students) {
      double studentGPA = student.calculateGPA();
      if (studentGPA < minGPA) {
        minGPA = studentGPA;
        studentsWithMinGPA.clear();
        studentsWithMinGPA.add(student);
      } else if (studentGPA == minGPA) {
        studentsWithMinGPA.add(student);
      }
    }
    return studentsWithMinGPA;
  }

  public void sortStudentsByTypeAndEntranceYear() {
    students.sort((s1, s2) -> {
      // Compare by type (Full-time or Part-time)
      int typeComparison = Boolean.compare(s1.isFullTimeStudent(), s2.isFullTimeStudent());
      if (typeComparison != 0) {
        return typeComparison;
      }

      // Compare by entrance year (Descending order)
      return Integer.compare(s2.getEntranceYear(), s1.getEntranceYear());
    });
  }

  public void countStudentsByEntranceYear() {
    int currentYear = 2023; // Replace with current year
    int startYear = currentYear - 4;

    System.out.println("Student count by entrance year:");
    for (int year = startYear; year <= currentYear; year++) {
      int count = 0;
      for (Student student : students) {
        if (student.getEntranceYear() == year) {
          count++;
        }
      }
      System.out.println(year + ": " + count);
    }
  }
}
