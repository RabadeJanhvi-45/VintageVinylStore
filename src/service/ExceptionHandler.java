package service;

import exceptions.ReservedForAnotherCustomerException;
import exceptions.VinylException;
import exceptions.ReservedForAnotherCustomerException;

public class ExceptionHandler {

  public int getExitCode(Exception exception) {

    if (exception instanceof VinylException) {

      return 2;

    }

    return 99;

  }

  public boolean isBlocking(Exception exception) {

    if (exception instanceof ReservedForAnotherCustomerException) {

      return false;

    }

    return true;

  }
}