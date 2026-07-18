package service;

import model.Pressing;
import repository.PressingRepository;

import java.util.List;

public class PressingService {

  private final PressingRepository repository;

  public PressingService() {
    repository = new PressingRepository();
  }

  public void addPressing(Pressing pressing) {
    repository.addPressing(pressing);
  }

  public void deletePressing(long id) {
    repository.delete(id);
  }

  public List<Pressing> getPressingsByRecord(int recordId) {
    return repository.getByRecordId(recordId);
  }

  public Pressing getPressing(long id) {
    return repository.getPressing(id);
  }
}