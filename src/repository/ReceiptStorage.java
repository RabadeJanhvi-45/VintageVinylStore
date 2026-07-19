package repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import exceptions.StorageQuotaException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceiptStorage {
  private int maxReceipts = 5;
  private int storedReceipts = 0;

  public String savePdf(String orderId, String content)
      throws IOException {

    String path = "receipts/2026/07/20";

    File directory = new File(path);

    if (!directory.exists()) {

      directory.mkdirs();

    }

    File tempFile = new File(directory,
        orderId + ".tmp");

    FileWriter writer = new FileWriter(tempFile);

    writer.write(content);

    writer.close();

    File pdfFile = new File(directory,
        orderId + ".pdf");

    tempFile.renameTo(pdfFile);

    return pdfFile.getAbsolutePath();

  }

  public void storeReceipt(String receipt)
      throws StorageQuotaException {

    if (storedReceipts >= maxReceipts) {

      throw new StorageQuotaException(
          "Storage quota exhausted.");

    }

    storedReceipts++;

  }

  public int getStoredReceipts() {

    return storedReceipts;

  }

  public String getRetentionPath() {

    LocalDate today = LocalDate.now();

    return "receipts/"
        + today.format(
            DateTimeFormatter.ofPattern(
                "yyyy/MM/dd"));

  }
}