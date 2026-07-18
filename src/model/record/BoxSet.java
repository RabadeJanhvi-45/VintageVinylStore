package model.record;

import enums.Country;
import enums.Format;
import enums.MonoStereo;
import enums.RPM;

import java.util.ArrayList;
import java.util.List;

public class BoxSet extends Record {

  private List<Record> includedRecords;
  private List<String> booklets;

  public BoxSet(int recordId,
      String artist,
      String title,
      String label,
      String catalogueNumber,
      Country country,
      int year,
      RPM rpm,
      MonoStereo monoStereo) {

    super(recordId,
        artist,
        title,
        label,
        catalogueNumber,
        country,
        year,
        rpm,
        Format.BOX_SET,
        monoStereo);

    includedRecords = new ArrayList<>();
    booklets = new ArrayList<>();
  }

  public void addIncludedRecord(Record record) {
    includedRecords.add(record);
  }

  public void addBooklet(String booklet) {
    booklets.add(booklet);
  }

  public boolean isValid() {

    return includedRecords.size() >= 2;
  }

  @Override
  public String defaultSleeveType() {
    return "Rigid Box";
  }

  @Override
  public int suggestedJacketWeightG() {
    return 700;
  }

  @Override
  public String describe() {
    return super.describe() +
        " | Included Records: " + includedRecords.size();
  }

  public int getIncludedRecordCount() {
    return includedRecords.size();
  }

}
