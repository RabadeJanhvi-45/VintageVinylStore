package VintageVinylStore.test;

import exceptions.StorageQuotaException;
import repository.ReceiptStorage;

public class Feature09Test7 {

  public static void run() {

    ReceiptStorage storage = new ReceiptStorage();

    try {

      for (int i = 1; i <= 6; i++) {

        storage.storeReceipt(
            "Receipt " + i);

      }

      System.out.println(
          "Feature09 Test7 Failed");

    } catch (StorageQuotaException e) {

      System.out.println(
          e.getMessage());

      System.out.println(
          "Stored = "
              + storage.getStoredReceipts());

      if (storage.getStoredReceipts() == 5) {

        System.out.println(
            "Feature09 Test7 Passed");

      } else {

        System.out.println(
            "Feature09 Test7 Failed");

      }

    }

  }

}