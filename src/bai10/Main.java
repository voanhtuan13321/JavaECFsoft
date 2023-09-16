package bai10;

import exam.InputUtil;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class Main {

  private static final String ERROR_MESSAGE = "Please enter a paragraph";

  public static void main(String[] args) {
    Paragraph paragraph = null;

    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. input paragraph");
      System.out.println("2. count words in paragraph");
      System.out.println("3. count number of word A in paragraph");
      System.out.println("4. standardize words");
      System.out.println("5. stop");
      String choose = InputUtil.inputString(">>> input your choose: ");

      switch (choose) {
        case "1": {
          String str = InputUtil.inputString("input paragraph: ");
          paragraph = new Paragraph(str);
          break;
        }

        case "2": {
          if (paragraph == null) {
            System.err.println(ERROR_MESSAGE);
          } else {
            int count = paragraph.countWords();
            System.out.println("Number of words: " + count);
          }
          break;
        }

        case "3": {
          if (paragraph == null) {
            System.err.println(ERROR_MESSAGE);
          } else {
            int count = paragraph.countTheNumberOfCharacters('A');
            System.out.println("Number of word A in paragraph: " + count);
          }
          break;
        }

        case "4": {
          if (paragraph == null) {
            System.err.println(ERROR_MESSAGE);
          } else {
            String resultStandardize = paragraph.standardizeParagraph();
            System.out.println("Result standardize: " + resultStandardize);
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
}
