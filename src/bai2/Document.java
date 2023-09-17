package bai2;

/**
 * Document class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class Document {
  // Mã tài liệu(Mã tài liệu là duy nhất), Tên nhà xuất bản, số bản phát hành
  private String documentCode;
  private String publishingHouseName;
  private String releaseNumber;

  public Document() {
  }

  public Document(String documentCode, String publishingHouseName, String releaseNumber) {
    this.documentCode = documentCode;
    this.publishingHouseName = publishingHouseName;
    this.releaseNumber = releaseNumber;
  }

  public String getDocumentCode() {
    return documentCode;
  }

  public void setDocumentCode(String documentCode) {
    this.documentCode = documentCode;
  }

  public String getPublishingHouseName() {
    return publishingHouseName;
  }

  public void setPublishingHouseName(String publishingHouseName) {
    this.publishingHouseName = publishingHouseName;
  }

  public String getReleaseNumber() {
    return releaseNumber;
  }

  public void setReleaseNumber(String releaseNumber) {
    this.releaseNumber = releaseNumber;
  }

  @Override
  public String toString() {
    return "Document{" +
        "documentCode='" + documentCode + '\'' +
        ", publishingHouseName='" + publishingHouseName + '\'' +
        ", releaseNumber='" + releaseNumber + '\'' +
        '}';
  }
}
