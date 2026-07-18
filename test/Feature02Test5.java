package VintageVinylStore.test;

import model.Pressing;
import repository.PressingRepository;

public class Feature02Test5 {

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

    repository.addPressing(p1);

    repository.delete(1);

    System.out.println(p1.isDeleted());

  }

}