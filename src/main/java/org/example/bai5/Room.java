package org.example.bai5;

import java.util.List;

/**
 * Room class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Room {
  private String idRoom;
  private int numberOfRentalDays;
  private RoomType roomType;
  private RoomStatus status;
  private List<Person> persons;

  public Room(String idRoom, int numberOfRentalDays, RoomType roomType, RoomStatus status, List<Person> persons) {
    this.idRoom = idRoom;
    this.numberOfRentalDays = numberOfRentalDays;
    this.roomType = roomType;
    this.status = status;
    this.persons = persons;
  }

  public String getIdRoom() {
    return idRoom;
  }

  public void setIdRoom(String idRoom) {
    this.idRoom = idRoom;
  }

  public int getNumberOfRentalDays() {
    return numberOfRentalDays;
  }

  public void setNumberOfRentalDays(int numberOfRentalDays) {
    this.numberOfRentalDays = numberOfRentalDays;
  }

  public RoomType getRoomType() {
    return roomType;
  }

  public void setRoomType(RoomType roomType) {
    this.roomType = roomType;
  }

  public RoomStatus getStatus() {
    return status;
  }

  public void setStatus(RoomStatus status) {
    this.status = status;
  }

  public List<Person> getPersons() {
    return persons;
  }

  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }

  @Override
  public String toString() {
    return "Room{" +
        "idRoom='" + idRoom + '\'' +
        ", numberOfRentalDays=" + numberOfRentalDays +
        ", roomType=" + roomType +
        ", status=" + status +
        ", persons=" + persons +
        '}';
  }

  public double calculatePrice() {
    double price = (roomType == RoomType.A) ? 500 : (roomType == RoomType.B ? 300 : 100);
    return numberOfRentalDays * price;
  }
}
