package VintageVinylStore.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import exceptions.TicketAlreadyAssignedException;
import model.ServiceTicket;
import repository.TicketRepository;
import service.Notifier;
import service.ServiceQueue;

public class Feature07Test6 {

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

      ticket.setAssigned(true);

      queue.nextTicket("TECH2");

      System.out.println(
          "Feature07 Test6 Failed");

    } catch (TicketAlreadyAssignedException e) {

      System.out.println(e.getMessage());

      System.out.println(
          "Feature07 Test6 Passed");

    }

  }

}