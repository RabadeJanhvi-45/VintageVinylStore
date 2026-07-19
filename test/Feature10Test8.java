package VintageVinylStore.test;

import exceptions.CatalogueException;
import exceptions.DuplicateCatalogueException;
import exceptions.UnknownArtistException;
import exceptions.VinylException;

public class Feature10Test8 {

  public static void run() {

    boolean test1 = CatalogueException.class
        .isAssignableFrom(
            DuplicateCatalogueException.class);

    boolean test2 = CatalogueException.class
        .isAssignableFrom(
            UnknownArtistException.class);

    boolean test3 = VinylException.class
        .isAssignableFrom(
            CatalogueException.class);

    boolean test4 = Exception.class
        .isAssignableFrom(
            VinylException.class);

    if (test1
        && test2
        && test3
        && test4) {

      System.out.println(
          "Feature10 Test8 Passed");

    } else {

      System.out.println(
          "Feature10 Test8 Failed");

    }

  }

}