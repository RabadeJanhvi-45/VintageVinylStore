package VintageVinylStore.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.Country;
import enums.Format;
import model.InventoryEvent;
import model.WantlistEntry;
import observer.BrokenNotifier;
import observer.PushNotifier;
import observer.SMSNotifier;
import service.WantlistMatcher;

public class Feature04Test4 {

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

      matcher.subscribe(
          "EMAIL",
          new BrokenNotifier());

      matcher.subscribe(
          "SMS",
          new SMSNotifier());

      matcher.subscribe(
          "PUSH",
          new PushNotifier());

      InventoryEvent event = new InventoryEvent(
          1001,
          "Pink Floyd",
          "The Wall",
          "NM",
          4500,
          1979,
          Format.LP,
          Country.UK);

      matcher.onInventoryListed(event);

      System.out.println("Feature04 Test4 Passed");

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}
