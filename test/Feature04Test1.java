package VintageVinylStore.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.Country;
import enums.Format;
import model.InventoryEvent;
import model.Match;
import model.WantlistEntry;
import observer.EmailNotifier;
import service.WantlistMatcher;

public class Feature04Test1 {

  public static void run() {

    try {

      List<WantlistEntry> wantlist = new ArrayList<>();

      // Active entry
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

      // Inactive entry
      wantlist.add(
          new WantlistEntry(
              2,
              "C002",
              "Pink Floyd",
              "The Wall",
              "VG+",
              5000,
              1975,
              1985,
              Format.LP,
              Country.UK,
              false));

      Map<String, observer.Notifier> registry = new HashMap<>();

      WantlistMatcher matcher = new WantlistMatcher(
          wantlist,
          registry);

      matcher.subscribe(
          "EMAIL",
          new EmailNotifier());

      InventoryEvent event = new InventoryEvent(
          1001,
          "Pink Floyd",
          "The Wall",
          "NM",
          4500,
          1979,
          Format.LP,
          Country.UK);

      List<Match> matches = matcher.onInventoryListed(event);

      System.out.println("Matches Found : "
          + matches.size());

      if (matches.size() == 1) {

        System.out.println(
            "Feature04 Test1 Passed");

      } else {

        System.out.println(
            "Feature04 Test1 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}
