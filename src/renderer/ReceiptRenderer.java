package renderer;

import model.ReceiptOrder;

public abstract class ReceiptRenderer {

  public abstract byte[] render(
      ReceiptOrder order);

}