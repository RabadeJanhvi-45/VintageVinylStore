package model;

import java.math.BigDecimal;

public class PayoutTier {

  private int fromDays;
  private int toDays;
  private BigDecimal payoutPct;

  public PayoutTier(int fromDays,
      int toDays,
      BigDecimal payoutPct) {

    this.fromDays = fromDays;
    this.toDays = toDays;
    this.payoutPct = payoutPct;

  }

  public int getFromDays() {
    return fromDays;
  }

  public int getToDays() {
    return toDays;
  }

  public BigDecimal getPayoutPct() {
    return payoutPct;
  }

}