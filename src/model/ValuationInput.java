package model;

public class ValuationInput {

  private long pressingId;
  private String mediaGrade;
  private String sleeveGrade;
  private boolean hasOriginalInner;
  private int conditionPhotos;

  public ValuationInput(long pressingId,
      String mediaGrade,
      String sleeveGrade,
      boolean hasOriginalInner,
      int conditionPhotos) {

    this.pressingId = pressingId;
    this.mediaGrade = mediaGrade;
    this.sleeveGrade = sleeveGrade;
    this.hasOriginalInner = hasOriginalInner;
    this.conditionPhotos = conditionPhotos;
  }

  public long getPressingId() {
    return pressingId;
  }

  public String getMediaGrade() {
    return mediaGrade;
  }

  public String getSleeveGrade() {
    return sleeveGrade;
  }

  public boolean hasOriginalInner() {
    return hasOriginalInner;
  }

  public int getConditionPhotos() {
    return conditionPhotos;
  }

  @Override
  public String toString() {
    return "ValuationInput{" +
        "pressingId=" + pressingId +
        ", mediaGrade='" + mediaGrade + '\'' +
        ", sleeveGrade='" + sleeveGrade + '\'' +
        ", hasOriginalInner=" + hasOriginalInner +
        ", conditionPhotos=" + conditionPhotos +
        '}';
  }
}