package service;

import exceptions.PaymentDeclinedException;
import model.Tender;

public class PaymentGateway {

  private boolean paymentSuccess = true;

  public void setPaymentSuccess(boolean paymentSuccess) {
    this.paymentSuccess = paymentSuccess;
  }

  public void processPayment(Tender tender)
      throws PaymentDeclinedException {

    if (!paymentSuccess) {

      throw new PaymentDeclinedException(
          "Payment Declined.");

    }

    System.out.println(
        "Payment Successful : "
            + tender.getType()
            + " ₹"
            + tender.getAmount());

  }

}