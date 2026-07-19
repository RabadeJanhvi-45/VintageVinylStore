package VintageVinylStore.test;

import java.io.File;

import repository.ConsignmentRepository;
import repository.LedgerRepository;
import service.ConsignmentPayoutCalculator;

public class Feature06Test5 {

  public static void run() {

    try {

      ConsignmentPayoutCalculator calculator = new ConsignmentPayoutCalculator(
          new ConsignmentRepository(),
          new LedgerRepository());

      calculator.generateStatementFiles(1);

      File pdf = new File("Statement_1.pdf");

      File csv = new File("Statement_1.csv");

      if (pdf.exists() && csv.exists()) {

        System.out.println(
            "PDF and CSV generated.");

        System.out.println(
            "Feature06 Test5 Passed");

      } else {

        System.out.println(
            "Feature06 Test5 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}