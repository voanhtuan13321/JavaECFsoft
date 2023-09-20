package org.example.bai12;


import org.example.common.InputUtil;

import java.util.List;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Main {
  private static final QLPTGT qlptgt = new QLPTGT();

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. add new vehicle");
      System.out.println("2. display vehicles");
      System.out.println("3. find vehicle by color or manufacturer");
      System.out.println("4. stop");
      String choose = InputUtil.inputString(">>> input your choose: ");

      switch (choose) {
        case "1": {
          Vehicle newVehicle = inputVehicle();
          qlptgt.addVehicle(newVehicle);
          break;
        }

        case "2": {
          qlptgt.showVehicle();
          break;
        }

        case "3": {
          String keySearch = InputUtil.inputString("key search: ");
          List<Vehicle> resultFind = qlptgt.findByManufacturerOrColor(keySearch);
          if (resultFind.isEmpty()) {
            System.err.println("don't find vehicle by key: " + keySearch);
          } else {
            resultFind.forEach(System.out::println);
          }
          break;
        }

        case "4": {
          return;
        }

        default:
          break;
      }
    }
  }

  private static Vehicle inputVehicle() {
    Vehicle vehicle = null;
    String type = "";
    while (true) {
      type = InputUtil.inputString(">>> type(car, motor, truck): ");
      if ("car".equals(type) || "motor".equals(type) || "truck".equals(type)) {
        break;
      } else {
        System.err.println("input invalid, please enter again");
      }
    }
    String id = "";
    while (true) {
      id = InputUtil.inputString("id: ");
      if (qlptgt.isIdExist((id))) {
        System.err.println("already exists id, please enter again");
      } else {
        break;
      }
    }
    String manufacturer = InputUtil.inputString("manufacturer: ");
    int yearOfManufacturer = InputUtil.inputNumber("yearOfManufact: ");
    double price = InputUtil.inputDouble("price: ");
    String color = InputUtil.inputString("color: ");
    switch (type) {
      case "car":
        int numberOfSeats = InputUtil.inputNumber("numberOfSeats: ");
        String engineType = InputUtil.inputString("engineType: ");
        vehicle = new Car(id, manufacturer, yearOfManufacturer, price, color, numberOfSeats, engineType);
        break;

      case "motor":
        int wattage = InputUtil.inputNumber("wattage: ");
        vehicle = new Motorbike(id, manufacturer, yearOfManufacturer, price, color, wattage);
        break;

      case "truck":
        int payload = InputUtil.inputNumber("payload: ");
        vehicle = new Truck(id, manufacturer, yearOfManufacturer, price, color, payload);
        break;

      default:
        break;
    }
    return vehicle;
  }
}
