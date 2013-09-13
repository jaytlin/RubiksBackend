package src;

public class Cube {
  private Face top;
  private Face bottom;
  private Face front;
  private Face back;
  private Face left;
  private Face right;

  public Cube(Face top, Face left, Face front, Face right, Face back, Face bottom) {
    this.top = top;
    this.bottom = bottom;
    this.front = front;
    this.back = back;
    this.left = left;
    this.right = right;
  }

  public void turnSide(TurnFace face, int numSteps) {
    numSteps = numSteps % 4;
    switch(face) {
      case FRONT:
        turnFront(numSteps);
        break;
      case BACK:
        turnBack(numSteps);
        break;
      case LEFT:
        turnLeft(numSteps);
        break;
      case RIGHT:
        turnRight(numSteps);
        break;
      case TOP:
        turnTop(numSteps);
        break;
      case BOTTOM:
        turnBottom(numSteps);
        break;
      default: 
        throw new RuntimeException("Invalid TurnFace type!"); 
    }
  }

  private void turnFront(int numSteps) {
    char[] topFaceSection = this.top.getTurnSection(CubeSection.BOTTOM);
    char[] leftFaceSection = this.left.getTurnSection(CubeSection.RIGHT);
    char[] rightFaceSection = this.right.getTurnSection(CubeSection.LEFT);
    char[] bottomFaceSection = this.bottom.getTurnSection(CubeSection.TOP);

    numSteps = 4 - numSteps;

    for(int i = 0; i < numSteps; i++) {
      char[] temp1;
      char[] temp2;

      temp1 = topFaceSection;
      topFaceSection = leftFaceSection;
      
      temp2 = rightFaceSection;
      rightFaceSection = temp1; 

      temp1 = bottomFaceSection;
      bottomFaceSection = temp2;

      leftFaceSection = temp1;
    }

    this.top.setTurnSection(CubeSection.BOTTOM, topFaceSection);
    this.left.setTurnSection(CubeSection.RIGHT, leftFaceSection);
    this.right.setTurnSection(CubeSection.LEFT, rightFaceSection);
    this.bottom.setTurnSection(CubeSection.TOP, bottomFaceSection);
    this.front.rotate(numSteps);
  }

  private void turnBack(int numSteps) {
    char[] topFaceSection = this.top.getTurnSection(CubeSection.BOTTOM);
    char[] leftFaceSection = this.left.getTurnSection(CubeSection.RIGHT);
    char[] rightFaceSection = this.right.getTurnSection(CubeSection.LEFT);
    char[] bottomFaceSection = this.bottom.getTurnSection(CubeSection.TOP);

    numSteps = 4 - numSteps;

    for(int i = 0; i < numSteps; i++) {
      char[] temp1;
      char[] temp2;

      temp1 = topFaceSection;
      topFaceSection = rightFaceSection;
      
      temp2 = leftFaceSection;
      leftFaceSection = temp1; 

      temp1 = bottomFaceSection;
      bottomFaceSection = temp2;

      rightFaceSection = temp1;
    }

    this.top.setTurnSection(CubeSection.BOTTOM, topFaceSection);
    this.left.setTurnSection(CubeSection.RIGHT, leftFaceSection);
    this.right.setTurnSection(CubeSection.LEFT, rightFaceSection);
    this.bottom.setTurnSection(CubeSection.TOP, bottomFaceSection);
    this.back.rotate(numSteps);
  }

  private void turnRight(int numSteps) {
    char[] topFaceSection = this.top.getTurnSection(CubeSection.BOTTOM);
    char[] frontFaceSection = this.front.getTurnSection(CubeSection.RIGHT);
    char[] backFaceSection = this.back.getTurnSection(CubeSection.LEFT);
    char[] bottomFaceSection = this.bottom.getTurnSection(CubeSection.TOP);

    numSteps = 4 - numSteps;

    for(int i = 0; i < numSteps; i++) {
      char[] temp1;
      char[] temp2;

      temp1 = topFaceSection;
      topFaceSection = frontFaceSection;
      
      temp2 = backFaceSection;
      backFaceSection = temp1; 

      temp1 = bottomFaceSection;
      bottomFaceSection = temp2;

      frontFaceSection = temp1;
    }

    this.top.setTurnSection(CubeSection.BOTTOM, topFaceSection);
    this.front.setTurnSection(CubeSection.RIGHT, frontFaceSection);
    this.back.setTurnSection(CubeSection.LEFT, backFaceSection);
    this.bottom.setTurnSection(CubeSection.TOP, bottomFaceSection);
    this.right.rotate(numSteps);
  }

