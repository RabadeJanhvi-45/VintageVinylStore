package renderer;

import model.ReceiptOrder;

public class ThermalEscPosRenderer
    extends ReceiptRenderer {

  @Override
  public byte[] render(
      ReceiptOrder order) {

    String receipt = "\u001B@" +
        "Order : " + order.getOrderId() + "\n" +
        "Amount: " + order.getAmount();

    return receipt.getBytes();

  }

}