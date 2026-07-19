package VintageVinylStore.test;

import service.ReceiptDispatcher;

public class Feature09Test6 {

  public static void run() {

    ReceiptDispatcher dispatcher = new ReceiptDispatcher();

    dispatcher.reprint("ORD1006");

    System.out.println(
        "Audit Entries = "
            + dispatcher.getAuditCount());

    if (dispatcher.getAuditCount() == 1) {

      System.out.println(
          "Feature09 Test6 Passed");

    } else {

      System.out.println(
          "Feature09 Test6 Failed");

    }

  }

}