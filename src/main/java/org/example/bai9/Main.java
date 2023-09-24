package org.example.bai9;

import org.example.common.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 15/09/2023
 */
public class Main {
  public static void main(String[] args) {
    List<Customer> customers = new ArrayList<>();

    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. add new customer");
      System.out.println("2. show list customer");
      System.out.println("3. remove customer by numOfElectricityMeter");
      System.out.println("4. update customer by numOfElectricityMeter");
      System.out.println("5. calculate price each customer by numOfElectricityMeter");
      System.out.println("6. stop");
      String choose = InputUtil.inputString(">>> input your choose: ");

      switch (choose) {
        case "1": {
          addNewCustomer(customers);
          break;
        }

        case "2": {
          showListCustomer(customers);
          break;
        }

        case "3": {
          int numOfElectricityMeter = InputUtil.inputInteger(">>> input numOfElectricityMeter: ");
          removeCustomerByNumOfElectricityMeter(customers, numOfElectricityMeter);
          break;
        }

        case "4": {
          int numOfElectricityMeter = InputUtil.inputInteger(">>> input numOfElectricityMeter: ");
          updateCustomerByNumOfElectricityMeter(customers, numOfElectricityMeter);
          break;
        }

        case "5": {
          int numOfElectricityMeter = InputUtil.inputInteger(">>> input numOfElectricityMeter: ");
          calculateCustomerByNumOfElectricityMeter(customers, numOfElectricityMeter);
          break;
        }

        case "6": {
          return;
        }

        default:
          break;
      }
    }
  }

  private static void calculateCustomerByNumOfElectricityMeter(List<Customer> customers,
                                                               int numOfElectricityMeter) {
    Customer customer = getCustomerByNumOfElectricityMeter(customers, numOfElectricityMeter);

    if (customer != null) {
      int oldElectricity = InputUtil.inputInteger("input oldElectricity: ");
      int newElectricity = InputUtil.inputInteger("input newElectricity: ");

      Bill bill = new Bill(customer, oldElectricity, newElectricity);
      System.out.println(bill);
    } else {
      System.err.println("don't find customer have number of electricity meter: " + numOfElectricityMeter);
    }
  }

  private static Customer getCustomerByNumOfElectricityMeter(List<Customer> customers,
                                                             int numOfElectricityMeter) {
    for (Customer cus : customers) {
      if (cus.getNumOfElectricityMeter() == numOfElectricityMeter) {
        return cus;
      }
    }
    return null;
  }

  private static void updateCustomerByNumOfElectricityMeter(List<Customer> customers,
                                                            int numOfElectricityMeter) {
    List<Customer> resultFilter = customers
        .stream()
        .filter(c -> c.getNumOfElectricityMeter() == numOfElectricityMeter)
        .collect(Collectors.toList());

    if (resultFilter.isEmpty()) {
      System.err.println("Don't find customers have numOfElectricityM: " + numOfElectricityMeter);
    } else {
      Customer customer = resultFilter.get(0);
      System.out.println("OldInformation: " + customer);

      String fullName = InputUtil.inputString("input full name: ");
      String address = InputUtil.inputString("input address: ");
      customer.setFullName(fullName);
      customer.setAddress(address);

      updateCustomer(customers, customer);
      System.out.println("Updated successfully");
    }
  }

  private static void updateCustomer(List<Customer> customers, Customer customer) {
    for (Customer cus : customers) {
      if (cus.getNumOfElectricityMeter() == customer.getNumOfElectricityMeter()) {
        cus.setFullName(customer.getFullName());
        cus.setAddress(customer.getAddress());
      }
    }
  }


  private static void showListCustomer(List<Customer> customers) {
    customers.forEach(System.out::println);
  }

  private static void addNewCustomer(List<Customer> customers) {
    String fullName = InputUtil.inputString("input full name: ");
    String address = InputUtil.inputString("input address: ");

    int numOfElectricityMeter = 0;
    while (true) {
      numOfElectricityMeter = InputUtil.inputInteger("input number of electricity meter: ");

      if (isNumOfElectricityMeterExists(customers, numOfElectricityMeter)) {
        System.err.println("already exists numOfElectricityMeter, please input again");
      } else {
        break;
      }
    }

    Customer customer = new Customer(fullName, address, numOfElectricityMeter);
    customers.add(customer);
  }

  private static boolean isNumOfElectricityMeterExists(List<Customer> customers,
                                                       int numOfElectricityMeter) {
    return customers
        .stream()
        .anyMatch(customer -> customer.getNumOfElectricityMeter() == numOfElectricityMeter);
  }

  private static void removeCustomerByNumOfElectricityMeter(List<Customer> customers,
                                                            int numOfElectricityMeter) {
    boolean isSuccess =
        customers.removeIf(customer -> customer.getNumOfElectricityMeter() == numOfElectricityMeter);

    if (isSuccess) {
      System.out.println("Removed successfully");
    } else {
      System.err.println("Don't find customer have numOfElectricityM: " + numOfElectricityMeter);
    }
  }
}
