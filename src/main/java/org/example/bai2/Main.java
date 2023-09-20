package org.example.bai2;


import org.example.common.InputUtil;

import java.util.List;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class Main {
  private static final DocumentManagement documentManagement = new DocumentManagement();
  public static void main(String[] args) {
    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. add new document");
      System.out.println("2. remove document by document code");
      System.out.println("3. display information of document");
      System.out.println("4. find document by document type");
      System.out.println("5. stop");
      String choose = InputUtil.inputString(">>> input your choose: ");

      switch (choose) {
        case "1": {
          Document doc = inputDocument();
          documentManagement.addDocument(doc);
          break;
        }

        case "2": {
          String documentCode = InputUtil.inputString(">>> enter document code: ");
          boolean isRemoveSuccess = documentManagement.removeDocumentByDocumentCode(documentCode);
          if (isRemoveSuccess) {
            System.out.println("remove document successfully");
          } else {
            System.err.println("don't find document by document code: " + documentCode);
          }
          break;
        }

        case "3": {
          documentManagement.showInformationDocuments();
          break;
        }

        case "4": {
          String type = inputDocumentType();
          List<Document> resultsFind = documentManagement.findDocumentsByTypeDocument(type);
          if (resultsFind.isEmpty()) {
            System.err.println("don't find documents by type: " + type);
          } else {
            resultsFind.forEach(System.out::println);
          }
          break;
        }

        case "5": {
          return;
        }

        default:
          break;
      }
    }
  }

  private static String inputDocumentType() {
    String type = "";
    while (true) {
      type = InputUtil.inputString(">>> enter document type (book, magazine, newspaper): ").trim();
      if ("book".equals(type) || "magazine".equals(type) || "newspaper".equals(type)) {
        break;
      } else {
        System.err.println("document type invalid, please enter again");
      }
    }
    return type;
  }

  private static Document inputDocument() {
    Document document = null;
    String type = inputDocumentType();

    String documentCode = "";
    while (true) {
      documentCode = InputUtil.inputString("document code: ");
      if (documentManagement.isDocumentCodeExist(documentCode)) {
        System.err.println("document code already exists, please enter again");
      } else {
        break;
      }
    }
    String publishingHouseName = InputUtil.inputString("publishing house name: ");
    String releaseNumber = InputUtil.inputString("release number: ");

    switch (type) {
      case "book":
        String authorName = InputUtil.inputString("author name: ");
        int pageNumber = InputUtil.inputNumber("page number: ");
        document = new Book(documentCode, publishingHouseName, releaseNumber, authorName, pageNumber);
        break;
      case "magazine":
        int issueNumber = InputUtil.inputNumber("issue number: ");
        int releaseMonth = InputUtil.inputNumber("release month: ");
        document = new Magazine(documentCode, publishingHouseName, releaseNumber, issueNumber,
            releaseMonth);
        break;
      case "newspaper":
        int releaseDay = InputUtil.inputNumber("release day: ");
        document = new Newspaper(documentCode, publishingHouseName, releaseNumber, releaseDay);
        break;
      default:
        break;
    }

    return document;
  }
}
