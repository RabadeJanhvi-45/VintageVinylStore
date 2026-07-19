package exceptions;

public class UnknownArtistException
    extends CatalogueException {

  public UnknownArtistException(String message) {

    super(
        "UNKNOWN_ARTIST_EXCEPTION",
        message);

  }

  @Override
  public String getErrorCode() {
    return "UNKNOWN_ARTIST_EXCEPTION";
  }
}