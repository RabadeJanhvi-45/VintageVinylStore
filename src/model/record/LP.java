package model.record;

import enums.Country;
import enums.Format;
import enums.MonoStereo;
import enums.RPM;

public class LP extends Record {

  private boolean gatefold;
  private int sideCount;

  public LP(int recordId,
      String artist,
      String title,
      String label,
      String catalogueNumber,
      Country country,
      int year,
      RPM rpm,
      MonoStereo monoStereo,
      boolean gatefold) {

    super(recordId,
        artist,
        title,
        label,
        catalogueNumber,
        country,
        year,
        rpm,
        Format.LP,
        monoStereo);

    this.gatefold = gatefold;
    this.sideCount = 2;
  }

  @Override
  public String defaultSleeveType() {
    return gatefold ? "Gatefold Sleeve" : "Standard LP Sleeve";
  }

  @Override
  public int suggestedJacketWeightG() {
    return gatefold ? 450 : 350;
  }

  public boolean isGatefold() {
    return gatefold;
  }

  public int getSideCount() {
    return sideCount;
  }

  @Override
  public String describe() {
    return super.describe() +
        " | Gatefold: " + gatefold +
        " | Sides: " + sideCount;
  }
}