package bai3;

import java.util.List;

/**
 * Block class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public abstract class Block {
  private List<String> subjects;

  public List<String> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<String> subjects) {
    this.subjects = subjects;
  }

  @Override
  public String toString() {
    return "Block{" +
        "subjects=" + subjects +
        '}';
  }
}
