package service;

import exceptions.EmailDispatchException;
import model.ReceiptOrder;

public class EmailService {

  public void sendReceipt(
      ReceiptOrder order,
      String email)
      throws EmailDispatchException {

    throw new EmailDispatchException(
        "Email delivery failed.");

  }

}