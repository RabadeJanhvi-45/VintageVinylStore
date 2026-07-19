package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import exceptions.BelowFloorSaleException;
import exceptions.StatementPeriodOverlapException;
import exceptions.TierOverlapException;
import model.Consignment;
import model.PayoutTier;
import repository.ConsignmentRepository;
import repository.LedgerRepository;

public class ConsignmentPayoutCalculator {

  private final ConsignmentRepository consignmentRepo;
  private final LedgerRepository ledgerRepo;

  public ConsignmentPayoutCalculator(
      ConsignmentRepository consignmentRepo,
      LedgerRepository ledgerRepo) {

    this.consignmentRepo = consignmentRepo;
    this.ledgerRepo = ledgerRepo;

  }

  public void validateTiers(Consignment consignment)
      throws TierOverlapException {

    List<PayoutTier> tiers = consignment.getTiers();

    Collections.sort(
        tiers,
        Comparator.comparingInt(PayoutTier::getFromDays));

    for (int i = 0; i < tiers.size() - 1; i++) {

      PayoutTier current = tiers.get(i);
      PayoutTier next = tiers.get(i + 1);

      if (current.getToDays() >= next.getFromDays()) {

        throw new TierOverlapException(
            "Payout tiers overlap.");

      }

    }

  }

  public BigDecimal applyTiers(int daysOnSale,
      List<PayoutTier> tiers,
      BigDecimal defaultPct) {

    for (PayoutTier tier : tiers) {

      if (daysOnSale >= tier.getFromDays()
          && daysOnSale <= tier.getToDays()) {

        return tier.getPayoutPct();

      }

    }

    return defaultPct;

  }

  public BigDecimal payoutForSale(long consignmentId,
      long inventoryId,
      BigDecimal salePrice,
      LocalDate saleDate,
      LocalDate listingDate)
      throws BelowFloorSaleException {

    Consignment consignment = consignmentRepo.getConsignment(consignmentId);

    if (salePrice.compareTo(consignment.getSaleFloor()) < 0) {

      throw new BelowFloorSaleException(
          "Sale price is below the sale floor.");

    }

    int daysOnSale = (int) ChronoUnit.DAYS.between(
        listingDate,
        saleDate);

    BigDecimal payoutPct = applyTiers(
        daysOnSale,
        consignment.getTiers(),
        consignment.getDefaultPayoutPct());

    return salePrice
        .multiply(payoutPct)
        .divide(
            new BigDecimal("100"),
            2,
            java.math.RoundingMode.HALF_UP);
  }

  public void statementForPeriod(long consignmentId,
      LocalDate periodStart,
      LocalDate periodEnd)
      throws StatementPeriodOverlapException {

    LocalDate[] existing = ledgerRepo.getStatement(consignmentId);

    if (existing != null) {

      if (!(periodEnd.isBefore(existing[0])
          || periodStart.isAfter(existing[1]))) {

        throw new StatementPeriodOverlapException(
            "Statement period overlaps existing statement.");

      }

    }

    ledgerRepo.saveStatement(
        consignmentId,
        periodStart,
        periodEnd);

  }

  public void generateStatementFiles(long consignmentId)
      throws Exception {

    String pdfFile = "Statement_" + consignmentId + ".pdf";

    String csvFile = "Statement_" + consignmentId + ".csv";

    FileWriter pdfWriter = new FileWriter(pdfFile);

    FileWriter csvWriter = new FileWriter(csvFile);

    pdfWriter.write("Consignment Statement PDF");
    csvWriter.write("Consignment Statement CSV");

    pdfWriter.close();
    csvWriter.close();

  }

  public List<Consignment> autoReturnDue(LocalDate asOfDate) {

    List<Consignment> dueList = new ArrayList<>();

    for (Consignment consignment : consignmentRepo.getAllConsignments()) {

      long days = ChronoUnit.DAYS.between(
          consignment.getListingDate(),
          asOfDate);

      if (days >= 90) {

        dueList.add(consignment);

      }

    }

    return dueList;

  }
}