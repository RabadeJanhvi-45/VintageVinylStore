package VintageVinylStore.test;

import java.util.ArrayList;
import java.util.List;

import model.ImportError;
import repository.BlacklistRepository;
import repository.ImportRecordRepository;
import repository.PressingRepository;
import service.CatalogueImporter;

public class Feature08Test2 {

  public static void run() {

    String[] schema = {

        "Title",
        "Artist",
        "Label",
        "Year"

    };

    ImportRecordRepository repo = new ImportRecordRepository();

    CatalogueImporter importer = new CatalogueImporter(
        repo,
        new PressingRepository(),
        new BlacklistRepository(),
        schema);

    List<String[]> rows = new ArrayList<>();

    rows.add(new String[] {
        "Thriller",
        "Michael Jackson",
        "Epic",
        "1982"
    });

    rows.add(new String[] {
        "Bad",
        "Michael Jackson"
    });

    rows.add(new String[] {
        "Dangerous",
        "Michael Jackson",
        "Epic",
        "1991"
    });

    List<ImportError> errors = importer.validateRows(rows);

    System.out.println(
        "Imported = "
            + repo.count());

    System.out.println(
        "Errors = "
            + errors.size());

    if (repo.count() == 2
        && errors.size() == 1) {

      System.out.println(
          "Feature08 Test2 Passed");

    } else {

      System.out.println(
          "Feature08 Test2 Failed");

    }

  }

}