package VintageVinylStore.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import model.Reservation;
import service.WantlistMatcher;

public class Feature04Test5 {

  public static void run() {

    WantlistMatcher matcher = new WantlistMatcher(
        new ArrayList<>(),
        new HashMap<>());

    Reservation expiredReservation = new Reservation(
        1,
        "C001",
        1001,
        LocalDateTime.now().minusDays(3),
        LocalDateTime.now().minusHours(1));

    matcher.addReservationForTesting(expiredReservation);

    int released = matcher.releaseExpiredReservations();

    System.out.println("Released Reservations : " + released);

    if (released == 1) {

      System.out.println("Feature04 Test5 Passed");

    } else {

      System.out.println("Feature04 Test5 Failed");

    }

  }

}