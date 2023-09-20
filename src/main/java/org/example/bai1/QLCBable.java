package org.example.bai1;

import java.util.List;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 16/09/2023
 */
public interface QLCBable {
  void addNewOfficer(Officer newOfficer);
  List<Officer> findOfficerByFullName(String fullName);
  void showAllOfficers();

}
