package model.record;

import enums.Country;
import enums.Format;
import enums.MonoStereo;
import enums.RPM;

public class PictureDisc extends Record {

  private String imageRef;

  public PictureDisc(int recordId,
      String artist,
      String title,
      String label,
      String catalogueNumber,
      Country country,
      int year,
      RPM rpm,
      MonoStereo monoStereo,
      String imageRef) {

    super(recordId,
        artist,
        title,
        label,
        catalogueNumber,
        country,
        year,
        rpm,
        Format.PICTURE_DISC,
        monoStereo);

    this.imageRef = imageRef;
  }

  @Override
  public String defaultSleeveType() {
    return "PVC Sleeve";
  }

  @Override
  public int suggestedJacketWeightG() {
    return 300;
  }

  @Override
  public String describe() {
    return super.describe() +
        " | Image: " + imageRef;
  }
}