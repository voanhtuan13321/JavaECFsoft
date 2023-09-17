package bai3;

import java.util.ArrayList;
import java.util.List;

/**
 * BlockC class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class BlockC extends Block {
  public BlockC() {
    List<String> subjects = new ArrayList<>();
    subjects.add("van");
    subjects.add("su");
    subjects.add("dia");
    super.setSubjects(subjects);
  }
}
