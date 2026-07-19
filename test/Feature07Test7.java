package VintageVinylStore.test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

import repository.TicketRepository;
import service.Notifier;
import service.ServiceQueue;

public class Feature07Test7 {

  public static void run() {

    try {

      ServiceQueue queue = new ServiceQueue(
          new TicketRepository(),
          new Notifier());

      queue.writeNotesLog(
          "Mumbai",
          "Customer contacted");

      queue.createDailySnapshot(
          "Mumbai");

      File log = new File("Mumbai_Notes.log");

      File snapshot = new File("Mumbai_Snapshot.txt");

      if (log.exists()
          && snapshot.exists()) {

        System.out.println(
            "Feature07 Test7 Passed");

      } else {

        System.out.println(
            "Feature07 Test7 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}