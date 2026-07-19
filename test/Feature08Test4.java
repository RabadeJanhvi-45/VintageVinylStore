package VintageVinylStore.test;

import java.util.ArrayList;
import java.util.List;

import repository.BlacklistRepository;
import repository.ImportRecordRepository;
import repository.PressingRepository;
import service.CatalogueImporter;

public class Feature08Test4 {

  public static void run() {

    ImportRecordRepository repo = new ImportRecordRepository();

    CatalogueImporter importer = new CatalogueImporter(
        repo,
        new PressingRepository(),
        new BlacklistRepository(),
        new String[] { "Title" });

    List<String> rows = new ArrayList<>();

    rows.add("Album1");
    rows.add("Album2");
    rows.add("Album3");

    int processed = importer.importFile(
        rows,
        true);

    System.out.println(
        "Rows Processed = " + processed);

    System.out.println(
        "Database Records = " + repo.count());

    if (processed == 3
        && repo.count() == 0) {

      System.out.println(
          "Feature08 Test4 Passed");

    } else {

      System.out.println(
          "Feature08 Test4 Failed");

    }

  }

}