package exceptions;

import java.io.Serializable;
import model.ErrorContext;

public class VinylException extends Exception implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String errorCode;
  protected ErrorContext context;

  public VinylException(String errorCode,
      String message) {

    super(message);
    this.errorCode = errorCode;
    this.context = new ErrorContext();

  }

  public VinylException(String errorCode,
      String message,
      ErrorContext context) {

    super(message);
    this.errorCode = errorCode;
    this.context = context;

  }

  public String getErrorCode() {
    return errorCode;
  }

  public ErrorContext getContext() {
    return context;
  }

}