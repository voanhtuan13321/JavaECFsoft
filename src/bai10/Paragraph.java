package bai10;

/**
 * Paragraph class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class Paragraph {
  private String paragraph;

  public Paragraph(String paragraph) {
    this.paragraph = paragraph;
  }

  public String getParagraph() {
    return paragraph;
  }

  public void setParagraph(String paragraph) {
    this.paragraph = paragraph;
  }

  @Override
  public String toString() {
    return "Paragraph{" +
        "paragraph='" + paragraph + '\'' +
        '}';
  }

  public int countWords() {
    String[] words = paragraph.trim().split("\\s+");
    return words.length;
  }

  public int countTheNumberOfCharacters(char c) {
    int count = 0;
    int length = paragraph.trim().length();
    c = convertCharToUpperCase(c);

    for (int i = 0; i < length; i++) {
      char temp = convertCharToUpperCase(paragraph.charAt(i));
      if (temp == c) {
        count++;
      }
    }

    return count;
  }

  private char convertCharToUpperCase(char c) {
    return (c >= 97 && c <= 122) ? (char)(c - 32) : c;
  }

  public String standardizeParagraph() {
    return paragraph.trim().replaceAll("\\s+", " ");
  }
}
