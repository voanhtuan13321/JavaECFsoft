package org.example.bai15.model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Department  class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 21/09/2023
 */
public class Department {
  private int id;
  private String departmentName;
  private List<RegularStudent> students;

  public Department(int id, String departmentName, List<RegularStudent> students) {
    this.id = id;
    this.departmentName = departmentName;
    this.students = students;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public List<RegularStudent> getStudents() {
    return students;
  }

  public void setStudents(List<RegularStudent> students) {
    this.students = students;
  }

  @Override
  public String toString() {
    return "Department{" +
        "id='" + id + '\'' +'"' +
        "departmentName='" + departmentName + '\'' +
        ", students=" + students +
        '}';
  }

  // Phương thức lấy điểm trung bình các môn học của sinh viên dựa vào học kỳ cho trước
  public void averageStudent(String semester) {
    students.stream()
        .filter(stu -> stu.getAcademicResults()
            .stream()
            .anyMatch(rs -> rs.getSemester().equalsIgnoreCase(semester))
        )
        .forEach(stu -> {
          double avg = stu.getAcademicResults()
              .stream()
              .filter(rs -> rs.getSemester().equalsIgnoreCase(semester))
              .mapToDouble(AcademicResult::getGpa)
              .sum();
          System.out.println("id: " + stu.getStudentID() + ", name: " + stu.getFullName() + ", " +
              "avg: " + avg);
        });
  }

  // Phương thức để xác định tổng số sinh viên chính quy của khoa
  public long countRegularStudents() {
    return students.stream()
        .filter(stu -> !(stu instanceof PartTimeStudent))
        .count();
  }

  // Phương thức để tìm sinh viên có điểm đầu vào cao nhất
//  public RegularStudent findStudentWithHighestEntranceScore() {
//    RegularStudent highestScoreStudent = null;
//    double highestScore = Double.MIN_VALUE;
//    for (RegularStudent student : students) {
//      if (student.getEntranceScore() > highestScore) {
//        highestScore = student.getEntranceScore();
//        highestScoreStudent = student;
//      }
//    }
//    return highestScoreStudent;
//  }
  public RegularStudent findStudentWithHighestEntranceScore() {
    return students.stream()
        .max(Comparator.comparingDouble(RegularStudent::getEntranceScore))
        .orElse(null);
  }

  // Phương thức để tìm danh sách sinh viên tại chức tại một nơi liên kết đào tạo cho trước
//  public List<PartTimeStudent> findPartTimeStudentsByLocation(String location) {
//    List<PartTimeStudent> partTimeStudents = new ArrayList<>();
//    for (RegularStudent student : students) {
//      if (student instanceof PartTimeStudent) {
//        PartTimeStudent partTimeStudent = (PartTimeStudent) student;
//        if (partTimeStudent.getTrainingLocation().equalsIgnoreCase(location)) {
//          partTimeStudents.add(partTimeStudent);
//        }
//      }
//    }
//    return partTimeStudents;
//  }
  public List<PartTimeStudent> findPartTimeStudentsByLocation(String location) {
    return students.stream()
        .filter(PartTimeStudent.class::isInstance)
        .map(PartTimeStudent.class::cast)
        .filter(partTimeStudent -> partTimeStudent.getTrainingLocation().equalsIgnoreCase(location))
        .collect(Collectors.toList());
  }


  // Phương thức để lấy danh sách sinh viên có điểm trung bình học kỳ gần nhất từ 8.0 trở lên
//  public List<RegularStudent> findStudentsWithHighGpa() {
//    List<RegularStudent> studentsWithHighGpa = new ArrayList<>();
//    for (RegularStudent student : students) {
//      List<AcademicResult> academicResults = student.getAcademicResults();
//      if (!academicResults.isEmpty()) {
//        AcademicResult latestResult = academicResults.get(academicResults.size() - 1);
//        if (latestResult.getGpa() >= 8.0) {
//          studentsWithHighGpa.add(student);
//        }
//      }
//    }
//    return studentsWithHighGpa;
//  }
  public List<RegularStudent> findStudentsWithHighGpa() {
    return students.stream()
        // Lọc ra các sinh viên có kết quả học tập
        .filter(student -> !student.getAcademicResults().isEmpty())
        // Lọc ra các sinh viên có GPA cao (>= 8.0) ở học kì gần nhất
        .filter(student -> {
          List<AcademicResult> academicResults = student.getAcademicResults();
          AcademicResult latestResult = academicResults.get(academicResults.size() - 1);
          return latestResult.getGpa() >= 8.0;
        })
        .collect(Collectors.toList());
  }


  // Phương thức để tìm sinh viên có điểm trung bình học kỳ cao nhất
//  public RegularStudent findStudentWithHighestGpa() {
//    RegularStudent highestGpaStudent = null;
//    double highestGpa = Double.MIN_VALUE;
//    for (RegularStudent student : students) {
//      List<AcademicResult> academicResults = student.getAcademicResults();
//      if (!academicResults.isEmpty()) {
//        double avgGpa = academicResults
//            .stream()
//            .mapToDouble(AcademicResult::getGpa)
//            .average()
//            .getAsDouble();
//        if (avgGpa > highestGpa) {
//          highestGpa = avgGpa;
//          highestGpaStudent = student;
//        }
//      }
//    }
//    return highestGpaStudent;
//  }
  public RegularStudent findStudentWithHighestGpa() {
    return students.stream()
        // Lọc ra các sinh viên có kết quả học tập
        .filter(student -> !student.getAcademicResults().isEmpty())
        .max(Comparator.comparingDouble(student -> {
          List<AcademicResult> academicResults = student.getAcademicResults();
          return academicResults.stream()
              .mapToDouble(AcademicResult::getGpa)
              .average()
              // Nếu không có kết quả nào, sử dụng giá trị Double.MIN_VALUE
              .orElse(Double.MIN_VALUE);
        }))
        .orElse(null);
  }


  // Phương thức để thống kê số lượng sinh viên theo năm vào học
//  public Map<Integer, Integer> countStudentsByEnrollmentYear() {
//    Map<Integer, Integer> enrollmentYearCounts = new TreeMap<>();
//    for (RegularStudent student : students) {
//      int enrollmentYear = student.getEnrollmentYear();
//      enrollmentYearCounts.put(enrollmentYear, enrollmentYearCounts.getOrDefault(enrollmentYear, 0) + 1);
//    }
//    return enrollmentYearCounts;
//  }
  public Map<Integer, Long> countStudentsByEnrollmentYear() {
    return students.stream()
        .collect(Collectors.groupingBy(
            RegularStudent::getEnrollmentYear, // Nhóm theo năm nhập học
            Collectors.counting() // Đếm số lượng sinh viên trong mỗi nhóm
        ));
  }
}
