package model;

import java.math.BigDecimal;

public class ValuationSettings {

  private BigDecimal storeCreditBonus;
  private BigDecimal maxOverridePercentage;
  private int minimumComparables;

  public ValuationSettings() {

    this.storeCreditBonus = new BigDecimal("0.20"); // 20%
    this.maxOverridePercentage = new BigDecimal("0.10"); // 10%
    this.minimumComparables = 5;
  }

  public BigDecimal getStoreCreditBonus() {
    return storeCreditBonus;
  }

  public BigDecimal getMaxOverridePercentage() {
    return maxOverridePercentage;
  }

  public int getMinimumComparables() {
    return minimumComparables;
  }

  public void setStoreCreditBonus(BigDecimal storeCreditBonus) {
    this.storeCreditBonus = storeCreditBonus;
  }

  public void setMaxOverridePercentage(BigDecimal maxOverridePercentage) {
    this.maxOverridePercentage = maxOverridePercentage;
  }

  public void setMinimumComparables(int minimumComparables) {
    this.minimumComparables = minimumComparables;
  }

  @Override
  public String toString() {

    return "ValuationSettings{" +
        "storeCreditBonus=" + storeCreditBonus +
        ", maxOverridePercentage=" + maxOverridePercentage +
        ", minimumComparables=" + minimumComparables +
        '}';
  }
}