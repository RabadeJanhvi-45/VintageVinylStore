package VintageVinylStore.test;

import exceptions.PrinterOfflineException;
import model.ReceiptOrder;
import service.ReceiptDispatcher;

public class Feature09Test3 {

  public static void run() {

    ReceiptDispatcher dispatcher = new ReceiptDispatcher();

    ReceiptOrder order = new ReceiptOrder(
        "ORD1003",
        599.00, true);

    try {

      dispatcher.print(order);

      System.out.println(
          "Feature09 Test3 Failed");

    } catch (PrinterOfflineException e) {

      System.out.println(e.getMessage());

      System.out.println(
          "Pending Jobs = "
              + dispatcher.getPendingCount());

      System.out.println(
          "Failed Jobs = "
              + dispatcher.getFailedCount());

      if (dispatcher.getPendingCount() == 0
          && dispatcher.getFailedCount() == 1) {

        System.out.println(
            "Feature09 Test3 Passed");

      } else {

        System.out.println(
            "Feature09 Test3 Failed");

      }

    }

  }

}