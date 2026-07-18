package VintageVinylStore.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.Valuation;
import model.ValuationSettings;
import repository.CounterfeitBlacklistRepository;
import repository.SoldHistoryRepository;
import service.TradeInValuator;

public class Feature03Test5 {

  public static void run() {

    SoldHistoryRepository history = new SoldHistoryRepository();

    CounterfeitBlacklistRepository blacklist = new CounterfeitBlacklistRepository();

    ValuationSettings settings = new ValuationSettings();

    TradeInValuator valuator = new TradeInValuator(history, blacklist, settings);

    List<Valuation> valuations = new ArrayList<>();

    valuations.add(new Valuation(
        101,
        new BigDecimal("2500.00"),
        "HIGH",
        false,
        false));

    valuations.add(new Valuation(
        102,
        new BigDecimal("3500.00"),
        "HIGH",
        false,
        false));

    valuations.add(new Valuation(
        103,
        new BigDecimal("4000.00"),
        "HIGH",
        false,
        false));

    BigDecimal cashOffer = valuator.computeOffer(valuations, "cash");

    BigDecimal creditOffer = valuator.computeOffer(valuations, "store_credit");

    System.out.println("Cash Offer        : ₹" + cashOffer);
    System.out.println("Store Credit Offer: ₹" + creditOffer);

    if (cashOffer.compareTo(new BigDecimal("10000.00")) == 0
        && creditOffer.compareTo(new BigDecimal("12000.00")) == 0) {

      System.out.println("Feature03 Test5 Passed");

    } else {

      System.out.println("Feature03 Test5 Failed");

    }

  }

}
