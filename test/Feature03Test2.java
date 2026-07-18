package VintageVinylStore.test;

import model.ValuationInput;
import model.ValuationSettings;
import repository.CounterfeitBlacklistRepository;
import repository.SoldHistoryRepository;
import service.TradeInValuator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Feature03Test2 {

  public static void run() {

    try {

      SoldHistoryRepository history = new SoldHistoryRepository();

      // Only 3 comparable sales
      history.addSoldPrice(new BigDecimal("4500"));
      history.addSoldPrice(new BigDecimal("4700"));
      history.addSoldPrice(new BigDecimal("5000"));

      CounterfeitBlacklistRepository blacklist = new CounterfeitBlacklistRepository();

      ValuationSettings settings = new ValuationSettings();

      TradeInValuator valuator = new TradeInValuator(history, blacklist, settings);

      List<ValuationInput> inputs = new ArrayList<>();

      inputs.add(new ValuationInput(
          101,
          "NM",
          "VG+",
          true,
          5));

      valuator.estimateWholesale(inputs);

      System.out.println("Test Failed");

    } catch (Exception e) {

      System.out.println(e.getMessage());
      System.out.println("Feature03 Test2 Passed");

    }

  }
}