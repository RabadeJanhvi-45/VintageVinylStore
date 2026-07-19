package VintageVinylStore.test;

import java.math.BigDecimal;

import repository.InventoryRepository;
import service.LoyaltyService;
import service.POSCart;
import service.PaymentGateway;
import service.PricingService;

public class Feature05Test5 {

  public static void run() {

    try {

      InventoryRepository repo = new InventoryRepository();

      repo.addInventory(
          101,
          5,
          new BigDecimal("1000"));

      POSCart cart = new POSCart(
          repo,
          new PricingService(),
          new LoyaltyService(),
          new PaymentGateway());

      // First reservation
      cart.addItem(101, 1);

      // Add same inventory again
      cart.addItem(101, 1);

      System.out.println("Feature05 Test5 Passed");

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}