package repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LedgerRepository {

  private final Map<Long, LocalDate[]> statements;

  public LedgerRepository() {

    statements = new HashMap<>();

  }

  public void saveStatement(long consignmentId,
      LocalDate start,
      LocalDate end) {

    statements.put(
        consignmentId,
        new LocalDate[] { start, end });

  }

  public LocalDate[] getStatement(long consignmentId) {

    return statements.get(consignmentId);

  }

}