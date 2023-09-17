package bai3;

import java.util.ArrayList;
import java.util.List;

/**
 * BlockB class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class BlockB extends Block {
  public BlockB() {
    List<String> subjects = new ArrayList<>();
    subjects.add("toan");
    subjects.add("sinh");
    subjects.add("hoa");
    super.setSubjects(subjects);
  }
}
