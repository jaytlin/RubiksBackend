package src;

public enum CubeSection {
  LEFT("left"), 
  RIGHT("right"),
  TOP("top"),
  BOTTOM("bottom"),
  VERTICAL_MIDDLE("vertical_middle"),
  HORIZONTAL_MIDDLE("horizonal_middle");

  private String value;

  private CubeSection(String value) {
    this.value = value;
  }

  public static CubeSection fromValue(String value) {
    if(value != null) {
      value = value.toLowerCase();
      for(CubeSection section : CubeSection.values()) {
        if(value.equalsIgnoreCase(section.value)) {
          return section;
        }
      }
    }

    throw new RuntimeException("Invalid value");
  }
}
