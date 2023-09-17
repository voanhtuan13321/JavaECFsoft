package bai3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Admissions class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class Admission {
  private List<Candidate> candidates;

  public Admission() {
    candidates = new ArrayList<>();
  }

  public boolean isIdentificationNumberExist(String identifier) {
    return candidates
        .stream()
        .anyMatch(can -> can.getIdentificationNumber().equals(identifier));
  }
  public void addNewCandidate(Candidate newCandidate) {
    candidates.add(newCandidate);
  }

  public void showInformationCandidate() {
    candidates.forEach(System.out::println);
  }

  public Candidate findCandidateByIdentifierNumber(String identifier) {
    if (!isIdentificationNumberExist(identifier)) {
      return null;
    }
    return candidates
        .stream()
        .filter(can -> can.getIdentificationNumber().equals(identifier))
        .collect(Collectors.toList())
        .get(0);
  }
}
