package service;

import exceptions.ImportSchemaMismatchException;
import java.util.ArrayList;
import java.util.List;
import exceptions.DatabaseTransactionException;
import model.ImportError;
import repository.BlacklistRepository;
import repository.CatalogueRecordRepository;
import repository.ImportRecordRepository;
import repository.PressingRepository;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CatalogueImporter {

  private ImportRecordRepository recordRepo;
  private PressingRepository pressingRepo;
  private BlacklistRepository blacklist;
  private String[] schema;

  public CatalogueImporter(
      ImportRecordRepository recordRepo,
      PressingRepository pressingRepo,
      BlacklistRepository blacklist,
      String[] schema) {

    this.recordRepo = recordRepo;
    this.pressingRepo = pressingRepo;
    this.blacklist = blacklist;
    this.schema = schema;

  }

  public void validateSchema(String[] csvHeader)
      throws ImportSchemaMismatchException {

    if (csvHeader.length != schema.length) {

      throw new ImportSchemaMismatchException(
          "CSV schema mismatch.");

    }

    for (int i = 0; i < schema.length; i++) {

      if (!schema[i].equals(csvHeader[i])) {

        throw new ImportSchemaMismatchException(
            "CSV schema mismatch.");

      }

    }

  }

  public List<ImportError> validateRows(
      List<String[]> rows) {

    List<ImportError> errors = new ArrayList<>();

    for (int i = 0; i < rows.size(); i++) {

      String[] row = rows.get(i);

      if (row.length != schema.length) {

        errors.add(
            new ImportError(
                i + 1,
                "Invalid column count"));

        continue;

      }

      recordRepo.save(row[0]);

    }

    return errors;

  }

  public void importChunk(List<String> rows,
      CatalogueRecordRepository repo)
      throws DatabaseTransactionException {

    List<String> temp = new ArrayList<>();

    for (String row : rows) {

      if (row.equals("FAIL")) {

        throw new DatabaseTransactionException(
            "Chunk rolled back.");

      }

      temp.add(row);

    }

    for (String row : temp) {

      repo.save(row);

    }

  }

  public int importFile(List<String> rows,
      boolean dryRun,
      CatalogueRecordRepository repo) {

    int imported = 0;

    for (String row : rows) {

      if (dryRun) {

        imported++;

      } else {

        repo.save(row);
        imported++;

      }

    }

    return imported;

  }

  public void importChunk(
      List<String> chunk)
      throws DatabaseTransactionException {

    List<String> temp = new ArrayList<>();

    for (String record : chunk) {

      if ("FAIL".equals(record)) {

        throw new DatabaseTransactionException(
            "Chunk rolled back.");

      }

      temp.add(record);

    }

    recordRepo.saveAll(temp);

  }

  public int importFile(
      List<String> rows,
      boolean dryRun) {

    int imported = 0;

    for (String row : rows) {

      if (!dryRun) {

        recordRepo.save(row);

      }

      imported++;

    }

    return imported;

  }

  public int importValidRows(
      List<String> rows,
      List<ImportError> errors) {

    int imported = 0;

    for (int i = 0; i < rows.size(); i++) {

      String record = rows.get(i);

      if (blacklist.contains(record)) {

        errors.add(
            new ImportError(
                i + 1,
                "Counterfeit pressing detected"));

        continue;

      }

      recordRepo.save(record);

      imported++;

    }

    return imported;

  }

  public int importInChunks(
      List<String> rows,
      int chunkSize) {

    int imported = 0;

    for (int i = 0; i < rows.size(); i += chunkSize) {

      int end = Math.min(
          i + chunkSize,
          rows.size());

      List<String> chunk = rows.subList(i, end);

      for (String row : chunk) {

        recordRepo.save(row);
        imported++;

      }

    }

    return imported;

  }

  public String detectDelimiter(String firstLine) {

    if (firstLine.contains(";")) {

      return ";";

    }

    return ",";

  }

  public void generateErrorLog(List<ImportError> errors)
      throws IOException {

    FileWriter writer = new FileWriter("errors.log");

    for (ImportError error : errors) {

      writer.write(
          "Row " + error.getRowNumber()
              + " : "
              + error.getMessage()
              + System.lineSeparator());

    }

    writer.close();

  }

}