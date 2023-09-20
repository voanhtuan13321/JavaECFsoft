package org.example.bai15.model;

import java.util.ArrayList;
import java.util.List;

/**
 * University class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class University {
  private List<Faculty> faculties;
  private List<Student> students;

  public University() {
    faculties = new ArrayList<>();
    students = new ArrayList<>();
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public Student findStudentByID(String studentID) {
    for (Student student : students) {
      if (student.getStudentID().equals(studentID)) {
        return student;
      }
    }
    return null;
  }

//  public Map<String, Student> getStudentsWithHighestEntranceScoreInEachFaculty() {
//    Map<String, Student> result = new HashMap<>();
//    for (Student student : students) {
//      String faculty = student.getFaculty();
//      if (!result.containsKey(faculty) || student.getEntranceScore() > result.get(faculty).getEntranceScore()) {
//        result.put(faculty, student);
//      }
//    }
//    return result;
//  }

  public List<Student> getStudentsWithGPA(double minGPA) {
    List<Student> result = new ArrayList<>();
    for (Student student : students) {
      if (student.calculateGPA() >= minGPA) {
        result.add(student);
      }
    }
    return result;
  }

  public void addFaculty(Faculty faculty) {
    faculties.add(faculty);
  }

  public Faculty getFacultyByName(String name) {
    for (Faculty faculty : faculties) {
      if (faculty.getName().equals(name)) {
        return faculty;
      }
    }
    return null;
  }

  public List<Student> findTopStudents() {
    List<Student> topStudents = new ArrayList<>();
    for (Faculty faculty : faculties) {
      topStudents.addAll(faculty.getTopStudents());
    }
    return topStudents;
  }

  public List<Student> findStudentsWithGPA(double gpa) {
    List<Student> studentsWithGPA = new ArrayList<>();
    for (Faculty faculty : faculties) {
      studentsWithGPA.addAll(faculty.getStudentsWithGPA(gpa));
    }
    return studentsWithGPA;
  }

  public Student getStudentWithMaxEntranceScore() {
    Student maxEntranceScoreStudent = null;
    double maxScore = -1.0;

    for (Faculty faculty : faculties) {
      Student student = faculty.getStudentWithMaxEntranceScore();
      if (student != null && student.getEntranceScore() > maxScore) {
        maxScore = student.getEntranceScore();
        maxEntranceScoreStudent = student;
      }
    }
    return maxEntranceScoreStudent;
  }
}
