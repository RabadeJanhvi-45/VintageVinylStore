package VintageVinylStore.test;

import exceptions.CatalogueException;
import registry.ErrorRegistry;

public class Feature10Test1 {

  public static void run() {

    ErrorRegistry.register(
        "CATALOGUE_EXCEPTION",
        CatalogueException.class);

    if (ErrorRegistry.size() == 1) {

      System.out.println(
          "Feature10 Test1 Passed");

    }

    else {

      System.out.println(
          "Feature10 Test1 Failed");

    }

  }

}