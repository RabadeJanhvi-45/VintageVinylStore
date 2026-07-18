package model;

public class Match {

  private WantlistEntry wantlistEntry;
  private InventoryEvent inventoryEvent;
  private double matchScore;

  public Match(WantlistEntry wantlistEntry,
      InventoryEvent inventoryEvent,
      double matchScore) {

    this.wantlistEntry = wantlistEntry;
    this.inventoryEvent = inventoryEvent;
    this.matchScore = matchScore;
  }

  public WantlistEntry getWantlistEntry() {
    return wantlistEntry;
  }

  public InventoryEvent getInventoryEvent() {
    return inventoryEvent;
  }

  public double getMatchScore() {
    return matchScore;
  }

  @Override
  public String toString() {

    return "Match{" +
        "customerId='" + wantlistEntry.getCustomerId() + '\'' +
        ", inventoryId=" + inventoryEvent.getInventoryId() +
        ", artist='" + inventoryEvent.getArtist() + '\'' +
        ", title='" + inventoryEvent.getTitle() + '\'' +
        ", matchScore=" + matchScore +
        '}';
  }

}