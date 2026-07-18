package model;

import java.time.LocalDateTime;

public class Reservation implements Comparable<Reservation> {

  private long reservationId;
  private String customerId;
  private long inventoryId;
  private LocalDateTime reservedAt;
  private LocalDateTime expiresAt;
  private boolean active;

  public Reservation(long reservationId,
      String customerId,
      long inventoryId,
      LocalDateTime reservedAt,
      LocalDateTime expiresAt) {

    this.reservationId = reservationId;
    this.customerId = customerId;
    this.inventoryId = inventoryId;
    this.reservedAt = reservedAt;
    this.expiresAt = expiresAt;
    this.active = true;
  }

  public long getReservationId() {
    return reservationId;
  }

  public String getCustomerId() {
    return customerId;
  }

  public long getInventoryId() {
    return inventoryId;
  }

  public LocalDateTime getReservedAt() {
    return reservedAt;
  }

  public LocalDateTime getExpiresAt() {
    return expiresAt;
  }

  public boolean isActive() {
    return active;
  }

  public void release() {
    active = false;
  }

  @Override
  public int compareTo(Reservation other) {
    return this.expiresAt.compareTo(other.expiresAt);
  }

  @Override
  public String toString() {

    return "Reservation{" +
        "reservationId=" + reservationId +
        ", customerId='" + customerId + '\'' +
        ", inventoryId=" + inventoryId +
        ", reservedAt=" + reservedAt +
        ", expiresAt=" + expiresAt +
        ", active=" + active +
        '}';
  }
}