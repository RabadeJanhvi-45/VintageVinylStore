package model;

import java.math.BigDecimal;

public class Valuation {

  private long pressingId;
  private BigDecimal wholesaleValue;
  private String confidenceBand;
  private boolean lowConfidence;
  private boolean suspicious;

  public Valuation(long pressingId,
      BigDecimal wholesaleValue,
      String confidenceBand,
      boolean lowConfidence,
      boolean suspicious) {

    this.pressingId = pressingId;
    this.wholesaleValue = wholesaleValue;
    this.confidenceBand = confidenceBand;
    this.lowConfidence = lowConfidence;
    this.suspicious = suspicious;
  }

  public long getPressingId() {
    return pressingId;
  }

  public BigDecimal getWholesaleValue() {
    return wholesaleValue;
  }

  public String getConfidenceBand() {
    return confidenceBand;
  }

  public boolean isLowConfidence() {
    return lowConfidence;
  }

  public boolean isSuspicious() {
    return suspicious;
  }

  @Override
  public String toString() {

    return "Valuation{" +
        "pressingId=" + pressingId +
        ", wholesaleValue=" + wholesaleValue +
        ", confidenceBand='" + confidenceBand + '\'' +
        ", lowConfidence=" + lowConfidence +
        ", suspicious=" + suspicious +
        '}';
  }
}