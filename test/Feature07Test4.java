package VintageVinylStore.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import model.ServiceTicket;
import repository.TicketRepository;
import service.Notifier;
import service.ServiceQueue;

public class Feature07Test4 {

  public static void run() {

    try {

      ServiceQueue queue = new ServiceQueue(
          new TicketRepository(),
          new Notifier());

      ServiceTicket ticket = new ServiceTicket(
          101,
          "Laptop",
          "Dell",
          "Inspiron",
          "Waiting",
          LocalDate.of(2026, 1, 1),
          new BigDecimal("10000"),
          BigDecimal.ZERO,
          2);

      queue.enqueue(ticket);

      List<ServiceTicket> abandoned = queue.markAbandoned(
          LocalDate.of(2026, 5, 1));

      System.out.println(
          "Abandoned Tickets = " + abandoned.size());

      if (abandoned.size() == 1) {

        System.out.println(
            "Feature07 Test4 Passed");

      } else {

        System.out.println(
            "Feature07 Test4 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}