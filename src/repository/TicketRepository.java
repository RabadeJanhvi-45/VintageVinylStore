package repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import model.ServiceTicket;

public class TicketRepository {

  private Map<Long, ServiceTicket> tickets;

  public TicketRepository() {

    tickets = new HashMap<>();

  }

  public void addTicket(ServiceTicket ticket) {

    tickets.put(
        ticket.getId(),
        ticket);

  }

  public ServiceTicket getTicket(long ticketId) {

    return tickets.get(ticketId);

  }

  public Collection<ServiceTicket> getAllTickets() {

    return tickets.values();

  }

}