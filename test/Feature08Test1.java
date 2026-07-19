package VintageVinylStore.test;

import exceptions.ImportSchemaMismatchException;
import repository.BlacklistRepository;
import repository.ImportRecordRepository;
import repository.PressingRepository;
import service.CatalogueImporter;

public class Feature08Test1 {

  public static void run() {

    try {

      String[] expected = {
          "Title",
          "Artist",
          "Label",
          "Year"
      };

      String[] actual = {
          "Title",
          "Artist",
          "Genre",
          "Year"
      };

      CatalogueImporter importer = new CatalogueImporter(
          new ImportRecordRepository(),
          new PressingRepository(),
          new BlacklistRepository(),
          expected);

      importer.validateSchema(actual);

      System.out.println(
          "Feature08 Test1 Failed");

    } catch (ImportSchemaMismatchException e) {

      System.out.println(e.getMessage());

      System.out.println(
          "Feature08 Test1 Passed");

    }

  }

}