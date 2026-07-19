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

public class Feature06Test7 {

  public static void run() {

    List<PayoutTier> tiers = new ArrayList<>();

    tiers.add(
        new PayoutTier(
            0,
            30,
            new BigDecimal("60")));

    ConsignmentRepository repo = new ConsignmentRepository();

    repo.addConsignment(
        new Consignment(
            1,
            new BigDecimal("50"),
            tiers,
            new BigDecimal("500"),
            LocalDate.of(2026, 1, 1)));

    ConsignmentPayoutCalculator calculator = new ConsignmentPayoutCalculator(
        repo,
        new LedgerRepository());

    List<Consignment> due = calculator.autoReturnDue(
        LocalDate.of(2026, 5, 1));

    System.out.println("Items Due = " + due.size());

    if (due.size() == 1) {

      System.out.println("Feature06 Test7 Passed");

    } else {

      System.out.println("Feature06 Test7 Failed");

    }

  }

}