package VintageVinylStore.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import model.ServiceTicket;
import repository.TicketRepository;
import service.Notifier;
import service.ServiceQueue;

public class Feature07Test5 {

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
          "Received",
          LocalDate.now(),
          new BigDecimal("10000"),
          BigDecimal.ZERO,
          0);

      queue.enqueue(ticket);

      queue.updateStatus(
          101,
          "In Progress",
          "TECH1",
          "Repair started");

      System.out.println(
          "Events = "
              + ticket.getEventLog().size());

      if (ticket.getEventLog().size() == 1) {

        System.out.println(
            "Feature07 Test5 Passed");

      } else {

        System.out.println(
            "Feature07 Test5 Failed");

      }

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}