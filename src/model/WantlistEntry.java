package model;

import enums.Country;
import enums.Format;

public class WantlistEntry {

  private long entryId;
  private String customerId;
  private String artist;
  private String title;
  private String minimumGrade;
  private double maxPrice;
  private int fromYear;
  private int toYear;
  private Format format;
  private Country country;
  private boolean active;

  public WantlistEntry(long entryId,
      String customerId,
      String artist,
      String title,
      String minimumGrade,
      double maxPrice,
      int fromYear,
      int toYear,
      Format format,
      Country country,
      boolean active) {

    this.entryId = entryId;
    this.customerId = customerId;
    this.artist = artist;
    this.title = title;
    this.minimumGrade = minimumGrade;
    this.maxPrice = maxPrice;
    this.fromYear = fromYear;
    this.toYear = toYear;
    this.format = format;
    this.country = country;
    this.active = active;
  }

  public long getEntryId() {
    return entryId;
  }

  public String getCustomerId() {
    return customerId;
  }

  public String getArtist() {
    return artist;
  }

  public String getTitle() {
    return title;
  }

  public String getMinimumGrade() {
    return minimumGrade;
  }

  public double getMaxPrice() {
    return maxPrice;
  }

  public int getFromYear() {
    return fromYear;
  }

  public int getToYear() {
    return toYear;
  }

  public Format getFormat() {
    return format;
  }

  public Country getCountry() {
    return country;
  }

  public boolean isActive() {
    return active;
  }

  public void deactivate() {
    this.active = false;
  }

  @Override
  public String toString() {
    return "WantlistEntry{" +
        "entryId=" + entryId +
        ", customerId='" + customerId + '\'' +
        ", artist='" + artist + '\'' +
        ", title='" + title + '\'' +
        ", minimumGrade='" + minimumGrade + '\'' +
        ", maxPrice=" + maxPrice +
        ", fromYear=" + fromYear +
        ", toYear=" + toYear +
        ", format=" + format +
        ", country=" + country +
        ", active=" + active +
        '}';
  }
}