package bai8;

import java.time.LocalDate;

/**
 * TicketBook class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 14/09/2023
 */
public class TicketBook {
  private String ticketId;
  private LocalDate borrowedDay;
  private LocalDate payDay;

  private String bookId;
  private Student student;

  public TicketBook() {
  }

  public TicketBook(String ticketId, LocalDate borrowedDay, LocalDate payDay, String bookId, Student student) {
    this.ticketId = ticketId;
    this.borrowedDay = borrowedDay;
    this.payDay = payDay;
    this.bookId = bookId;
    this.student = student;
  }

  public String getTicketId() {
    return ticketId;
  }

  public void setTicketId(String ticketId) {
    this.ticketId = ticketId;
  }

  public LocalDate getBorrowedDay() {
    return borrowedDay;
  }

  public void setBorrowedDay(LocalDate borrowedDay) {
    this.borrowedDay = borrowedDay;
  }

  public LocalDate getPayDay() {
    return payDay;
  }

  public void setPayDay(LocalDate payDay) {
    this.payDay = payDay;
  }

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  @Override
  public String toString() {
    return "TicketBook{" +
        "ticketId='" + ticketId + '\'' +
        ", borrowedDay=" + borrowedDay +
        ", payDay=" + payDay +
        ", bookId='" + bookId + '\'' +
        ", student=" + student +
        '}';
  }
}
