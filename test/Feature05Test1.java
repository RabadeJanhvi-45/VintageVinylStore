package VintageVinylStore.test;

import java.math.BigDecimal;

import exceptions.OutOfStockException;
import repository.InventoryRepository;
import service.LoyaltyService;
import service.POSCart;
import service.PaymentGateway;
import service.PricingService;

public class Feature05Test1 {

  public static void run() {

    try {

      InventoryRepository inventoryRepo = new InventoryRepository();

      inventoryRepo.addInventory(
          101,
          5,
          new BigDecimal("500.00"));

      POSCart cart = new POSCart(
          inventoryRepo,
          new PricingService(),
          new LoyaltyService(),
          new PaymentGateway());

      // Trying to add more than available quantity
      cart.addItem(101, 10);

      System.out.println("Feature05 Test1 Failed");

    } catch (OutOfStockException e) {

      System.out.println(e.getMessage());
      System.out.println("Feature05 Test1 Passed");

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}