package VintageVinylStore.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.Country;
import enums.Format;
import model.InventoryEvent;
import model.WantlistEntry;
import observer.EmailNotifier;
import service.WantlistMatcher;

public class Feature04Test6 {

  public static void run() {

    try {

      File file = new File("match_audit.jsonl");

      if (file.exists()) {
        file.delete();
      }

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

      if (file.exists()) {

        System.out.println(
            "Feature04 Test6 Passed");

      } else {

        System.out.println(
            "Feature04 Test6 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}
