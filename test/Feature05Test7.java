package VintageVinylStore.test;

import java.math.BigDecimal;

import model.Tender;
import repository.InventoryRepository;
import service.LoyaltyService;
import service.POSCart;
import service.PaymentGateway;
import service.PricingService;

public class Feature05Test7 {

  public static void run() {

    try {

      InventoryRepository repo = new InventoryRepository();

      repo.addInventory(
          101,
          5,
          new BigDecimal("1000"));

      repo.addInventory(
          102,
          3,
          new BigDecimal("500"));

      POSCart cart = new POSCart(
          repo,
          new PricingService(),
          new LoyaltyService(),
          new PaymentGateway());

      cart.addItem(101, 1);
      cart.addItem(102, 2);

      cart.addTender(
          new Tender(
              "CARD",
              new BigDecimal("2000"),
              "TOKEN123",
              null,
              null));

      cart.checkout();

      System.out.println(
          "Feature05 Test7 Passed");

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}