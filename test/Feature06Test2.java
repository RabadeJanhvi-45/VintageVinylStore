package VintageVinylStore.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Consignment;
import model.PayoutTier;
import repository.ConsignmentRepository;
import repository.LedgerRepository;
import service.ConsignmentPayoutCalculator;

public class Feature06Test2 {

  public static void run() {

    try {

      List<PayoutTier> tiers = new ArrayList<>();

      tiers.add(
          new PayoutTier(
              0,
              30,
              new BigDecimal("60")));

      tiers.add(
          new PayoutTier(
              31,
              90,
              new BigDecimal("70")));

      Consignment consignment = new Consignment(
          1,
          new BigDecimal("50"),
          tiers,
          new BigDecimal("500"),
          LocalDate.of(2026, 7, 1));

      ConsignmentRepository repo = new ConsignmentRepository();

      repo.addConsignment(consignment);

      ConsignmentPayoutCalculator calculator = new ConsignmentPayoutCalculator(
          repo,
          new LedgerRepository());

      BigDecimal payout = calculator.payoutForSale(
          1,
          101,
          new BigDecimal("1000"),
          LocalDate.of(2026, 7, 20),
          LocalDate.of(2026, 7, 10));

      System.out.println("Payout = " + payout);

      if (payout.compareTo(new BigDecimal("600")) == 0) {

        System.out.println("Feature06 Test2 Passed");

      } else {

        System.out.println("Feature06 Test2 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}