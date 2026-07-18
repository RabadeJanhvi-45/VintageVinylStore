package repository;

import model.Pressing;

import java.util.*;

public class PressingRepository {

  private final Map<Long, Pressing> pressingCache;

  public PressingRepository() {

    pressingCache = new HashMap<>();
  }

  public void addPressing(Pressing pressing) {

    validateFirstPressing(pressing);

    validateDuplicateMatrix(pressing);

    validatePressYear(pressing);

    pressingCache.put(
        pressing.getPressingId(),
        pressing);

  }

  /*
   * Rule 1
   * 
   * Only one first pressing
   */

  private void validateFirstPressing(Pressing pressing) {

    if (!pressing.isFirstPressing())
      return;

    for (Pressing p : pressingCache.values()) {

      if (p.getRecordId() == pressing.getRecordId()
          &&
          p.isFirstPressing()) {

        throw new IllegalArgumentException(
            "First Pressing already exists.");
      }
    }

  }

  /*
   * Rule 2
   * 
   * Duplicate Matrix Pair
   */

  private void validateDuplicateMatrix(Pressing pressing) {

    if (pressing.getMatrixRunoutA() == null &&
        pressing.getMatrixRunoutB() == null)
      return;

    for (Pressing p : pressingCache.values()) {

      if (p.getRecordId() == pressing.getRecordId()
          &&
          Objects.equals(
              p.getMatrixRunoutA(),
              pressing.getMatrixRunoutA())
          &&
          Objects.equals(
              p.getMatrixRunoutB(),
              pressing.getMatrixRunoutB())) {

        throw new IllegalArgumentException(
            "Duplicate Matrix Pair");
      }

    }

  }

  /*
   * Rule 3
   */

  private void validatePressYear(Pressing pressing) {

    if (pressing.isFirstPressing()
        &&
        pressing.getPressYear() == null) {

      throw new IllegalArgumentException(
          "Press Year Required");
    }

  }

  /*
   * Soft Delete
   */

  public void delete(long pressingId) {

    Pressing pressing = pressingCache.get(pressingId);

    if (pressing != null)
      pressing.softDelete();

  }

  public List<Pressing> getByRecordId(int recordId) {

    List<Pressing> list = new ArrayList<>();

    for (Pressing pressing : pressingCache.values()) {

      if (pressing.getRecordId() == recordId
          && !pressing.isDeleted()) {

        list.add(pressing);
      }
    }

    return list;
  }

  public Pressing getPressing(long pressingId) {
    return pressingCache.get(pressingId);
  }

  public Collection<Pressing> getAllPressings() {
    return pressingCache.values();
  }
}