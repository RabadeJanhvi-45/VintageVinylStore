package VintageVinylStore.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.Country;
import enums.Format;
import model.InventoryEvent;
import model.WantlistEntry;
import observer.EmailNotifier;
import service.WantlistMatcher;

public class Feature04Test8 {

  public static void run() {

    try {

      List<WantlistEntry> list = new ArrayList<>();

      list.add(
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

      list.add(
          new WantlistEntry(
              2,
              "C002",
              "Pink Floyd",
              "Animals",
              "VG+",
              5000,
              1975,
              1985,
              Format.LP,
              Country.UK,
              true));

      WantlistMatcher matcher = new WantlistMatcher(
          list,
          new HashMap<>());

      matcher.subscribe(
          "EMAIL",
          new EmailNotifier());

      matcher.onInventoryListed(

          new InventoryEvent(
              1001,
              "Pink Floyd",
              "The Wall",
              "NM",
              4500,
              1979,
              Format.LP,
              Country.UK));

      matcher.onInventoryListed(

          new InventoryEvent(
              1002,
              "Pink Floyd",
              "Animals",
              "NM",
              4800,
              1977,
              Format.LP,
              Country.UK));

      Map<String, Integer> report = matcher.getTopMatchedArtists();

      System.out.println("Top Matched Artists");

      for (String artist : report.keySet()) {

        System.out.println(
            artist + " -> " + report.get(artist));

      }

      if (report.get("Pink Floyd") == 2) {

        System.out.println(
            "Feature04 Test8 Passed");

      } else {

        System.out.println(
            "Feature04 Test8 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}