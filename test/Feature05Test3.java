package VintageVinylStore.test;

import java.math.BigDecimal;

import exceptions.TenderMismatchException;
import model.Tender;
import repository.InventoryRepository;
import service.LoyaltyService;
import service.POSCart;
import service.PaymentGateway;
import service.PricingService;

public class Feature05Test3 {

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

      cart.addTender(
          new Tender(
              "CASH",
              new BigDecimal("500"),
              null,
              null,
              null));

      cart.checkout();

      System.out.println(
          "Feature05 Test3 Failed");

    } catch (TenderMismatchException e) {

      System.out.println(e.getMessage());
      System.out.println("Feature05 Test3 Passed");

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}