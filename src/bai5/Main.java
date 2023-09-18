package bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Main {
  private final List<Room> rooms = new ArrayList<>();

  static {

  }

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    long size = list.stream().filter(s -> false).count();

  }
}
