package model;

import java.time.LocalDate;

public class Inventory {

  private int inventoryId;
  private String condition;
  private double purchasePrice;
  private LocalDate acquiredAt;
  private boolean available;

  public Inventory(int inventoryId,
      String condition,
      double purchasePrice,
      LocalDate acquiredAt) {

    this.inventoryId = inventoryId;
    this.condition = condition;
    this.purchasePrice = purchasePrice;
    this.acquiredAt = acquiredAt;
    this.available = true;
  }

  public int getInventoryId() {
    return inventoryId;
  }

  public String getCondition() {
    return condition;
  }

  public double getPurchasePrice() {
    return purchasePrice;
  }

  public LocalDate getAcquiredAt() {
    return acquiredAt;
  }

  public boolean isAvailable() {
    return available;
  }

  public void markSold() {
    available = false;
  }

  @Override
  public String toString() {
    return inventoryId + " | " + condition + " | ₹" + purchasePrice;
  }
}