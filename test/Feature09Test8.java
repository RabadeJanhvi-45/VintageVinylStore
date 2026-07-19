package VintageVinylStore.test;

import repository.ReceiptStorage;

public class Feature09Test8 {

  public static void run() {

    ReceiptStorage storage = new ReceiptStorage();

    String path = storage.getRetentionPath();

    System.out.println(
        "Retention Path = "
            + path);

    if (path.matches(
        "receipts/\\d{4}/\\d{2}/\\d{2}")) {

      System.out.println(
          "Feature09 Test8 Passed");

    } else {

      System.out.println(
          "Feature09 Test8 Failed");

    }

  }

}