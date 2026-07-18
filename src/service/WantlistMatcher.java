package service;

import exceptions.ReservationConflictException;
import exceptions.WantlistInactiveException;
import model.InventoryEvent;
import model.Match;
import model.Reservation;
import model.WantlistEntry;
import observer.Notifier;
import util.AuditUtil;

import java.time.LocalDateTime;
import java.util.*;

public class WantlistMatcher {

  private final List<WantlistEntry> wantlistEntries;
  private final Map<String, Notifier> notifiers;
  private final PriorityQueue<Reservation> reservations;
  private final Set<Long> reservedInventory;
  private final Map<String, Integer> artistMatchCount;

  public WantlistMatcher(List<WantlistEntry> wantlistEntries,
      Map<String, Notifier> notifierRegistry) {

    this.wantlistEntries = wantlistEntries;
    this.notifiers = notifierRegistry;
    this.reservations = new PriorityQueue<>();
    this.reservedInventory = new HashSet<>();
    this.artistMatchCount = new HashMap<>();
  }

  public void addWantlistEntry(WantlistEntry entry) {
    wantlistEntries.add(entry);
  }

  public void subscribe(String channel, Notifier notifier) {
    notifiers.put(channel.toUpperCase(), notifier);
  }

  public List<Match> onInventoryListed(InventoryEvent event)
      throws WantlistInactiveException {

    List<Match> matches = matchAgainstEntries(event);

    for (Match match : matches) {

      // Update report
      artistMatchCount.put(
          event.getArtist(),
          artistMatchCount.getOrDefault(
              event.getArtist(), 0) + 1);

      // Notify all subscribed channels
      for (Notifier notifier : notifiers.values()) {

        try {
          notifier.notifyCustomer(match);

        } catch (Exception e) {

          System.out.println(
              "Notification failed: "
                  + e.getMessage());

        }

      }

      // Audit log
      try {

        AuditUtil.appendMatch(match);

      } catch (Exception e) {

        System.out.println(
            "Audit Failed: "
                + e.getMessage());

      }

    }

    return matches;
  }

  public List<Match> matchAgainstEntries(InventoryEvent event)
      throws WantlistInactiveException {

    List<Match> matches = new ArrayList<>();

    for (WantlistEntry entry : wantlistEntries) {

      // Only active entries
      if (!entry.isActive()) {
        continue;
      }

      if (!entry.getArtist().equalsIgnoreCase(event.getArtist()))
        continue;

      if (!entry.getTitle().equalsIgnoreCase(event.getTitle()))
        continue;

      if (event.getPrice() > entry.getMaxPrice())
        continue;

      if (event.getYear() < entry.getFromYear()
          || event.getYear() > entry.getToYear())
        continue;

      if (event.getFormat() != entry.getFormat())
        continue;

      if (event.getCountry() != entry.getCountry())
        continue;

      // TODO: Add proper grade comparison if required

      matches.add(
          new Match(
              entry,
              event,
              100.0));

    }

    return matches;
  }

  public Reservation reserveForCustomer(
      String customerId,
      long inventoryId)
      throws ReservationConflictException {

    if (reservedInventory.contains(inventoryId)) {

      throw new ReservationConflictException(
          "Inventory is already reserved.");

    }

    Reservation reservation = new Reservation(
        System.currentTimeMillis(),
        customerId,
        inventoryId,
        LocalDateTime.now(),
        LocalDateTime.now().plusHours(48));

    reservations.offer(reservation);

    reservedInventory.add(inventoryId);

    return reservation;
  }

  public int releaseExpiredReservations() {

    int released = 0;

    while (!reservations.isEmpty()
        && reservations.peek()
            .getExpiresAt()
            .isBefore(LocalDateTime.now())) {

      Reservation reservation = reservations.poll();

      reservation.release();

      reservedInventory.remove(
          reservation.getInventoryId());

      released++;

    }

    return released;
  }

  // Used only in Feature04Test5
  public void addReservationForTesting(
      Reservation reservation) {

    reservations.offer(reservation);

    reservedInventory.add(
        reservation.getInventoryId());

  }

  // Feature04 Test8
  public Map<String, Integer> getTopMatchedArtists() {

    return artistMatchCount;

  }

}