package model;

public class Artist {

  private int artistId;
  private String name;
  private String country;

  public Artist(int artistId,
      String name,
      String country) {

    this.artistId = artistId;
    this.name = name;
    this.country = country;
  }

  public int getArtistId() {
    return artistId;
  }

  public String getName() {
    return name;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public String toString() {
    return name;
  }
}