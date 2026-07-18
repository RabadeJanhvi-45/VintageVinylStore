package VintageVinylStore.test;

import model.Pressing;
import repository.PressingRepository;

public class Feature02Test1 {

  public static void main(String[] args) {

    PressingRepository repository = new PressingRepository();

    Pressing p1 = new Pressing(
        1,
        101,
        "EMI UK",
        "A123",
        "B123",
        1979,
        true,
        false,
        "UK First",
        "Original");

    repository.addPressing(p1);

    System.out.println("Test 1 Passed");

  }

}