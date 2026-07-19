package VintageVinylStore.test;

import repository.BlacklistRepository;
import repository.ImportRecordRepository;
import repository.PressingRepository;
import service.CatalogueImporter;

public class Feature08Test7 {

  public static void run() {

    CatalogueImporter importer = new CatalogueImporter(
        new ImportRecordRepository(),
        new PressingRepository(),
        new BlacklistRepository(),
        new String[] { "Title" });

    String delimiter = importer.detectDelimiter(
        "Title;Artist;Label;Year");

    System.out.println(
        "Delimiter = " + delimiter);

    if (";".equals(delimiter)) {

      System.out.println(
          "Feature08 Test7 Passed");

    } else {

      System.out.println(
          "Feature08 Test7 Failed");

    }

  }

}