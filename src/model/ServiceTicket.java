package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceTicket {

  private long id;
  private String equipmentType;
  private String brand;
  private String model;
  private String status;
  private LocalDate receivedAt;
  private BigDecimal authorisedLimit;
  private BigDecimal currentQuote;
  private int contactAttempts;
  private List<String> eventLog = new ArrayList<>();
  private boolean assigned;

  public ServiceTicket(long id,
      String equipmentType,
      String brand,
      String model,
      String status,
      LocalDate receivedAt,
      BigDecimal authorisedLimit,
      BigDecimal currentQuote,
      int contactAttempts) {

    this.id = id;
    this.equipmentType = equipmentType;
    this.brand = brand;
    this.model = model;
    this.status = status;
    this.receivedAt = receivedAt;
    this.authorisedLimit = authorisedLimit;
    this.currentQuote = currentQuote;
    this.contactAttempts = contactAttempts;

  }

  public long getId() {
    return id;
  }

  public String getStatus() {
    return status;
  }

  public LocalDate getReceivedAt() {
    return receivedAt;
  }

  public BigDecimal getCurrentQuote() {
    return currentQuote;
  }

  public void setCurrentQuote(BigDecimal currentQuote) {
    this.currentQuote = currentQuote;
  }

  public int getContactAttempts() {
    return contactAttempts;
  }

  public void setContactAttempts(int contactAttempts) {
    this.contactAttempts = contactAttempts;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void addEvent(String event) {

    eventLog.add(event);

  }

  public List<String> getEventLog() {

    return eventLog;

  }

  public boolean isAssigned() {

    return assigned;

  }

  public void setAssigned(boolean assigned) {

    this.assigned = assigned;

  }
}