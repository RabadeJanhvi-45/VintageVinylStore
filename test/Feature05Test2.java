package VintageVinylStore.test;

import java.math.BigDecimal;

import repository.InventoryRepository;
import service.LoyaltyService;
import service.POSCart;
import service.PaymentGateway;
import service.PricingService;

public class Feature05Test2 {

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

      cart.addItem(101, 1);

      cart.applyLineDiscount(
          101,
          20,
          "Cashier",
          "Festival");

      System.out.println(
          "Feature05 Test2 Failed");

    } catch (IllegalArgumentException e) {

      System.out.println(
          e.getMessage());

      System.out.println(
          "Feature05 Test2 Passed");

    } catch (Exception e) {

      System.out.println(
          e.getMessage());

    }

  }

}
