public enum TurnFace {
  LEFT("left"),
  RIGHT("right"),
  TOP("top"),
  BOTTOM("bottom");

  public static String fromValue(String value) {
    if(value != null) {
      value = value.toLowerCase();
      for(TurnFace face : TurnFace.values()) {
        if(value.equalsIgnoreCase(face.text)) {
          return face;
        }
      }
    }
  }
}
