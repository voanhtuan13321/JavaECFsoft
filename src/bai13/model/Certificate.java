package bai13.model;

/**
 * Certificate class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Certificate {
  private int certificateID;
  private String certificateName;
  private String certificateRank;
  private String certificateDate;

  public Certificate(String certificateName, String certificateRank, String certificateDate) {
    this.certificateName = certificateName;
    this.certificateRank = certificateRank;
    this.certificateDate = certificateDate;
  }

  public int getCertificateID() {
    return certificateID;
  }

  public void setCertificateID(int certificateID) {
    this.certificateID = certificateID;
  }

  public String getCertificateName() {
    return certificateName;
  }

  public void setCertificateName(String certificateName) {
    this.certificateName = certificateName;
  }

  public String getCertificateRank() {
    return certificateRank;
  }

  public void setCertificateRank(String certificateRank) {
    this.certificateRank = certificateRank;
  }

  public String getCertificateDate() {
    return certificateDate;
  }

  public void setCertificateDate(String certificateDate) {
    this.certificateDate = certificateDate;
  }

  @Override
  public String toString() {
    return "Certificate{" +
        "certificateID=" + certificateID +
        ", certificateName='" + certificateName + '\'' +
        ", certificateRank='" + certificateRank + '\'' +
        ", certificateDate='" + certificateDate + '\'' +
        '}';
  }
}
