package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Consignment {

  private long id;
  private BigDecimal defaultPayoutPct;
  private List<PayoutTier> tiers;
  private BigDecimal saleFloor;
  private LocalDate listingDate;

  public Consignment(long id,
      BigDecimal defaultPayoutPct,
      List<PayoutTier> tiers,
      BigDecimal saleFloor,
      LocalDate listingDate) {

    this.id = id;
    this.defaultPayoutPct = defaultPayoutPct;
    this.tiers = tiers;
    this.saleFloor = saleFloor;
    this.listingDate = listingDate;

  }

  public long getId() {

    return id;

  }

  public BigDecimal getDefaultPayoutPct() {

    return defaultPayoutPct;

  }

  public List<PayoutTier> getTiers() {

    return tiers;

  }

  public BigDecimal getSaleFloor() {

    return saleFloor;

  }

  public LocalDate getListingDate() {

    return listingDate;

  }

  @Override
  public String toString() {

    return "Consignment{" +
        "id=" + id +
        ", defaultPayoutPct=" + defaultPayoutPct +
        ", saleFloor=" + saleFloor +
        ", listingDate=" + listingDate +
        '}';

  }

}