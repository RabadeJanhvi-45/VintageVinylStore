package VintageVinylStore.test;

import enums.*;
import exceptions.DuplicateCatalogueException;
import model.record.*;
import repository.RecordRepository;

public class Feature01Test {

  public static void main(String[] args) {

    RecordRepository repo = new RecordRepository();

    try {

      LP lp = new LP(
          1,
          "Pink Floyd",
          "The Wall",
          "EMI",
          "CAT001",
          Country.UK,
          1979,
          RPM.RPM_33,
          MonoStereo.STEREO,
          true);

      Single single = new Single(
          2,
          "Queen",
          "Bohemian Rhapsody",
          "EMI",
          "CAT002",
          Country.UK,
          1975,
          RPM.RPM_45,
          MonoStereo.STEREO,
          "Bohemian Rhapsody",
          "I'm In Love With My Car");

      repo.addRecord(lp);
      repo.addRecord(single);

      for (model.record.Record r : repo.getAllRecords()) {

        System.out.println(r.describe());
        System.out.println(r.defaultSleeveType());
        System.out.println(r.suggestedJacketWeightG());

      }

    } catch (DuplicateCatalogueException e) {

      System.out.println(e.getMessage());

    }

  }

}