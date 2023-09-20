package org.example.bai1;

/**
 * Worker class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class Worker extends Officer {
  private Level level;

  public Worker(String fullName, int age, Sex sex, String address, Level level) {
    super(fullName, age, sex, address);
    this.level = level;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  @Override
  public String toString() {
    return "Worker{" +
        super.toString() + "," +
        "level=" + level +
        '}';
  }
}
