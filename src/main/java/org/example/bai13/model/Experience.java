package org.example.bai13.model;

/**
 * Experience class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Experience extends Employee {
  private int expInYear;
  private String proSkill;

  public Experience(String fullName, String birthDay, String phone, String email, int expInYear, String proSkill) {
    super(fullName, birthDay, phone, email, 0); // 0 corresponds to Experience
    this.expInYear = expInYear;
    this.proSkill = proSkill;
  }

  public int getExpInYear() {
    return expInYear;
  }

  public void setExpInYear(int expInYear) {
    this.expInYear = expInYear;
  }

  public String getProSkill() {
    return proSkill;
  }

  public void setProSkill(String proSkill) {
    this.proSkill = proSkill;
  }

  @Override
  public String toString() {
    return "Experience{" +
        super.toString() + ", " +
        "expInYear=" + expInYear +
        ", proSkill='" + proSkill + '\'' +
        '}';
  }

  @Override
  public void showInfo() {
    System.out.println("Employee Type: Experience");
    System.out.println("ID: " + getId());
    System.out.println("Full Name: " + getFullName());
    // Add more specific info for Experience employees
    System.out.println("Experience in Years: " + expInYear);
    System.out.println("Professional Skill: " + proSkill);
    // Print certificates
    for (Certificate certificate : getCertificates()) {
      System.out.println("Certificate: " + certificate.getCertificateName());
    }
  }
}
