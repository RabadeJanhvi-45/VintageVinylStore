package service;

import exceptions.InsufficientHistoryException;
import model.Valuation;
import model.ValuationInput;
import model.ValuationSettings;
import repository.CounterfeitBlacklistRepository;
import repository.SoldHistoryRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TradeInValuator {

  private final SoldHistoryRepository historyRepository;
  private final CounterfeitBlacklistRepository blacklistRepository;
  private final ValuationSettings settings;

  public TradeInValuator(SoldHistoryRepository historyRepository,
      CounterfeitBlacklistRepository blacklistRepository,
      ValuationSettings settings) {

    this.historyRepository = historyRepository;
    this.blacklistRepository = blacklistRepository;
    this.settings = settings;
  }

  public List<Valuation> estimateWholesale(List<ValuationInput> inputs)
      throws InsufficientHistoryException {

    int comparables = historyRepository.getComparableCount();

    if (comparables < settings.getMinimumComparables()) {
      throw new InsufficientHistoryException(
          "Not enough comparable sales.");
    }

    String confidence;

    if (comparables >= 10) {
      confidence = "HIGH";
    } else if (comparables >= 5) {
      confidence = "MEDIUM";
    } else {
      confidence = "LOW";
    }

    BigDecimal average = historyRepository.calculateAveragePrice();

    List<Valuation> valuations = new ArrayList<>();

    for (ValuationInput input : inputs) {

      valuations.add(
          new Valuation(
              input.getPressingId(),
              average,
              confidence,
              confidence.equals("LOW"),
              false));

    }

    return valuations;
  }

  public BigDecimal computeOffer(List<Valuation> valuations,
      String mode) {

    BigDecimal total = BigDecimal.ZERO;

    for (Valuation valuation : valuations) {

      total = total.add(
          valuation.getWholesaleValue());

    }

    if ("store_credit".equalsIgnoreCase(mode)) {

      total = total.multiply(
          BigDecimal.ONE.add(
              settings.getStoreCreditBonus()));

    }

    return total.setScale(2, RoundingMode.HALF_UP);
  }

  public BigDecimal applyRarityMatrix(String rarity,
      BigDecimal basePrice) {

    BigDecimal multiplier;

    switch (rarity.toUpperCase()) {

      case "COMMON":
        multiplier = new BigDecimal("1.00");
        break;

      case "UNCOMMON":
        multiplier = new BigDecimal("1.20");
        break;

      case "RARE":
        multiplier = new BigDecimal("1.50");
        break;

      case "VERY_RARE":
        multiplier = new BigDecimal("2.00");
        break;

      default:
        multiplier = BigDecimal.ONE;
    }

    return basePrice.multiply(multiplier)
        .setScale(2, RoundingMode.HALF_UP);
  }

  public List<ValuationInput> flagSuspicious(
      List<ValuationInput> inputs) {

    List<ValuationInput> suspicious = new ArrayList<>();

    for (ValuationInput input : inputs) {

      if (input.getConditionPhotos() < 2
          || !"NM".equalsIgnoreCase(input.getMediaGrade())
              && !"VG+".equalsIgnoreCase(input.getMediaGrade())) {

        suspicious.add(input);
      }

    }

    return suspicious;
  }

}