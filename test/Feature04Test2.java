package VintageVinylStore.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.Country;
import enums.Format;
import model.InventoryEvent;
import model.Match;
import model.WantlistEntry;
import service.WantlistMatcher;

public class Feature04Test2 {

  public static void run() {

    try {

      List<WantlistEntry> wantlist = new ArrayList<>();

      wantlist.add(
          new WantlistEntry(
              1,
              "C001",
              "Pink Floyd",
              "The Wall",
              "VG+",
              5000,
              1975,
              1985,
              Format.LP,
              Country.UK,
              true));

      WantlistMatcher matcher = new WantlistMatcher(
          wantlist,
          new HashMap<>());

      // Price exceeds maxPrice (5000)
      InventoryEvent event = new InventoryEvent(
          1001,
          "Pink Floyd",
          "The Wall",
          "NM",
          7000,
          1979,
          Format.LP,
          Country.UK);

      List<Match> matches = matcher.matchAgainstEntries(event);

      System.out.println("Matches Found : "
          + matches.size());

      if (matches.isEmpty()) {

        System.out.println(
            "Feature04 Test2 Passed");

      } else {

        System.out.println(
            "Feature04 Test2 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}