package org.example.bai3;

/**
 * Candidate class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 17/09/2023
 */
public class Candidate {
  private String identificationNumber;
  private String name;
  private String address;
  private String priorityLevel;
  private Block block;

  public Candidate(String identificationNumber, String name, String address, String priorityLevel, Block block) {
    this.identificationNumber = identificationNumber;
    this.name = name;
    this.address = address;
    this.priorityLevel = priorityLevel;
    this.block = block;
  }

  public String getIdentificationNumber() {
    return identificationNumber;
  }

  public void setIdentificationNumber(String identificationNumber) {
    this.identificationNumber = identificationNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPriorityLevel() {
    return priorityLevel;
  }

  public void setPriorityLevel(String priorityLevel) {
    this.priorityLevel = priorityLevel;
  }

  public Block getBlock() {
    return block;
  }

  public void setBlock(Block block) {
    this.block = block;
  }

  @Override
  public String toString() {
    return "Candidate{" +
        "identificationNumber='" + identificationNumber + '\'' +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", priorityLevel='" + priorityLevel + '\'' +
        ", block=" + block +
        '}';
  }
}
