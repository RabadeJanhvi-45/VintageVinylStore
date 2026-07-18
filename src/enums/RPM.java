package enums;

public enum RPM {

  RPM_33(33),
  RPM_45(45),
  RPM_78(78);

  private final int value;

  RPM(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}