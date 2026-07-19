package VintageVinylStore.test;

import java.util.ArrayList;
import java.util.List;

import exceptions.DatabaseTransactionException;
import repository.BlacklistRepository;
import repository.ImportRecordRepository;
import repository.PressingRepository;
import service.CatalogueImporter;

public class Feature08Test3 {

  public static void run() {

    try {

      ImportRecordRepository repo = new ImportRecordRepository();

      CatalogueImporter importer = new CatalogueImporter(
          repo,
          new PressingRepository(),
          new BlacklistRepository(),
          new String[] { "Title" });

      List<String> chunk = new ArrayList<>();

      chunk.add("Record1");
      chunk.add("FAIL");
      chunk.add("Record2");

      importer.importChunk(chunk);

      System.out.println(
          "Feature08 Test3 Failed");

    } catch (DatabaseTransactionException e) {

      System.out.println(e.getMessage());

      System.out.println(
          "Feature08 Test3 Passed");

    }

  }

}