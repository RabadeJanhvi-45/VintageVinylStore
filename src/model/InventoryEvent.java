package model;

import enums.Country;
import enums.Format;

public class InventoryEvent {

  private long inventoryId;
  private String artist;
  private String title;
  private String grade;
  private double price;
  private int year;
  private Format format;
  private Country country;

  public InventoryEvent(long inventoryId,
      String artist,
      String title,
      String grade,
      double price,
      int year,
      Format format,
      Country country) {

    this.inventoryId = inventoryId;
    this.artist = artist;
    this.title = title;
    this.grade = grade;
    this.price = price;
    this.year = year;
    this.format = format;
    this.country = country;
  }

  public long getInventoryId() {
    return inventoryId;
  }

  public String getArtist() {
    return artist;
  }

  public String getTitle() {
    return title;
  }

  public String getGrade() {
    return grade;
  }

  public double getPrice() {
    return price;
  }

  public int getYear() {
    return year;
  }

  public Format getFormat() {
    return format;
  }

  public Country getCountry() {
    return country;
  }

  @Override
  public String toString() {

    return "InventoryEvent{" +
        "inventoryId=" + inventoryId +
        ", artist='" + artist + '\'' +
        ", title='" + title + '\'' +
        ", grade='" + grade + '\'' +
        ", price=" + price +
        ", year=" + year +
        ", format=" + format +
        ", country=" + country +
        '}';
  }
}