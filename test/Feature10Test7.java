package VintageVinylStore.test;

import exceptions.ReservedForAnotherCustomerException;
import service.ExceptionHandler;

public class Feature10Test7 {

  public static void run() {

    ExceptionHandler handler = new ExceptionHandler();

    ReservedForAnotherCustomerException exception = new ReservedForAnotherCustomerException(
        "Reserved by another customer.");

    boolean blocking = handler.isBlocking(exception);

    System.out.println(
        "Blocking = " + blocking);

    if (!blocking) {

      System.out.println(
          "Feature10 Test7 Passed");

    } else {

      System.out.println(
          "Feature10 Test7 Failed");

    }

  }

}