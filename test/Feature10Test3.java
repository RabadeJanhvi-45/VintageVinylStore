package VintageVinylStore.test;

import exceptions.DuplicateCatalogueException;

public class Feature10Test3 {

  public static void run() {

    DuplicateCatalogueException exception = new DuplicateCatalogueException(
        "Duplicate catalogue.");

    exception.getContext().put(
        "catalogueId",
        "CAT-101");

    String value = exception.getContext()
        .get("catalogueId");

    if ("CAT-101".equals(value)) {

      System.out.println(
          "Feature10 Test3 Passed");

    } else {

      System.out.println(
          "Feature10 Test3 Failed");

    }

  }

}