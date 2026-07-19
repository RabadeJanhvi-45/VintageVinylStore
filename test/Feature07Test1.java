package VintageVinylStore.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import model.ServiceTicket;
import repository.TicketRepository;
import service.Notifier;
import service.ServiceQueue;

public class Feature07Test1 {

  public static void run() {

    ServiceQueue queue = new ServiceQueue(
        new TicketRepository(),
        new Notifier());

    ServiceTicket t1 = new ServiceTicket(
        101,
        "Laptop",
        "Dell",
        "Inspiron",
        "Received",
        LocalDate.now(),
        new BigDecimal("10000"),
        BigDecimal.ZERO,
        0);

    ServiceTicket t2 = new ServiceTicket(
        102,
        "Printer",
        "HP",
        "LaserJet",
        "Received",
        LocalDate.now(),
        new BigDecimal("5000"),
        BigDecimal.ZERO,
        0);

    queue.enqueue(t1);
    queue.enqueue(t2);

    Optional<ServiceTicket> next = queue.nextTicket();

    if (next.isPresent()
        && next.get().getId() == 101) {

      System.out.println(
          "Feature07 Test1 Passed");

    } else {

      System.out.println(
          "Feature07 Test1 Failed");

    }

  }

}