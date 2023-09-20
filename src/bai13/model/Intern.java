package bai13.model;

/**
 * Intern class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Intern extends Employee {
  private String majors;
  private String semester;
  private String universityName;

  public Intern(String fullName, String birthDay, String phone, String email, String majors, String semester, String universityName) {
    super(fullName, birthDay, phone, email, 2); // 2 corresponds to Intern
    this.majors = majors;
    this.semester = semester;
    this.universityName = universityName;
  }

  public String getMajors() {
    return majors;
  }

  public void setMajors(String majors) {
    this.majors = majors;
  }

  public String getSemester() {
    return semester;
  }

  public void setSemester(String semester) {
    this.semester = semester;
  }

  public String getUniversityName() {
    return universityName;
  }

  public void setUniversityName(String universityName) {
    this.universityName = universityName;
  }

  @Override
  public String toString() {
    return "Intern{" +
        "majors='" + majors + '\'' +
        ", semester='" + semester + '\'' +
        ", universityName='" + universityName + '\'' +
        '}';
  }

  @Override
  public void showInfo() {
    System.out.println("Employee Type: Intern");
    System.out.println("ID: " + getId());
    System.out.println("Full Name: " + getFullName());
    // Add more specific info for Intern employees
    System.out.println("Majors: " + majors);
    System.out.println("Semester: " + semester);
    System.out.println("University Name: " + universityName);
    // Print certificates
    for (Certificate certificate : getCertificates()) {
      System.out.println("Certificate: " + certificate.getCertificateName());
    }
  }
}
