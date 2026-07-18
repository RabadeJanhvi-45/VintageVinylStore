package util;

import model.record.Record;

import java.io.*;
import java.util.Collection;

public class CsvUtil {

  public static void exportCatalogue(
      Collection<Record> records,
      String path)
      throws IOException {

    BufferedWriter writer = new BufferedWriter(
        new FileWriter(path));

    writer.write(
        "\uFEFF");

    writer.write(
        "RecordId,Artist,Title,Label");

    writer.newLine();

    for (Record record : records) {

      writer.write(
          record.getRecordId() + ","
              + record.getArtist() + ","
              + record.getTitle() + ","
              + record.getLabel());

      writer.newLine();

    }

    writer.close();

  }

}