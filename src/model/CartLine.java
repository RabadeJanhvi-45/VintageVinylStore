package model;

import java.math.BigDecimal;

public class CartLine {

  private long inventoryId;
  private BigDecimal unitPrice;
  private int qty;
  private BigDecimal lineDiscount;

  public CartLine(long inventoryId,
      BigDecimal unitPrice,
      int qty,
      BigDecimal lineDiscount) {

    this.inventoryId = inventoryId;
    this.unitPrice = unitPrice;
    this.qty = qty;
    this.lineDiscount = lineDiscount;
  }

  public long getInventoryId() {
    return inventoryId;
  }

  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  public int getQty() {
    return qty;
  }

  public BigDecimal getLineDiscount() {
    return lineDiscount;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public void setLineDiscount(BigDecimal lineDiscount) {
    this.lineDiscount = lineDiscount;
  }

  public BigDecimal getLineTotal() {

    BigDecimal total = unitPrice.multiply(BigDecimal.valueOf(qty));

    return total.subtract(lineDiscount);
  }

  @Override
  public String toString() {

    return "CartLine{" +
        "inventoryId=" + inventoryId +
        ", unitPrice=" + unitPrice +
        ", qty=" + qty +
        ", lineDiscount=" + lineDiscount +
        '}';

  }

}