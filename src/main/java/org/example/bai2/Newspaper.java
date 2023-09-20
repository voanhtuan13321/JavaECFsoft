package org.example.bai2;

/**
 * newspaper class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class Newspaper extends Document {
  private int releaseDay;

  public Newspaper(String documentCode, String publishingHouseName, String releaseNumber,
                   int releaseDay) {
    super(documentCode, publishingHouseName, releaseNumber);
    this.releaseDay = releaseDay;
  }

  public int getReleaseDay() {
    return releaseDay;
  }

  public void setReleaseDay(int releaseDay) {
    this.releaseDay = releaseDay;
  }

  @Override
  public String toString() {
    return "Newspaper{" +
        super.toString() + ", " +
        "releaseDay=" + releaseDay +
        '}';
  }
}