  private void turnLeft(int numSteps) {
    char[] topFaceSection = this.top.getTurnSection(CubeSection.BOTTOM);
    char[] frontFaceSection = this.front.getTurnSection(CubeSection.RIGHT);
    char[] backFaceSection = this.back.getTurnSection(CubeSection.LEFT);
    char[] bottomFaceSection = this.bottom.getTurnSection(CubeSection.TOP);

    numSteps = 4 - numSteps;

    for(int i = 0; i < numSteps; i++) {
      char[] temp1;
      char[] temp2;

      temp1 = topFaceSection;
      topFaceSection = backFaceSection;
      
      temp2 = frontFaceSection;
      frontFaceSection = temp1; 

      temp1 = bottomFaceSection;
      bottomFaceSection = temp2;

      backFaceSection = temp1;
    }

    this.top.setTurnSection(CubeSection.BOTTOM, topFaceSection);
    this.front.setTurnSection(CubeSection.RIGHT, frontFaceSection);
    this.back.setTurnSection(CubeSection.LEFT, backFaceSection);
    this.bottom.setTurnSection(CubeSection.TOP, bottomFaceSection);
    this.right.rotate(numSteps);
  }

  private void turnTop(int numSteps) {
    char[] leftFaceSection = this.left.getTurnSection(CubeSection.BOTTOM);
    char[] frontFaceSection = this.front.getTurnSection(CubeSection.RIGHT);
    char[] backFaceSection = this.back.getTurnSection(CubeSection.LEFT);
    char[] rightFaceSection = this.right.getTurnSection(CubeSection.TOP);

    numSteps = 4 - numSteps;

    for(int i = 0; i < numSteps; i++) {
      char[] temp1;
      char[] temp2;

      temp1 = leftFaceSection;
      leftFaceSection = frontFaceSection;
      
      temp2 = backFaceSection;
      backFaceSection = temp1; 

      temp1 = rightFaceSection;
      rightFaceSection = temp2;

      frontFaceSection = temp1;
    }

    this.left.setTurnSection(CubeSection.BOTTOM, leftFaceSection);
    this.front.setTurnSection(CubeSection.RIGHT, frontFaceSection);
    this.back.setTurnSection(CubeSection.LEFT, backFaceSection);
    this.right.setTurnSection(CubeSection.TOP, rightFaceSection);
    this.top.rotate(numSteps);
  }

  private void turnBottom(int numSteps) {
    char[] leftFaceSection = this.left.getTurnSection(CubeSection.BOTTOM);
    char[] frontFaceSection = this.front.getTurnSection(CubeSection.RIGHT);
    char[] backFaceSection = this.back.getTurnSection(CubeSection.LEFT);
    char[] rightFaceSection = this.right.getTurnSection(CubeSection.TOP);

    numSteps = 4 - numSteps;

    for(int i = 0; i < numSteps; i++) {
      char[] temp1;
      char[] temp2;

      temp1 = leftFaceSection;
      leftFaceSection = backFaceSection;
      
      temp2 = frontFaceSection;
      frontFaceSection = temp1; 

      temp1 = rightFaceSection;
      rightFaceSection = temp2;

      backFaceSection = temp1;
    }

    this.left.setTurnSection(CubeSection.BOTTOM, leftFaceSection);
    this.front.setTurnSection(CubeSection.RIGHT, frontFaceSection);
    this.back.setTurnSection(CubeSection.LEFT, backFaceSection);
    this.right.setTurnSection(CubeSection.TOP, rightFaceSection);
    this.top.rotate(numSteps);
  }

  public String toString() {
    return "top: \n" + this.top.toString() + "left: \n" + this.left.toString() + "front: \n" + this.front.toString() + 
      "right: \n" + this.right.toString() + "back: \n" + this.back.toString() + "bottom: \n" + this.bottom.toString();
  }
}
