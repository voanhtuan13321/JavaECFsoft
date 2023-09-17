package bai4;

import java.util.List;

/**
 * Family class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class Family {
  private String address;
  private List<Person> persons;

  public Family(String address, List<Person> persons) {
    this.address = address;
    this.persons = persons;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Person> getPersons() {
    return persons;
  }

  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }

  @Override
  public String toString() {
    return "Family{" +
        "address='" + address + '\'' +
        ", persons=" + persons +
        '}';
  }
}
