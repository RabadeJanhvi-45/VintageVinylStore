package repository;

import java.util.ArrayList;
import java.util.List;

public class CatalogueRecordRepository {

  private List<String> records = new ArrayList<>();

  public void save(String record) {
    records.add(record);
  }

  public int count() {
    return records.size();
  }

  public List<String> getRecords() {
    return records;
  }
}