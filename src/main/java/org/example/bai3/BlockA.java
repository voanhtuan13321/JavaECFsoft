package org.example.bai3;

import java.util.ArrayList;
import java.util.List;

/**
 * BlockA class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class BlockA extends Block {
  public BlockA() {
    List<String> subjects = new ArrayList<>();
    subjects.add("toan");
    subjects.add("ly");
    subjects.add("hoa");
    super.setSubjects(subjects);
  }
}
