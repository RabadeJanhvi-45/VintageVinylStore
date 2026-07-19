package VintageVinylStore.test;

import exceptions.DuplicateCatalogueException;
import model.ErrorContext;

public class Feature10Test4 {

  public static void run() {

    try {

      ErrorContext context = new ErrorContext();

      context.put(
          "catalogueId",
          "CAT-500");

      throw new DuplicateCatalogueException(
          "Duplicate catalogue",
          context);

    }

    catch (DuplicateCatalogueException e) {

      try {

        throw new DuplicateCatalogueException(
            e.getMessage(),
            e.getContext());

      }

      catch (DuplicateCatalogueException ex) {

        if ("CAT-500".equals(
            ex.getContext()
                .get("catalogueId"))) {

          System.out.println(
              "Feature10 Test4 Passed");

        }

        else {

          System.out.println(
              "Feature10 Test4 Failed");

        }

      }

    }

  }

}