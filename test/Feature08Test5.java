package VintageVinylStore.test;

import java.util.ArrayList;
import java.util.List;

import model.ImportError;
import repository.BlacklistRepository;
import repository.ImportRecordRepository;
import repository.PressingRepository;
import service.CatalogueImporter;

public class Feature08Test5 {

  public static void run() {

    ImportRecordRepository repo = new ImportRecordRepository();

    BlacklistRepository blacklist = new BlacklistRepository();

    blacklist.add("Fake Album");

    CatalogueImporter importer = new CatalogueImporter(
        repo,
        new PressingRepository(),
        blacklist,
        new String[] { "Title" });

    List<String> rows = new ArrayList<>();

    rows.add("Thriller");
    rows.add("Fake Album");
    rows.add("Bad");

    List<ImportError> errors = new ArrayList<>();

    int imported = importer.importValidRows(
        rows,
        errors);

    System.out.println(
        "Imported = " + imported);

    System.out.println(
        "Errors = " + errors.size());

    if (imported == 2
        && errors.size() == 1
        && repo.count() == 2) {

      System.out.println(
          "Feature08 Test5 Passed");

    } else {

      System.out.println(
          "Feature08 Test5 Failed");

    }

  }

}