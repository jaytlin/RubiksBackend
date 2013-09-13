package src;

public enum TurnFace {
  LEFT("left"),
  RIGHT("right"),
  TOP("top"),
  BOTTOM("bottom"),
  FRONT("front"),
  BACK("back");

  private String value;

  private TurnFace(String value) {
    this.value = value;
  }

  public static TurnFace fromValue(String value) {
    if(value != null) {
      value = value.toLowerCase();
      for(TurnFace face : TurnFace.values()) {
        if(value.equalsIgnoreCase(face.value)) {
          return face;
        }

        throw new RuntimeException("Invalid value");
      }
    }

    throw new RuntimeException("Invalid value");
  }
}

