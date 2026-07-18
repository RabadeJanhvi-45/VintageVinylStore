package VintageVinylStore.test;

import model.Valuation;
import model.ValuationSettings;
import repository.CounterfeitBlacklistRepository;
import repository.SoldHistoryRepository;
import service.TradeInValuator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Feature03Test3 {

  public static void run() {

    SoldHistoryRepository history = new SoldHistoryRepository();
    CounterfeitBlacklistRepository blacklist = new CounterfeitBlacklistRepository();
    ValuationSettings settings = new ValuationSettings();

    TradeInValuator valuator = new TradeInValuator(history, blacklist, settings);

    List<Valuation> valuations = new ArrayList<>();

    valuations.add(new Valuation(
        101,
        new BigDecimal("5000"),
        "HIGH",
        false,
        false));

    valuations.add(new Valuation(
        102,
        new BigDecimal("3000"),
        "HIGH",
        false,
        false));

    BigDecimal cashOffer = valuator.computeOffer(valuations, "cash");

    BigDecimal storeCredit = valuator.computeOffer(valuations, "store_credit");

    System.out.println("Cash Offer      : ₹" + cashOffer);
    System.out.println("Store Credit    : ₹" + storeCredit);

    if (cashOffer.compareTo(new BigDecimal("8000.00")) == 0 &&
        storeCredit.compareTo(new BigDecimal("9600.00")) == 0) {

      System.out.println("Feature03 Test3 Passed");

    } else {

      System.out.println("Feature03 Test3 Failed");

    }

  }
}