package repository;

import java.util.HashSet;
import java.util.Set;

public class CounterfeitBlacklistRepository {

  private final Set<String> blacklist;

  public CounterfeitBlacklistRepository() {
    blacklist = new HashSet<>();
  }

  public void addMatrixPair(String matrixA, String matrixB) {

    blacklist.add(matrixA + "|" + matrixB);

  }

  public boolean isBlacklisted(String matrixA, String matrixB) {

    return blacklist.contains(matrixA + "|" + matrixB);

  }

  public void removeMatrixPair(String matrixA, String matrixB) {

    blacklist.remove(matrixA + "|" + matrixB);

  }

  public Set<String> getAllBlacklistedPairs() {

    return blacklist;

  }

}