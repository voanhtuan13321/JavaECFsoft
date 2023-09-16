package bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * QLCB class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public class QLCB implements QLCBable {
  private final List<Officer> officers = new ArrayList<>();

  @Override
  public void addNewOfficer(Officer newOfficer) {
    officers.add(newOfficer);
  }

  @Override
  public List<Officer> findOfficerByFullName(String fullName) {
    List<Officer> result = officers
        .stream()
        .filter(officer -> officer.getFullName().equals(fullName))
        .collect(Collectors.toList());
    if (result.isEmpty()) {
      System.err.println("don't find officer with full name: " + fullName);
    }
    return result;
  }

  @Override
  public void showAllOfficers() {
    officers.forEach(System.out::println);
  }
}
