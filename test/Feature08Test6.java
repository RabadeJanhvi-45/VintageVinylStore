package VintageVinylStore.test;

import java.util.ArrayList;
import java.util.List;

import repository.BlacklistRepository;
import repository.ImportRecordRepository;
import repository.PressingRepository;
import service.CatalogueImporter;

public class Feature08Test6 {

  public static void run() {

    ImportRecordRepository repo = new ImportRecordRepository();

    CatalogueImporter importer = new CatalogueImporter(
        repo,
        new PressingRepository(),
        new BlacklistRepository(),
        new String[] { "Title" });

    List<String> rows = new ArrayList<>();

    for (int i = 1; i <= 100000; i++) {

      rows.add("Album " + i);

    }

    int imported = importer.importInChunks(
        rows,
        5000);

    System.out.println(
        "Imported = " + imported);

    if (imported == 100000
        && repo.count() == 100000) {

      System.out.println(
          "Feature08 Test6 Passed");

    } else {

      System.out.println(
          "Feature08 Test6 Failed");

    }

  }

}