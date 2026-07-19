package exceptions;

import model.ErrorContext;

public class DuplicateCatalogueException
    extends CatalogueException {

  public DuplicateCatalogueException(String message) {

    super(
        "DUPLICATE_CATALOGUE_EXCEPTION",
        message);

  }

  public DuplicateCatalogueException(String message,
      ErrorContext context) {

    super(
        "DUPLICATE_CATALOGUE_EXCEPTION",
        message,
        context);

  }

  @Override
  public String getErrorCode() {
    return "DUPLICATE_CATALOGUE_EXCEPTION";
  }
}