package VintageVinylStore.test;

import model.Pressing;
import repository.PressingRepository;

public class Feature02Test4 {

  public static void main(String[] args) {

    PressingRepository repository = new PressingRepository();

    Pressing p1 = new Pressing(
        1,
        101,
        "EMI",
        "A123",
        "B123",
        null,
        true,
        false,
        "",
        "");

    try {

      repository.addPressing(p1);

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }

}