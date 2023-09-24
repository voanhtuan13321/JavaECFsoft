package org.example.bai5;


import org.example.common.InputUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class Main {
  private static List<Room> rooms = new ArrayList<>();

  static {
    rooms.add(new Room("001", 0, RoomType.A, RoomStatus.OFF, null));
    rooms.add(new Room("002", 0, RoomType.B, RoomStatus.OFF, null));
    rooms.add(new Room("003", 0, RoomType.C, RoomStatus.OFF, null));
    rooms.add(new Room("004", 0, RoomType.A, RoomStatus.OFF, null));
    rooms.add(new Room("005", 0, RoomType.B, RoomStatus.OFF, null));
    rooms.add(new Room("006", 0, RoomType.C, RoomStatus.OFF, null));
    rooms.add(new Room("007", 0, RoomType.A, RoomStatus.OFF, null));
    rooms.add(new Room("008", 0, RoomType.B, RoomStatus.OFF, null));
    rooms.add(new Room("009", 0, RoomType.C, RoomStatus.OFF, null));
    rooms.add(new Room("010", 0, RoomType.A, RoomStatus.OFF, null));
  }

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n\n\n=== menu ===");
      System.out.println("1. add client");
      System.out.println("2. show list room");
      System.out.println("3. remove client by cmnd");
      System.out.println("4. calculate price by cmnd");
      System.out.println("5. stop");
      String choose = InputUtil.inputString(">>> input your choose: ");

      switch (choose) {
        case "1": {
          showListRoomOff();
          inputRoom();
          break;
        }

        case "2": {
          showAllRoom();
          break;
        }

        case "3": {
          String cmnd = InputUtil.inputString("cmnd: ");
          boolean isSuccess = removeClientBycmnd(cmnd);
          String message = isSuccess ? "Remove client successfully" : "don't find client by cmnd " + cmnd;
          System.err.println(message);
          break;
        }

        case "4": {
          String cmnd = InputUtil.inputString("cmnd: ");
          double price = caculatePriceByCmnd(cmnd);
          if (price == -1) {
            System.err.println("don't find cmnd " + cmnd);
          } else {
            System.out.println("price: " + price);
          }
          break;
        }

        case "5": {
          System.out.println("Stop");
          return;
        }

        default:
          break;
      }
    }
  }

  private static double caculatePriceByCmnd(String cmnd) {
    for (Room r : rooms) {
      boolean isMatch = r.getPersons()
          .stream()
          .anyMatch(p -> p.getCmnd().equals(cmnd));

      if (isMatch) {
        return r.calculatePrice();
      }
    }
    return -1;
  }

  private static boolean removeClientBycmnd(String cmnd) {
    Iterator<Room> roomIterator = rooms.iterator();
    while (roomIterator.hasNext()) {
      Room room = roomIterator.next();
      Iterator<Person> personIterator = room.getPersons().iterator();
      while (personIterator.hasNext()) {
        Person person = personIterator.next();
        if (person.getCmnd().equals(cmnd)) {
          personIterator.remove();
          return true;
        }
      }
    }
    return false;
  }

  private static void showAllRoom() {
    rooms.forEach(room -> {
      System.out.println(room);
      room.getPersons().forEach(System.out::println);
    });
  }

  private static void inputRoom() {
    String idRoom = "";
    while (true) {
      idRoom = InputUtil.inputString("id room: ");
      if (isIdRoomExist(idRoom)) {
        break;
      } else {
        System.err.println("id room not exists or status on, please enter again");
      }
    }
    int numberOfRentalDays = InputUtil.inputInteger("number of rental days: ");
    RoomType roomType = null;
    while (true) {
      try {
        roomType = RoomType.valueOf(InputUtil.inputString("room type(A, B, C): "));
        break;
      } catch (IllegalArgumentException e) {
        System.err.println("input invalid, please enter again");
      }
    }
    
    List<Person> persons = inputPersons();

    String finalIdRoom = idRoom;
    RoomType finalRoomType = roomType;
    rooms = rooms.stream()
        .map(room -> {
          if (room.getIdRoom().equals(finalIdRoom)) {
            return new Room(finalIdRoom, numberOfRentalDays, finalRoomType, RoomStatus.ON, persons);
          }
          return room;
        })
        .collect(Collectors.toList());
  }

  private static List<Person> inputPersons() {
    List<Person> persons = new ArrayList<>();
    int numberOfPersons = InputUtil.inputInteger("number of persons: ");
    for (int i = 1; i <= numberOfPersons; i++) {
      System.out.println(">>> enter info person " + i);
      String cmnd = inputCmnd();
      String name = InputUtil.inputString("name: ");
      int age = InputUtil.inputInteger("age: ");
      persons.add(new Person(cmnd,name,age));
    }

    return persons;
  }

  private static String inputCmnd() {
    String cmnd = "";
    while (true) {
      cmnd = InputUtil.inputString("cmnd: ");
      if (isCmndExist(cmnd)) {
        System.err.println("already cmnd, please enter again");
      } else {
        break;
      }
    }
    return cmnd;
  }

  private static boolean isCmndExist(String cmnd) {
    List<Room> resultFilter = rooms.stream()
        .filter(room -> room.getStatus() == RoomStatus.ON)
        .collect(Collectors.toList());

    for (Room room : resultFilter) {
      boolean isMatch = room.getPersons()
          .stream()
          .anyMatch(person -> person.getCmnd().equals(cmnd));

      if (isMatch) {
        return true;
      }
    }
    return false;
  }

  private static boolean isIdRoomExist(String idRoom) {
    return rooms.stream()
        .anyMatch(room -> room.getStatus() == RoomStatus.ON || room.getIdRoom().equals(idRoom));
  }

  private static void showListRoomOff() {
    System.out.println("List Room have status is Off");
    rooms.stream()
        .filter(room -> room.getStatus() == RoomStatus.OFF)
        .forEach(room -> System.out.println("id room: " + room.getIdRoom()));
  }
}
