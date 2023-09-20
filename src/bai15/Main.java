package bai15;

import bai15.model.Student;
import bai15.model.University;
import exam.InputUtil;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 19/09/2023
 */
public class Main {
  public static void main(String[] args) {
    University university = new University();

    while (true) {
      System.out.println("===== Student Management System =====");
      System.out.println("1. Add a new student");
      System.out.println("2. Calculate GPA for a student");
      System.out.println("3. Determine if a student is full-time");
      System.out.println("4. Get students with the highest entrance score in each faculty");
      System.out.println("5. Get students with GPA >= 8.0");
      System.out.println("6. Get student with the highest entrance score");
      System.out.println("7. Exit");
      int choice = InputUtil.inputNumber("Please choose an option (1-7): ");

      switch (choice) {
        case 1:
          // Add a new student
          String studentID = InputUtil.inputString("Enter student ID: ");
          String fullName = InputUtil.inputString("Enter full name: ");
          String dob = InputUtil.inputString("Enter date of birth (dd/MM/yyyy): ");
          int entranceYear = InputUtil.inputNumber("Enter entrance year: ");
          double entranceScore = InputUtil.inputDouble("Enter entrance score: ");
          boolean isFullTime = InputUtil.inputBoolean("Is the student full-time? (true/false): ");

          Student newStudent = new Student(studentID, fullName, dob, entranceYear, entranceScore, isFullTime);
          university.addStudent(newStudent);
          System.out.println("Student added successfully.");
          break;

        case 2:
          // Calculate GPA for a student
          String studentIDToCalculate = InputUtil.inputString("Enter student ID: ");
          Student studentToCalculate = university.findStudentByID(studentIDToCalculate);

          if (studentToCalculate != null) {
            double gpa = studentToCalculate.calculateGPA();
            System.out.println("GPA for student " + studentToCalculate.getFullName() + ": " + gpa);
          } else {
            System.out.println("Student not found.");
          }
          break;

        case 3:
          // Determine if a student is full-time
          String studentIDToCheck = InputUtil.inputString("Enter student ID: ");
          Student studentToCheck = university.findStudentByID(studentIDToCheck);

          if (studentToCheck != null) {
            boolean isFullTimeStudent = studentToCheck.isFullTimeStudent();
            System.out.println("Student " + studentToCheck.getFullName() + " is full-time: " + isFullTimeStudent);
          } else {
            System.out.println("Student not found.");
          }
          break;

        case 4:
          // Get students with the highest entrance score in each faculty
          System.out.println("Students with the highest entrance score in each faculty:");
//          university.getStudentsWithHighestEntranceScoreInEachFaculty()
//              .forEach((faculty, student) -> System.out.println(faculty + ": " + student.getFullName() + " - Score: " + student.getEntranceScore()));
          break;

        case 5:
          // Get students with GPA >= 8.0
          System.out.println("Students with GPA >= 8.0:");
          university.getStudentsWithGPA(8.0).forEach(student ->
              System.out.println(student.getFullName() + " - GPA: " + student.calculateGPA()));
          break;

        case 6:
          // Get student with the highest entrance score
          Student studentWithMaxEntranceScore = university.getStudentWithMaxEntranceScore();
          System.out.println("Student with the highest entrance score:");
          if (studentWithMaxEntranceScore != null) {
            System.out.println(studentWithMaxEntranceScore.getFullName() + " - Score: " + studentWithMaxEntranceScore.getEntranceScore());
          } else {
            System.out.println("No students found.");
          }
          break;

        case 7:
          // Exit the program
          System.out.println("Goodbye!");
          System.exit(0);
          break;

        default:
          System.out.println("Invalid option. Please choose again.");
          break;
      }
    }
  }
}
