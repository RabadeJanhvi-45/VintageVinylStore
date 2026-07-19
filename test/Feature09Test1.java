package VintageVinylStore.test;

import model.ReceiptOrder;
import renderer.ThermalEscPosRenderer;

public class Feature09Test1 {

  public static void run() {

    ReceiptOrder order = new ReceiptOrder(
        "ORD1001",
        299.99,
        true);

    ThermalEscPosRenderer renderer = new ThermalEscPosRenderer();

    byte[] bytes = renderer.render(order);

    if (bytes.length > 0
        && bytes[0] == 27) {

      System.out.println(
          "Feature09 Test1 Passed");

    } else {

      System.out.println(
          "Feature09 Test1 Failed");

    }

  }

}