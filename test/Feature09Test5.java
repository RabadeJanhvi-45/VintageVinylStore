package VintageVinylStore.test;

import exceptions.ReceiptRenderException;
import model.ReceiptOrder;
import service.ReceiptDispatcher;

public class Feature09Test5 {

  public static void run() {

    ReceiptDispatcher dispatcher = new ReceiptDispatcher();

    ReceiptOrder order = new ReceiptOrder(
        "ORD1005",
        950.00,
        false);

    try {

      dispatcher.validateOrder(order);

      System.out.println(
          "Feature09 Test5 Failed");

    } catch (ReceiptRenderException e) {

      System.out.println(
          e.getMessage());

      System.out.println(
          "Feature09 Test5 Passed");

    }

  }

}