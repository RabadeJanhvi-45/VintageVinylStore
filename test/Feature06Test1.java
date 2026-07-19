package VintageVinylStore.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import exceptions.TierOverlapException;
import model.Consignment;
import model.PayoutTier;
import repository.ConsignmentRepository;
import repository.LedgerRepository;
import service.ConsignmentPayoutCalculator;

public class Feature06Test1 {

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
              20,
              60,
              new BigDecimal("70")));

      Consignment consignment = new Consignment(
          1,
          new BigDecimal("50"),
          tiers,
          new BigDecimal("500"),
          java.time.LocalDate.of(2026, 7, 1));

      ConsignmentPayoutCalculator calculator = new ConsignmentPayoutCalculator(
          new ConsignmentRepository(),
          new LedgerRepository());

      calculator.validateTiers(consignment);

      System.out.println(
          "Feature06 Test1 Failed");

    } catch (TierOverlapException e) {

      System.out.println(e.getMessage());
      System.out.println(
          "Feature06 Test1 Passed");

    }

  }

}