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

public class Feature04Test7 {

  public static void run() {

    try {

      List<WantlistEntry> wantlist = new ArrayList<>();

      // Inactive entry
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
              false));

      WantlistMatcher matcher = new WantlistMatcher(
          wantlist,
          new HashMap<>());

      InventoryEvent event = new InventoryEvent(
          1001,
          "Pink Floyd",
          "The Wall",
          "NM",
          4500,
          1979,
          Format.LP,
          Country.UK);

      List<Match> matches = matcher.matchAgainstEntries(event);

      System.out.println("Matches Found : " + matches.size());

      if (matches.isEmpty()) {

        System.out.println("Feature04 Test7 Passed");

      } else {

        System.out.println("Feature04 Test7 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}