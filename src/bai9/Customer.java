package bai9;

/**
 * Customer class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 15/09/2023
 */
public class Customer {
  //Họ tên chủ hộ, số nhà, mã số công tơ điện
  private String fullName;
  private String address;
  private int numOfElectricityMeter;

  public Customer(String fullName, String address, int numOfElectricityMeter) {
    this.fullName = fullName;
    this.address = address;
    this.numOfElectricityMeter = numOfElectricityMeter;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getNumOfElectricityMeter() {
    return numOfElectricityMeter;
  }

  public void setNumOfElectricityMeter(int numOfElectricityMeter) {
    this.numOfElectricityMeter = numOfElectricityMeter;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "fullName='" + fullName + '\'' +
        ", address='" + address + '\'' +
        ", numOfElectricityMeter=" + numOfElectricityMeter +
        '}';
  }
}
