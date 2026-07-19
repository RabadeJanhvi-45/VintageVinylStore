package exceptions;

import model.ErrorContext;

public class CatalogueException extends VinylException {

  public CatalogueException(String errorCode,
      String message) {

    super(errorCode, message);

  }

  public CatalogueException(String errorCode,
      String message,
      ErrorContext context) {

    super(errorCode, message, context);

  }

}