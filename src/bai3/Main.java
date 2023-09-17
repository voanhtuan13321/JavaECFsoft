package bai3;

import exam.InputUtil;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class Main {
  private static final Admission admission = new Admission();

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. add new candidate");
      System.out.println("2. display information candidates");
      System.out.println("4. find candidate by identifier number");
      System.out.println("5. stop");
      String choose = InputUtil.inputString(">>> input your choose: ");

      switch (choose) {
        case "1": {
          Candidate newCandidate = inputCandidate();
          admission.addNewCandidate(newCandidate);
          break;
        }

        case "2": {
          admission.showInformationCandidate();
          break;
        }

        case "3": {
          String identificationNumber = inputIdentificationNumber();
          Candidate resultFind = admission.findCandidateByIdentifierNumber(identificationNumber);
          if (resultFind != null) {
            System.out.println(resultFind);
          } else {
            System.err.println("don't find candidate by identifier number: " + identificationNumber);
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

  private static String inputIdentificationNumber() {
    String identificationNumber = "";
    while (true) {
      identificationNumber = InputUtil.inputString("identification number: ");
      if (admission.isIdentificationNumberExist(identificationNumber)) {
        System.err.println("already identification number, please enter again");
      } else {
        break;
      }
    }
    return identificationNumber;
  }
  private static Candidate inputCandidate() {
    String identificationNumber = inputIdentificationNumber();
    String name = InputUtil.inputString("name: ");
    String address = InputUtil.inputString("address: ");
    String priorityLevel = InputUtil.inputString("priority: ");
    String type = "";
    Block block = null;
    while (true) {
      type = InputUtil.inputString("block (A, B, C): ");
      if ("a".equals(type)) {
        block = new BlockA();
        break;
      } else if ("b".equals(type)) {
        block = new BlockB();
        break;
      } else if ("c".equals(type)) {
        block = new BlockC();
        break;
      } else {
        System.err.println("type invalid, please enter again");
      }
    }
    return new Candidate(identificationNumber, name, address, priorityLevel, block);
  }
}
