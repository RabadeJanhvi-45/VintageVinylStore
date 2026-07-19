package service;

import model.CartLine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PricingService {

  public BigDecimal calculateCartTotal(List<CartLine> cartLines) {

    BigDecimal total = BigDecimal.ZERO;

    for (CartLine line : cartLines) {
      total = total.add(line.getLineTotal());
    }

    return total.setScale(2, RoundingMode.HALF_UP);
  }

}