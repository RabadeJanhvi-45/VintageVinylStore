package util;

import model.Match;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AuditUtil {

  private static final String FILE_NAME = "match_audit.jsonl";

  public static void appendMatch(Match match) throws IOException {

    BufferedWriter writer = new BufferedWriter(
        new FileWriter(FILE_NAME, true));

    writer.write(
        "{\"customer\":\""
            + match.getWantlistEntry().getCustomerId()
            + "\",\"inventory\":"
            + match.getInventoryEvent().getInventoryId()
            + ",\"artist\":\""
            + match.getInventoryEvent().getArtist()
            + "\"}");

    writer.newLine();

    writer.close();

  }

}