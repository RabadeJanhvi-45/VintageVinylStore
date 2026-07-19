package renderer;

import model.ReceiptOrder;

public class PdfReceiptRenderer
    extends ReceiptRenderer {

  @Override
  public byte[] render(
      ReceiptOrder order) {

    String pdf = "PDF RECEIPT\n"
        + "Order : "
        + order.getOrderId()
        + "\nAmount : "
        + order.getAmount();

    return pdf.getBytes();

  }

}