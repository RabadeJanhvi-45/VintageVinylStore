package service;

import java.math.BigDecimal;

public class LoyaltyService {

  public int calculatePoints(BigDecimal amount) {

    return amount.divide(
        BigDecimal.valueOf(100))
        .intValue();

  }

  public void addPoints(String customerId,
      int points) {

    System.out.println(
        "Loyalty Points Added : "
            + points
            + " to Customer "
            + customerId);

  }

}