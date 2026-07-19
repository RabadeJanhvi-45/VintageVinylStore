package VintageVinylStore.test;

import exceptions.DuplicateCatalogueException;
import service.ExceptionHandler;

public class Feature10Test6 {

  public static void run() {

    ExceptionHandler handler = new ExceptionHandler();

    int vinylCode = handler.getExitCode(
        new DuplicateCatalogueException(
            "Duplicate catalogue"));

    int generalCode = handler.getExitCode(
        new Exception("General error"));

    System.out.println(
        "Vinyl Exit Code = " + vinylCode);

    System.out.println(
        "General Exit Code = " + generalCode);

    if (vinylCode == 2
        && generalCode == 99) {

      System.out.println(
          "Feature10 Test6 Passed");

    } else {

      System.out.println(
          "Feature10 Test6 Failed");

    }

  }

}