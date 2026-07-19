package repository;

import java.util.HashSet;
import java.util.Set;

public class BlacklistRepository {

  private Set<String> blacklist;

  public BlacklistRepository() {

    blacklist = new HashSet<>();

  }

  public void add(String value) {

    blacklist.add(value);

  }

  public boolean contains(String value) {

    return blacklist.contains(value);

  }

}