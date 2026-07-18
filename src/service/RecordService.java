package service;

import exceptions.DuplicateCatalogueException;
import model.Inventory;
import model.Pressing;
import model.record.Record;
import repository.RecordRepository;

public class RecordService {

  private RecordRepository repository;

  public RecordService() {

    repository = new RecordRepository();
  }

  public void createRecord(Record record)
      throws DuplicateCatalogueException {

    repository.addRecord(record);
  }

  public void addPressing(int recordId,
      Pressing pressing) {

    Record record = repository.findById(recordId);

    if (record != null) {

      record.addPressing(pressing);
    }
  }

  public void addInventory(int recordId,
      Inventory inventory) {

    Record record = repository.findById(recordId);

    if (record != null) {

      record.addInventory(inventory);
    }
  }

  public Record getRecord(int id) {

    return repository.findById(id);
  }

  public void showAllRecords() {

    for (Record record : repository.getAllRecords()) {

      System.out.println(record.describe());
    }
  }

}