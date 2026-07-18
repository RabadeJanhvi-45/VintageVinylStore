package VintageVinylStore.test;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.ReservationConflictException;
import service.WantlistMatcher;

public class Feature04Test3 {

  public static void run() {

    try {

      WantlistMatcher matcher = new WantlistMatcher(
          new ArrayList<>(),
          new HashMap<>());

      // First reservation
      matcher.reserveForCustomer(
          "C001",
          1001);

      // Second reservation for same inventory
      matcher.reserveForCustomer(
          "C002",
          1001);

      System.out.println("Feature04 Test3 Failed");

    } catch (ReservationConflictException e) {

      System.out.println(e.getMessage());
      System.out.println("Feature04 Test3 Passed");

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}
