package model.record;

import enums.Country;
import enums.Format;
import enums.MonoStereo;
import enums.RPM;
import model.Inventory;
import model.Pressing;
import util.ValidationUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Record {

  protected int recordId;
  protected String artist;
  protected String title;
  protected String label;
  protected String catalogueNumber;
  protected Country country;
  protected int year;
  protected RPM rpm;
  protected Format format;
  protected MonoStereo monoStereo;

  protected List<Pressing> pressings;
  protected List<Inventory> inventories;

  public Record(int recordId,
      String artist,
      String title,
      String label,
      String catalogueNumber,
      Country country,
      int year,
      RPM rpm,
      Format format,
      MonoStereo monoStereo) {

    // Validation
    if (!ValidationUtil.validateYear(year)) {
      throw new IllegalArgumentException("Invalid year.");
    }

    if (!ValidationUtil.validateRPM(rpm)) {
      throw new IllegalArgumentException("Invalid RPM. Allowed values: 33, 45, 78.");
    }

    this.recordId = recordId;
    this.artist = artist;
    this.title = title;
    this.label = label;
    this.catalogueNumber = catalogueNumber;
    this.country = country;
    this.year = year;
    this.rpm = rpm;
    this.format = format;
    this.monoStereo = monoStereo;

    this.pressings = new ArrayList<>();
    this.inventories = new ArrayList<>();
  }

  // =====================================================
  // Abstract Methods
  // =====================================================

  public abstract String defaultSleeveType();

  public abstract int suggestedJacketWeightG();

  // =====================================================
  // Business Methods
  // =====================================================

  public void addPressing(Pressing pressing) {
    pressings.add(pressing);
  }

  public void addInventory(Inventory inventory) {
    inventories.add(inventory);
  }

  public Map<String, Object> toDict() {

    Map<String, Object> map = new HashMap<>();

    map.put("recordId", recordId);
    map.put("artist", artist);
    map.put("title", title);
    map.put("label", label);
    map.put("catalogueNumber", catalogueNumber);
    map.put("country", country.name());
    map.put("year", year);
    map.put("rpm", rpm.getValue());
    map.put("format", format.name());
    map.put("monoStereo", monoStereo.name());

    return map;
  }

  public String describe() {

    return String.format(
        "%d | %s | %s | %s | %d RPM | %s | %d",
        recordId,
        artist,
        title,
        format,
        rpm.getValue(),
        country,
        year);
  }

  // =====================================================
  // Getters
  // =====================================================

  public int getRecordId() {
    return recordId;
  }

  public String getArtist() {
    return artist;
  }

  public String getTitle() {
    return title;
  }

  public String getLabel() {
    return label;
  }

  public String getCatalogueNumber() {
    return catalogueNumber;
  }

  public Country getCountry() {
    return country;
  }

  public int getYear() {
    return year;
  }

  public RPM getRpm() {
    return rpm;
  }

  public Format getFormat() {
    return format;
  }

  public MonoStereo getMonoStereo() {
    return monoStereo;
  }

  public List<Pressing> getPressings() {
    return pressings;
  }

  public List<Inventory> getInventories() {
    return inventories;
  }

  // =====================================================
  // Setters (Optional)
  // =====================================================

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return describe();
  }
}