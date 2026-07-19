package VintageVinylStore.test;

import model.ReceiptOrder;
import service.ReceiptDispatcher;

public class Feature09Test4 {

  public static void run() {

    ReceiptDispatcher dispatcher = new ReceiptDispatcher();

    ReceiptOrder order = new ReceiptOrder(
        "ORD1004",
        799.00, true);

    boolean printed = dispatcher.printAndEmail(
        order,
        "customer@test.com");

    if (printed) {

      System.out.println(
          "Feature09 Test4 Passed");

    } else {

      System.out.println(
          "Feature09 Test4 Failed");

    }

  }

}