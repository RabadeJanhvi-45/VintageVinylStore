package VintageVinylStore.test;

import java.math.BigDecimal;

import model.Tender;
import repository.InventoryRepository;
import service.LoyaltyService;
import service.POSCart;
import service.PaymentGateway;
import service.PricingService;

public class Feature05Test8 {

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

      cart.addItem(101, 2);

      cart.addTender(
          new Tender(
              "CARD",
              new BigDecimal("2000"),
              "TOKEN123",
              null,
              null));

      cart.checkout();

      int remaining = repo.getAvailableQuantity(101);

      System.out.println(
          "Remaining Stock : " + remaining);

      if (remaining == 3) {

        System.out.println(
            "Feature05 Test8 Passed");

      } else {

        System.out.println(
            "Feature05 Test8 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}