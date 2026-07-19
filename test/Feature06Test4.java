package VintageVinylStore.test;

import java.time.LocalDate;

import exceptions.StatementPeriodOverlapException;
import repository.ConsignmentRepository;
import repository.LedgerRepository;
import service.ConsignmentPayoutCalculator;

public class Feature06Test4 {

  public static void run() {

    try {

      LedgerRepository ledger = new LedgerRepository();

      ConsignmentPayoutCalculator calculator = new ConsignmentPayoutCalculator(
          new ConsignmentRepository(),
          ledger);

      calculator.statementForPeriod(
          1,
          LocalDate.of(2026, 7, 1),
          LocalDate.of(2026, 7, 31));

      calculator.statementForPeriod(
          1,
          LocalDate.of(2026, 7, 15),
          LocalDate.of(2026, 8, 15));

      System.out.println(
          "Feature06 Test4 Failed");

    } catch (StatementPeriodOverlapException e) {

      System.out.println(e.getMessage());
      System.out.println(
          "Feature06 Test4 Passed");

    }

  }

}