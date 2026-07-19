package VintageVinylStore.test;

import java.io.File;

import model.ReceiptOrder;
import renderer.PdfReceiptRenderer;
import repository.ReceiptStorage;

public class Feature09Test2 {

  public static void run() {

    try {

      ReceiptOrder order = new ReceiptOrder(
          "ORD1002",
          450.00, true);

      PdfReceiptRenderer renderer = new PdfReceiptRenderer();

      String content = new String(
          renderer.render(order));

      ReceiptStorage storage = new ReceiptStorage();

      String filePath = storage.savePdf(
          order.getOrderId(),
          content);

      File file = new File(filePath);

      if (file.exists()) {

        System.out.println(
            "Feature09 Test2 Passed");

      } else {

        System.out.println(
            "Feature09 Test2 Failed");

      }

    } catch (Exception e) {

      System.out.println(
          "Feature09 Test2 Failed");

    }

  }

}