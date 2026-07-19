package exceptions;

public class ReservedForAnotherCustomerException
    extends VinylException {

  public ReservedForAnotherCustomerException(String message) {

    super(
        "RESERVED_FOR_ANOTHER_CUSTOMER_EXCEPTION",
        message);

  }

}