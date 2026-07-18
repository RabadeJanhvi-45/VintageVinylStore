package repository;

import exceptions.DuplicateCatalogueException;
import model.record.BoxSet;
import java.util.Collection;
import model.record.Record;
import java.util.HashMap;
import java.util.Map;

public class RecordRepository {

  // RecordRepository repo = new RecordRepository();
  // Dict<int, Record> cache
  private final Map<Integer, Record> recordCache;

  public RecordRepository() {
    recordCache = new HashMap<>();
  }

  /**
   * Add Record
   */
  public void addRecord(Record record)
      throws DuplicateCatalogueException {

    // Duplicate Check
    for (Record r : recordCache.values()) {

      if (r.getCatalogueNumber().equalsIgnoreCase(record.getCatalogueNumber())
          &&
          r.getLabel().equalsIgnoreCase(record.getLabel())
          &&
          r.getCountry().equals(record.getCountry())) {

        throw new DuplicateCatalogueException(
            "Catalogue already exists : "
                + record.getCatalogueNumber());
      }
    }

    // BoxSet Validation
    if (record instanceof BoxSet) {

      BoxSet boxSet = (BoxSet) record;

      if (!boxSet.isValid()) {

        throw new IllegalArgumentException(
            "BoxSet must contain at least 2 records.");
      }
    }

    recordCache.put(record.getRecordId(), record);
  }

  /**
   * Search by Record Id
   */
  public Record findById(int id) {

    return recordCache.get(id);
  }

  /**
   * Search by Catalogue Number
   */
  public Record findByCatalogueNumber(String catalogueNumber) {

    for (Record r : recordCache.values()) {

      if (r.getCatalogueNumber().equalsIgnoreCase(catalogueNumber)) {

        return r;
      }
    }

    return null;
  }

  /**
   * Return all Records
   */
  public Collection<Record> getAllRecords() {

    return recordCache.values();

  }

  /**
   * Count
   */
  public int size() {

    return recordCache.size();
  }

  public void deleteRecord(int recordId) {

    Record record = recordCache.get(recordId);

    if (record == null)
      return;

    if (!record.getPressings().isEmpty()) {

      throw new IllegalStateException(
          "Cannot delete record. Pressings exist.");
    }

    recordCache.remove(recordId);
  }

}