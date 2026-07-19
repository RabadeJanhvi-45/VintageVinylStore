package VintageVinylStore.test;

import exceptions.DuplicateCatalogueException;
import exceptions.UnknownArtistException;
import registry.ErrorRegistry;

public class Feature10Test2 {

  public static void run() {

    DuplicateCatalogueException duplicate = new DuplicateCatalogueException(
        "Duplicate catalogue entry");

    UnknownArtistException unknown = new UnknownArtistException(
        "Unknown artist");

    ErrorRegistry.register(
        duplicate.getErrorCode(),
        DuplicateCatalogueException.class);

    ErrorRegistry.register(
        unknown.getErrorCode(),
        UnknownArtistException.class);

    if (ErrorRegistry.contains(
        duplicate.getErrorCode())
        && ErrorRegistry.contains(
            unknown.getErrorCode())
        && !duplicate.getErrorCode().equals(
            unknown.getErrorCode())) {

      System.out.println(
          "Feature10 Test2 Passed");

    } else {

      System.out.println(
          "Feature10 Test2 Failed");

    }

  }

}