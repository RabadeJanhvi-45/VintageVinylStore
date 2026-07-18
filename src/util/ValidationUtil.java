package util;

import enums.RPM;

public class ValidationUtil {

  public static boolean validateYear(int year) {

    return year >= Constants.MIN_YEAR
        &&
        year <= Constants.CURRENT_YEAR;

  }

  public static boolean validateRPM(RPM rpm) {

    return rpm == RPM.RPM_33
        ||
        rpm == RPM.RPM_45
        ||
        rpm == RPM.RPM_78;

  }

}