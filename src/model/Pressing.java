package model;

public class Pressing {

  private long pressingId;
  private int recordId;

  private String pressingPlant;

  private String matrixRunoutA;
  private String matrixRunoutB;

  private Integer pressYear;

  private boolean firstPressing;

  private boolean promo;

  private String catalogueVariant;

  private String notes;

  private boolean deleted;

  public Pressing(long pressingId,
      int recordId,
      String pressingPlant,
      String matrixRunoutA,
      String matrixRunoutB,
      Integer pressYear,
      boolean firstPressing,
      boolean promo,
      String catalogueVariant,
      String notes) {

    this.pressingId = pressingId;
    this.recordId = recordId;
    this.pressingPlant = pressingPlant;
    this.matrixRunoutA = matrixRunoutA;
    this.matrixRunoutB = matrixRunoutB;
    this.pressYear = pressYear;
    this.firstPressing = firstPressing;
    this.promo = promo;
    this.catalogueVariant = catalogueVariant;
    this.notes = notes;
    this.deleted = false;
  }

  // Getters

  public long getPressingId() {
    return pressingId;
  }

  public int getRecordId() {
    return recordId;
  }

  public String getPressingPlant() {
    return pressingPlant;
  }

  public String getMatrixRunoutA() {
    return matrixRunoutA;
  }

  public String getMatrixRunoutB() {
    return matrixRunoutB;
  }

  public Integer getPressYear() {
    return pressYear;
  }

  public boolean isFirstPressing() {
    return firstPressing;
  }

  public boolean isPromo() {
    return promo;
  }

  public String getCatalogueVariant() {
    return catalogueVariant;
  }

  public String getNotes() {
    return notes;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void softDelete() {
    deleted = true;
  }

  @Override
  public String toString() {

    return "Pressing{" +
        "id=" + pressingId +
        ", plant='" + pressingPlant + '\'' +
        ", matrixA='" + matrixRunoutA + '\'' +
        ", matrixB='" + matrixRunoutB + '\'' +
        ", year=" + pressYear +
        '}';
  }

}