package VintageVinylStore.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.ImportError;
import repository.BlacklistRepository;
import repository.ImportRecordRepository;
import repository.PressingRepository;
import service.CatalogueImporter;

public class Feature08Test8 {

  public static void run() {

    try {

      CatalogueImporter importer = new CatalogueImporter(
          new ImportRecordRepository(),
          new PressingRepository(),
          new BlacklistRepository(),
          new String[] { "Title" });

      List<ImportError> errors = new ArrayList<>();

      errors.add(
          new ImportError(
              2,
              "Invalid record"));

      errors.add(
          new ImportError(
              5,
              "Counterfeit pressing detected"));

      importer.generateErrorLog(errors);

      File file = new File("errors.log");

      if (file.exists()) {

        System.out.println(
            "Feature08 Test8 Passed");

      } else {

        System.out.println(
            "Feature08 Test8 Failed");

      }

    } catch (IOException e) {

      System.out.println(
          "Feature08 Test8 Failed");

    }

  }

}