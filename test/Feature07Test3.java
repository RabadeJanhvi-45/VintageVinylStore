package VintageVinylStore.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import model.ServiceTicket;
import repository.TicketRepository;
import service.Notifier;
import service.ServiceQueue;

public class Feature07Test3 {

  public static void run() {

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

    queue.addPart(
        101,
        "SSD",
        "Samsung",
        new BigDecimal("2500"),
        2);

    queue.addLabour(
        101,
        new BigDecimal("2"),
        new BigDecimal("500"),
        "TECH1");

    BigDecimal quote = ticket.getCurrentQuote();

    System.out.println("Current Quote = " + quote);

    if (quote.compareTo(new BigDecimal("3500")) == 0) {

      System.out.println(
          "Feature07 Test3 Passed");

    } else {

      System.out.println(
          "Feature07 Test3 Failed");

    }

  }

}