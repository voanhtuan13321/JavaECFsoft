package org.example.bai14;

import org.example.bai14.model.GoodStudent;
import org.example.bai14.model.NormalStudent;
import org.example.bai14.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * StudentManager class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class StudentManager {
  private final List<Student> students;

  public StudentManager() {
    students = new ArrayList<>();
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public void selectCandidates(int numCandidatesToHire) {
    if (numCandidatesToHire < 11 || numCandidatesToHire > 15) {
      System.out.println("Invalid number of candidates to hire.");
      return;
    }

    // Tạo danh sách riêng cho các sinh viên khá giỏi
    List<GoodStudent> goodStudents = new ArrayList<>();
    for (Student student : students) {
      if (student instanceof GoodStudent) {
        goodStudents.add((GoodStudent) student);
      }
    }

    // Sắp xếp danh sách sinh viên khá giỏi theo GPA và sau đó theo họ tên
    goodStudents.sort((s1, s2) -> {
      if (s1.getGpa() != s2.getGpa()) {
        return Double.compare(s2.getGpa(), s1.getGpa()); // Sắp xếp giảm dần theo GPA
      }
      return s1.getFullName().compareTo(s2.getFullName()); // Sắp xếp tăng dần theo họ tên
    });

    // Chọn các ứng viên khá giỏi cho công ty
    int numGoodCandidates = Math.min(numCandidatesToHire, goodStudents.size());
    System.out.println("Selected Good Students:");
    for (int i = 0; i < numGoodCandidates; i++) {
      GoodStudent selectedStudent = goodStudents.get(i);
      System.out.println("Name: " + selectedStudent.getFullName() + ", Phone: " + selectedStudent.getPhoneNumber());
    }

    // Kiểm tra xem còn cần tuyển thêm sinh viên trung bình không
    if (numCandidatesToHire > numGoodCandidates) {
      List<NormalStudent> normalStudents = new ArrayList<>();
      for (Student student : students) {
        if (student instanceof NormalStudent) {
          normalStudents.add((NormalStudent) student);
        }
      }

      // Sắp xếp danh sách sinh viên trung bình theo điểm thi đầu vào, TOEIC và sau đó theo họ tên
      normalStudents.sort((s1, s2) -> {
        if (s1.getEntryTestScore() != s2.getEntryTestScore()) {
          return Integer.compare(s2.getEntryTestScore(), s1.getEntryTestScore()); // Sắp xếp giảm dần theo điểm thi đầu vào
        }
        if (s1.getEnglishScore() != s2.getEnglishScore()) {
          return Integer.compare(s2.getEnglishScore(), s1.getEnglishScore()); // Sắp xếp giảm dần theo điểm TOEIC
        }
        return s1.getFullName().compareTo(s2.getFullName()); // Sắp xếp tăng dần theo họ tên
      });

      // Chọn các ứng viên trung bình cho công ty
      int numNormalCandidates = Math.min(numCandidatesToHire - numGoodCandidates, normalStudents.size());
      System.out.println("Selected Normal Students:");
      for (int i = 0; i < numNormalCandidates; i++) {
        NormalStudent selectedStudent = normalStudents.get(i);
        System.out.println("Name: " + selectedStudent.getFullName() + ", Phone: " + selectedStudent.getPhoneNumber());
      }
    }
  }

  public void showAllStudentsInfo() {
    // Sắp xếp danh sách sinh viên theo fullName và phoneNumber
    // Sắp xếp tăng dần theo fullName
    // Sắp xếp tăng dần theo phoneNumber
    Collections.sort(
        students,
        Comparator
            .comparing(Student::getFullName)
            .thenComparing(Student::getPhoneNumber)
    );

    System.out.println("All Students Info:");
    for (Student student : students) {
      student.ShowMyInfo();
      System.out.println("Phone: " + student.getPhoneNumber());
      System.out.println();
    }
  }
}
