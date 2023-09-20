package org.example.bai9;

/**
 * Bill class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 15/09/2023
 */
public class Bill {
  // Thông tin về hộ sử dụng điện, chỉ số điện cũ, chỉ số mới, số tiền phải trả.
  private Customer customer;
  private int oldElectricity;
  private int newElectricity;

  public Bill(Customer customer, int oldElectricity, int newElectricity) {
    this.customer = customer;
    this.oldElectricity = oldElectricity;
    this.newElectricity = newElectricity;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public int getOldElectricity() {
    return oldElectricity;
  }

  public void setOldElectricity(int oldElectricity) {
    this.oldElectricity = oldElectricity;
  }

  public int getNewElectricity() {
    return newElectricity;
  }

  public void setNewElectricity(int newElectricity) {
    this.newElectricity = newElectricity;
  }

  @Override
  public String toString() {
    return "Bill{" +
        "customer=" + customer +
        ", oldElectricity=" + oldElectricity +
        ", newElectricity=" + newElectricity +
        ", price=" + getPrice() +
        '}';
  }

  public double getPrice() {
    return (newElectricity - oldElectricity) * 5;
  }
}
