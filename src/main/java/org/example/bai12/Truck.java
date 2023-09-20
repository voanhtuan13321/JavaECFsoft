package org.example.bai12;

/**
 * truck class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Truck extends Vehicle {
  private int payload;

  public Truck(String id, String manufacturer, int yearOfManufacturer, double price, String color, int payload) {
    super(id, manufacturer, yearOfManufacturer, price, color);
    this.payload = payload;
  }

  public int getPayload() {
    return payload;
  }

  public void setPayload(int payload) {
    this.payload = payload;
  }

  @Override
  public String toString() {
    return "Truck{" +
        super.toString() + ", " +
        "payload=" + payload +
        '}';
  }
}
