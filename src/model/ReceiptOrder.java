package model;

public class ReceiptOrder {

  private String orderId;
  private double amount;
  private boolean paid;

  public ReceiptOrder(String orderId,
      double amount,
      boolean paid) {

    this.orderId = orderId;
    this.amount = amount;
    this.paid = paid;

  }

  public boolean isPaid() {

    return paid;

  }

  public String getOrderId() {

    return orderId;

  }

  public double getAmount() {

    return amount;

  }

}