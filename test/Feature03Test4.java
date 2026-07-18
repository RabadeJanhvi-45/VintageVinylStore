package VintageVinylStore.test;

import model.ValuationInput;
import model.ValuationSettings;
import repository.CounterfeitBlacklistRepository;
import repository.SoldHistoryRepository;
import service.TradeInValuator;

import java.util.ArrayList;
import java.util.List;

public class Feature03Test4 {

  public static void run() {

    SoldHistoryRepository history = new SoldHistoryRepository();

    CounterfeitBlacklistRepository blacklist = new CounterfeitBlacklistRepository();

    ValuationSettings settings = new ValuationSettings();

    TradeInValuator valuator = new TradeInValuator(history, blacklist, settings);

    List<ValuationInput> inputs = new ArrayList<>();

    // Suspicious (only 1 photo)
    inputs.add(new ValuationInput(
        101,
        "NM",
        "VG+",
        true,
        1));

    // Not suspicious
    inputs.add(new ValuationInput(
        102,
        "VG+",
        "VG",
        true,
        4));

    List<ValuationInput> suspicious = valuator.flagSuspicious(inputs);

    System.out.println("Suspicious Items:");
    System.out.println(suspicious);

    if (suspicious.size() == 1 &&
        suspicious.get(0).getPressingId() == 101) {

      System.out.println("Feature03 Test4 Passed");

    } else {

      System.out.println("Feature03 Test4 Failed");

    }

  }

}