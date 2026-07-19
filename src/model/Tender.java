package model;

import java.math.BigDecimal;

public class Tender {

  private String type;
  private BigDecimal amount;

  private String cardToken;
  private String voucherCode;
  private String storeCreditTxn;

  public Tender(String type,
      BigDecimal amount,
      String cardToken,
      String voucherCode,
      String storeCreditTxn) {

    this.type = type;
    this.amount = amount;
    this.cardToken = cardToken;
    this.voucherCode = voucherCode;
    this.storeCreditTxn = storeCreditTxn;
  }

  public String getType() {
    return type;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getCardToken() {
    return cardToken;
  }

  public String getVoucherCode() {
    return voucherCode;
  }

  public String getStoreCreditTxn() {
    return storeCreditTxn;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {

    return "Tender{" +
        "type='" + type + '\'' +
        ", amount=" + amount +
        ", cardToken='" + cardToken + '\'' +
        ", voucherCode='" + voucherCode + '\'' +
        ", storeCreditTxn='" + storeCreditTxn + '\'' +
        '}';

  }

}