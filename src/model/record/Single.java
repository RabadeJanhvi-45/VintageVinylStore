package model.record;

import enums.Country;
import enums.Format;
import enums.MonoStereo;
import enums.RPM;

public class Single extends Record {

  private String aSideTitle;
  private String bSideTitle;

  public Single(int recordId,
      String artist,
      String title,
      String label,
      String catalogueNumber,
      Country country,
      int year,
      RPM rpm,
      MonoStereo monoStereo,
      String aSideTitle,
      String bSideTitle) {

    super(recordId,
        artist,
        title,
        label,
        catalogueNumber,
        country,
        year,
        rpm,
        Format.SINGLE,
        monoStereo);

    this.aSideTitle = aSideTitle;
    this.bSideTitle = bSideTitle;
  }

  @Override
  public String defaultSleeveType() {
    return "Paper Sleeve";
  }

  @Override
  public int suggestedJacketWeightG() {
    return 200;
  }

  @Override
  public String describe() {
    return super.describe() +
        " | A Side: " + aSideTitle +
        " | B Side: " + bSideTitle;
  }
}