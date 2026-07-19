package repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class InventoryRepository {

  private final Map<Long, Integer> quantities;
  private final Map<Long, BigDecimal> prices;

  public InventoryRepository() {

    quantities = new HashMap<>();
    prices = new HashMap<>();

  }

  public void addInventory(long inventoryId,
      int quantity,
      BigDecimal price) {

    quantities.put(inventoryId, quantity);
    prices.put(inventoryId, price);

  }

  public int getAvailableQuantity(long inventoryId) {

    return quantities.getOrDefault(inventoryId, 0);

  }

  public BigDecimal getPrice(long inventoryId) {

    return prices.getOrDefault(
        inventoryId,
        BigDecimal.ZERO);

  }

  public void reduceQuantity(long inventoryId,
      int qty) {

    int currentQty = quantities.getOrDefault(inventoryId, 0);

    quantities.put(
        inventoryId,
        currentQty - qty);

  }

}