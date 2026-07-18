package repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SoldHistoryRepository {

  private final List<BigDecimal> soldPrices;

  public SoldHistoryRepository() {

    soldPrices = new ArrayList<>();

  }

  public void addSoldPrice(BigDecimal price) {

    soldPrices.add(price);

  }

  public List<BigDecimal> getSoldPrices() {

    return soldPrices;

  }

  public int getComparableCount() {

    return soldPrices.size();

  }

  public BigDecimal calculateAveragePrice() {

    if (soldPrices.isEmpty()) {

      return BigDecimal.ZERO;

    }

    BigDecimal total = BigDecimal.ZERO;

    for (BigDecimal price : soldPrices) {

      total = total.add(price);

    }

    return total.divide(
        BigDecimal.valueOf(soldPrices.size()),
        2,
        java.math.RoundingMode.HALF_UP);

  }

}