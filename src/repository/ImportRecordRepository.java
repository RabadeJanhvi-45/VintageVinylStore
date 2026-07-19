package repository;

import java.util.ArrayList;
import java.util.List;

public class ImportRecordRepository {

  private List<String> records;

  public ImportRecordRepository() {

    records = new ArrayList<>();

  }

  public void save(String record) {

    records.add(record);

  }

  public List<String> getAll() {

    return records;

  }

  public int count() {

    return records.size();

  }

  public void saveAll(java.util.List<String> records) {

    this.records.addAll(records);

  }

  public void clear() {

    records.clear();

  }

}