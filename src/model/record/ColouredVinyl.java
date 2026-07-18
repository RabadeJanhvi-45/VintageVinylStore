package model.record;

import enums.Country;
import enums.Format;
import enums.MonoStereo;
import enums.RPM;

public class ColouredVinyl extends Record {

  private String colourDescription;
  private boolean isLimited;
  private Integer limitedCount;

  public ColouredVinyl(int recordId,
      String artist,
      String title,
      String label,
      String catalogueNumber,
      Country country,
      int year,
      RPM rpm,
      MonoStereo monoStereo,
      String colourDescription,
      boolean isLimited,
      Integer limitedCount) {

    super(recordId,
        artist,
        title,
        label,
        catalogueNumber,
        country,
        year,
        rpm,
        Format.COLOURED_VINYL,
        monoStereo);

    this.colourDescription = colourDescription;
    this.isLimited = isLimited;
    this.limitedCount = limitedCount;
  }

  @Override
  public String defaultSleeveType() {
    return "Premium Poly Sleeve";
  }

  @Override
  public int suggestedJacketWeightG() {
    return isLimited ? 500 : 350;
  }

  @Override
  public String describe() {
    return super.describe() +
        " | Colour: " + colourDescription +
        " | Limited: " + isLimited;
  }
}