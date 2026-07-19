package service;

import java.util.ArrayList;
import java.util.List;

import exceptions.PrinterOfflineException;
import model.ReceiptOrder;
import exceptions.EmailDispatchException;
import exceptions.ReceiptRenderException;

public class ReceiptDispatcher {
  private List<String> auditLog;
  private List<ReceiptOrder> pendingJobs;
  private List<ReceiptOrder> failedJobs;
  private EmailService emailService;

  public ReceiptDispatcher() {

    pendingJobs = new ArrayList<>();
    failedJobs = new ArrayList<>();
    auditLog = new ArrayList<>();
    emailService = new EmailService();

  }

  public void print(ReceiptOrder order)
      throws PrinterOfflineException {

    pendingJobs.add(order);

    int retries = 0;

    while (retries < 5) {

      retries++;

      // Simulate printer still offline
    }

    pendingJobs.remove(order);
    failedJobs.add(order);

    throw new PrinterOfflineException(
        "Printer offline after 5 retries.");

  }

  public int getPendingCount() {

    return pendingJobs.size();

  }

  public int getFailedCount() {

    return failedJobs.size();

  }

  public boolean printAndEmail(
      ReceiptOrder order,
      String email) {

    System.out.println(
        "Receipt printed successfully.");

    try {

      emailService.sendReceipt(
          order,
          email);

    } catch (EmailDispatchException e) {

      System.out.println(
          e.getMessage());

    }

    return true;

  }

  public void validateOrder(
      ReceiptOrder order)
      throws ReceiptRenderException {

    if (!order.isPaid()) {

      throw new ReceiptRenderException(
          "Order is unpaid.");

    }

    System.out.println(
        "Order validated.");

  }

  public void reprint(String orderId) {

    auditLog.add("Reprinted : " + orderId);

    System.out.println(
        "Receipt reprinted for " + orderId);

  }

  public int getAuditCount() {

    return auditLog.size();

  }
}