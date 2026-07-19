package service;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import exceptions.StatusTransitionInvalidException;
import model.ServiceTicket;
import repository.TicketRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import exceptions.AbandonmentPolicyException;
import exceptions.TicketAlreadyAssignedException;

public class ServiceQueue {

  private Deque<ServiceTicket> queue;

  private TicketRepository ticketRepo;
  private Notifier notifier;

  public ServiceQueue(
      TicketRepository ticketRepo,
      Notifier notifier) {

    this.ticketRepo = ticketRepo;
    this.notifier = notifier;

    queue = new ArrayDeque<>();

  }

  public void enqueue(ServiceTicket ticket) {

    queue.offer(ticket);

    ticketRepo.addTicket(ticket);

  }

  public Optional<ServiceTicket> nextTicket() {

    if (queue.isEmpty()) {

      return Optional.empty();

    }

    return Optional.of(queue.poll());

  }

  public void updateStatus(long ticketId,
      String newStatus,
      String by,
      String note)
      throws StatusTransitionInvalidException {

    ServiceTicket ticket = ticketRepo.getTicket(ticketId);

    String currentStatus = ticket.getStatus();

    ticket.addEvent(
        "Status changed to "
            + newStatus
            + " by "
            + by
            + " : "
            + note);

    if (currentStatus.equals("Received")
        && !newStatus.equals("In Progress")) {

      throw new StatusTransitionInvalidException(
          "Invalid status transition.");

    }

    if (currentStatus.equals("In Progress")
        && !(newStatus.equals("Completed")
            || newStatus.equals("Waiting"))) {

      throw new StatusTransitionInvalidException(
          "Invalid status transition.");

    }

    ticket.setStatus(newStatus);

  }

  public void addPart(long ticketId,
      String part,
      String supplier,
      BigDecimal cost,
      int etaDays) {

    ServiceTicket ticket = ticketRepo.getTicket(ticketId);

    BigDecimal total = ticket.getCurrentQuote()
        .add(cost)
        .setScale(2, java.math.RoundingMode.HALF_UP);

    ticket.setCurrentQuote(total);

  }

  public void addLabour(long ticketId,
      BigDecimal hours,
      BigDecimal rate,
      String by) {

    ServiceTicket ticket = ticketRepo.getTicket(ticketId);

    BigDecimal labourCost = hours.multiply(rate);

    BigDecimal total = ticket.getCurrentQuote()
        .add(labourCost)
        .setScale(2, java.math.RoundingMode.HALF_UP);

    ticket.setCurrentQuote(total);

  }

  public List<ServiceTicket> markAbandoned(LocalDate asOfDate)
      throws AbandonmentPolicyException {

    List<ServiceTicket> abandoned = new ArrayList<>();

    for (ServiceTicket ticket : ticketRepo.getAllTickets()) {

      long days = ChronoUnit.DAYS.between(
          ticket.getReceivedAt(),
          asOfDate);

      if (days >= 90
          && ticket.getContactAttempts() >= 2) {

        ticket.setStatus("Abandoned");
        abandoned.add(ticket);

      }

    }

    if (abandoned.isEmpty()) {

      throw new AbandonmentPolicyException(
          "No tickets qualify for abandonment.");

    }

    return abandoned;

  }

  public ServiceTicket nextTicket(String byTechnician)
      throws TicketAlreadyAssignedException {

    if (queue.isEmpty()) {

      return null;

    }

    ServiceTicket ticket = queue.peek();

    if (ticket.isAssigned()) {

      throw new TicketAlreadyAssignedException(
          "Ticket already assigned.");

    }

    ticket.setAssigned(true);

    return queue.poll();

  }

  public void writeNotesLog(String storeName,
      String note)
      throws Exception {

    String logFile = storeName + "_Notes.log";

    FileWriter writer = new FileWriter(logFile, true);

    writer.write(note + System.lineSeparator());

    writer.close();

  }

  public void createDailySnapshot(String storeName)
      throws Exception {

    String snapshotFile = storeName + "_Snapshot.txt";

    FileWriter writer = new FileWriter(snapshotFile);

    writer.write("Daily Snapshot");

    writer.close();

  }

}