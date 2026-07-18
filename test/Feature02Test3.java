package VintageVinylStore.test;

import model.Pressing;
import repository.PressingRepository;

public class Feature02Test3 {

  public static void main(String[] args) {

    PressingRepository repository = new PressingRepository();

    Pressing p1 = new Pressing(
        1,
        101,
        "EMI",
        "A123",
        "B123",
        1979,
        true,
        false,
        "",
        "");

    Pressing p2 = new Pressing(
        2,
        101,
        "Sony",
        "A123",
        "B123",
        1980,
        false,
        false,
        "",
        "");

    repository.addPressing(p1);

    try {

      repository.addPressing(p2);

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}
