package VintageVinylStore.test;

import java.math.BigDecimal;

import exceptions.PaymentDeclinedException;
import model.Tender;
import repository.InventoryRepository;
import service.LoyaltyService;
import service.POSCart;
import service.PaymentGateway;
import service.PricingService;

public class Feature05Test4 {

  public static void run() {

    POSCart cart = null;

    try {

      InventoryRepository repo = new InventoryRepository();

      repo.addInventory(
          101,
          5,
          new BigDecimal("1000"));

      PaymentGateway gateway = new PaymentGateway();

      gateway.setPaymentSuccess(false);

      cart = new POSCart(
          repo,
          new PricingService(),
          new LoyaltyService(),
          gateway);

      cart.addItem(101, 1);

      cart.addTender(
          new Tender(
              "CARD",
              new BigDecimal("1000"),
              "TOKEN123",
              null,
              null));

      cart.checkout();

      System.out.println("Feature05 Test4 Failed");

    } catch (PaymentDeclinedException e) {

      System.out.println(e.getMessage());

      if (cart != null && cart.getCartSize() == 1) {

        System.out.println("Cart preserved.");

      }

      System.out.println("Feature05 Test4 Passed");

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}