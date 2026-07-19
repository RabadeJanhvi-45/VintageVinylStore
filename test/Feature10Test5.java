package VintageVinylStore.test;

import java.io.*;

import exceptions.DuplicateCatalogueException;

public class Feature10Test5 {

  public static void run() {

    try {

      DuplicateCatalogueException exception = new DuplicateCatalogueException(
          "Duplicate catalogue");

      ByteArrayOutputStream baos = new ByteArrayOutputStream();

      ObjectOutputStream out = new ObjectOutputStream(baos);

      out.writeObject(exception);
      out.close();

      ObjectInputStream in = new ObjectInputStream(
          new ByteArrayInputStream(
              baos.toByteArray()));

      DuplicateCatalogueException restored = (DuplicateCatalogueException) in.readObject();

      if (restored.getErrorCode().equals(
          exception.getErrorCode())) {

        System.out.println(
            "Feature10 Test5 Passed");

      } else {

        System.out.println(
            "Feature10 Test5 Failed");

      }

    } catch (Exception e) {

      System.out.println(
          "Feature10 Test5 Failed");

    }

  }

}