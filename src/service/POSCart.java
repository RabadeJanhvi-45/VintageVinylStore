package service;

import exceptions.OutOfStockException;
import exceptions.PaymentDeclinedException;
import exceptions.TenderMismatchException;
import model.CartLine;
import model.Tender;
import repository.InventoryRepository;

import java.math.BigDecimal;
import java.util.*;

public class POSCart {

  private final InventoryRepository inventoryRepo;
  private final PricingService pricingService;
  private final LoyaltyService loyaltyService;
  private final PaymentGateway paymentGateway;

  private final List<CartLine> cartLines;
  private final List<Tender> tenders;
  private final Set<Long> reservedInventoryIds;
  private final Map<Long, BigDecimal> inflightPrices;

  private BigDecimal orderDiscount;

  public POSCart(InventoryRepository inventoryRepo,
      PricingService pricingService,
      LoyaltyService loyaltyService,
      PaymentGateway paymentGateway) {

    this.inventoryRepo = inventoryRepo;
    this.pricingService = pricingService;
    this.loyaltyService = loyaltyService;
    this.paymentGateway = paymentGateway;

    this.cartLines = new ArrayList<>();
    this.tenders = new ArrayList<>();
    this.reservedInventoryIds = new HashSet<>();
    this.inflightPrices = new HashMap<>();

    this.orderDiscount = BigDecimal.ZERO;
  }

  public void addItem(long inventoryId,
      int qty)
      throws OutOfStockException {

    int availableQty = inventoryRepo.getAvailableQuantity(inventoryId);

    if (qty > availableQty) {

      throw new OutOfStockException(
          "Insufficient stock available.");

    }

    if (reservedInventoryIds.contains(inventoryId)) {

      System.out.println(
          "Warning: Inventory " + inventoryId
              + " is already reserved.");

    }

    BigDecimal price = inventoryRepo.getPrice(inventoryId);

    CartLine line = new CartLine(
        inventoryId,
        price,
        qty,
        BigDecimal.ZERO);

    cartLines.add(line);

    reservedInventoryIds.add(inventoryId);

    inflightPrices.put(
        inventoryId,
        price);

  }

  public void removeLine(long inventoryId) {

    cartLines.removeIf(
        line -> line.getInventoryId() == inventoryId);

    reservedInventoryIds.remove(
        inventoryId);

    inflightPrices.remove(
        inventoryId);

  }

  public void addTender(Tender tender) {

    tenders.add(tender);

  }

  public void applyLineDiscount(long inventoryId,
      double percentage,
      String appliedBy,
      String reason) {

    if (percentage > 10
        && !appliedBy.equalsIgnoreCase("Manager")) {

      throw new IllegalArgumentException(
          "Manager approval required.");

    }

    for (CartLine line : cartLines) {

      if (line.getInventoryId() == inventoryId) {

        BigDecimal discount = line.getUnitPrice()
            .multiply(
                BigDecimal.valueOf(
                    percentage / 100));

        line.setLineDiscount(discount);

        return;
      }

    }

  }

  public void checkout()
      throws TenderMismatchException,
      PaymentDeclinedException {

    BigDecimal cartTotal = pricingService.calculateCartTotal(cartLines);

    cartTotal = cartTotal.subtract(orderDiscount);

    BigDecimal tenderTotal = BigDecimal.ZERO;

    for (Tender tender : tenders) {

      tenderTotal = tenderTotal.add(tender.getAmount());

    }

    if (cartTotal.compareTo(tenderTotal) != 0) {

      throw new TenderMismatchException(
          "Tender amount does not match cart total.");

    }

    for (Tender tender : tenders) {

      paymentGateway.processPayment(tender);

    }

    int points = loyaltyService.calculatePoints(cartTotal);

    loyaltyService.addPoints(
        "CUST101",
        points);

    printReceipt();

    System.out.println(
        "Checkout Successful");

    for (Tender tender : tenders) {

      paymentGateway.processPayment(tender);

    }
    for (CartLine line : cartLines) {

      inventoryRepo.reduceQuantity(
          line.getInventoryId(),
          line.getQty());

    }
  }

  public int getCartSize() {

    return cartLines.size();

  }

  public void printReceipt() {

    System.out.println("\n========== RECEIPT ==========");

    BigDecimal total = BigDecimal.ZERO;

    for (CartLine line : cartLines) {

      System.out.println(
          "Inventory ID : " + line.getInventoryId());

      System.out.println(
          "Quantity     : " + line.getQty());

      System.out.println(
          "Unit Price   : ₹" + line.getUnitPrice());

      System.out.println(
          "Line Total   : ₹" + line.getLineTotal());

      System.out.println("-----------------------------");

      total = total.add(line.getLineTotal());

    }

    total = total.subtract(orderDiscount);

    System.out.println("Order Discount : ₹" + orderDiscount);
    System.out.println("Grand Total    : ₹" + total);
    System.out.println("=============================\n");

  }

}