package model;

public class Label {

  private int labelId;
  private String name;
  private String country;

  public Label(int labelId,
      String name,
      String country) {

    this.labelId = labelId;
    this.name = name;
    this.country = country;
  }

  public int getLabelId() {
    return labelId;
  }

  public String getName() {
    return name;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public String toString() {
    return name;
  }
}