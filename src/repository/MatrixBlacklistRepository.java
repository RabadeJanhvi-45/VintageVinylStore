package repository;

import java.util.HashSet;
import java.util.Set;

public class MatrixBlacklistRepository {

  private final Set<String> blacklist = new HashSet<>();

  public void addMatrix(String matrixA, String matrixB) {
    blacklist.add(matrixA + "|" + matrixB);
  }

  public boolean isBlacklisted(String matrixA, String matrixB) {
    return blacklist.contains(matrixA + "|" + matrixB);
  }
}