package org.example.bai1;

import exam.InputUtil;

import java.util.List;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class Main {
  public static void main(String[] args) {
    QLCB qlcb = new QLCB();

    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. add new officer");
      System.out.println("2. find officer by full name");
      System.out.println("3. show list officers");
      System.out.println("4. stop");
      String choose = InputUtil.inputString(">>> input your choose: ");

      switch (choose) {
        case "1": {
          Officer newOfficer = inputOfficer();
          qlcb.addNewOfficer(newOfficer);
          break;
        }

        case "2": {
          String fullName = InputUtil.inputString(">>> enter your full name: ");
          List<Officer> resultFind = qlcb.findOfficerByFullName(fullName);
          resultFind.forEach(System.out::println);
          break;
        }

        case "3": {
          qlcb.showAllOfficers();
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

  private static Officer inputOfficer() {
    String type = "";
    while (true) {
      type = InputUtil.inputString(">>> input type officer (worker, engineer, employee): ");
      if ("worker".equals(type) || "employee".equals(type) || "engineer".equals(type)) {
        break;
      } else {
        System.err.println("type invalid, please input again !!!");
      }
    }

    String fullName = InputUtil.inputString("full name: ");
    int age = InputUtil.inputNumber("age: ");
    Sex sex = null;

    while (true) {
      try {
        sex = Sex.valueOf(InputUtil.inputString("sex (MALE, FEMALE, OTHER): "));
        break;
      } catch (IllegalArgumentException e) {
        System.err.println("sex invalid, please input again input again");
      }
    }

    String address = InputUtil.inputString("address: ");

    switch (type) {
      case "worker":
        Level level = null;
        while (true) {
          try {
            level = Level.valueOf(
                InputUtil.inputString("level (ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN): ")
            );
            break;
          } catch (IllegalArgumentException e) {
            System.err.println("level invalid, please input again input again");
          }
        }
        return new Worker(fullName, age, sex, address, level);

      case "engineer":
        String trainingIndustry = InputUtil.inputString("trainingIndustry: ");
        return new Engineer(fullName, age, sex, address, trainingIndustry);

      case "employee":
        String workName = InputUtil.inputString("workName: ");
        return new Employee(fullName, age, sex, address, workName);

      default:
        break;
    }
    return null;
  }
}
