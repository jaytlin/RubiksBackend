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

  public turnSide(TurnFace face, int numSteps) {
    numSteps = numSteps % 4;
    switch(face) {
      case TurnFace.FRONT:
        turnFront(section, numSteps);
        break;
      case TurnFace.BACK:
        turnBack(section, numSteps);
        break;
      case TurnFace.LEFT:
        turnLeft(section, numSteps);
        break;
      case TurnFace.RIGHT:
        turnRight(section, numSteps);
        break;
      case TurnFace.TOP:
        turnTop(section, numSteps);
        break;
      case TurnFace.BOTTOM:
        turnBottom(section, numSteps);
        break;
      default: 
        throw new RuntimeException("Invalid TurnFace type!"); 
    }
  }

  private turnFront(int numSteps) {
    char[] topFaceSection = this.top.getSection(TurnSection.BOTTOM);
    char[] leftFaceSection = this.left.getSection(TurnSection.RIGHT);
    char[] rightFaceSection = this.right.getSection(TurnSection.LEFT);
    char[] bottomFaceSection = this.bottom.getSection(TurnSection.TOP);

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

    this.top.setSection(topFaceSection);
    this.left.setSection(leftFaceSection);
    this.right.setSection(rightFaceSection);
    this.bottom.setSection(bottomFaceSection);
    this.front.rotate(numSteps)
  }

  private turnBack(int numSteps) {
    char[] topFaceSection = this.top.getSection(TurnSection.BOTTOM);
    char[] leftFaceSection = this.left.getSection(TurnSection.RIGHT);
    char[] rightFaceSection = this.right.getSection(TurnSection.LEFT);
    char[] bottomFaceSection = this.bottom.getSection(TurnSection.TOP);

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

    this.top.setSection(topFaceSection);
    this.left.setSection(leftFaceSection);
    this.right.setSection(rightFaceSection);
    this.bottom.setSection(bottomFaceSection);
    this.back.rotate(numSteps)
  }

  private turnRight(int numSteps) {
    char[] topFaceSection = this.top.getSection(TurnSection.BOTTOM);
    char[] frontFaceSection = this.front.getSection(TurnSection.RIGHT);
    char[] backFaceSection = this.back.getSection(TurnSection.LEFT);
    char[] bottomFaceSection = this.bottom.getSection(TurnSection.TOP);

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

    this.top.setSection(topSection);
    this.front.setSection(frontFaceSection);
    this.back.setSection(backFaceSection);
    this.bottom.setSection(bottomFaceSection);
    this.right.rotate(numSteps)
  }

  private turnLeft(int numSteps) {
    char[] topFaceSection = this.top.getSection(TurnSection.BOTTOM);
    char[] frontFaceSection = this.front.getSection(TurnSection.RIGHT);
    char[] backFaceSection = this.back.getSection(TurnSection.LEFT);
    char[] bottomFaceSection = this.bottom.getSection(TurnSection.TOP);

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

    this.top.setSection(topSection);
    this.front.setSection(frontFaceSection);
    this.back.setSection(backFaceSection);
    this.bottom.setSection(bottomFaceSection);
    this.right.rotate(numSteps)
  }

  private turnTop(int numSteps) {
    char[] leftFaceSection = this.left.getSection(TurnSection.BOTTOM);
    char[] frontFaceSection = this.front.getSection(TurnSection.RIGHT);
    char[] backFaceSection = this.back.getSection(TurnSection.LEFT);
    char[] rightFaceSection = this.right.getSection(TurnSection.TOP);

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

    this.left.setSection(leftFaceSection);
    this.front.setSection(frontFaceSection);
    this.back.setSection(backFaceSection);
    this.right.setSection(rightFaceSection);
    this.top.rotate(numSteps)
  }

  private turnBottom(int numSteps) {
    char[] leftFaceSection = this.left.getSection(TurnSection.BOTTOM);
    char[] frontFaceSection = this.front.getSection(TurnSection.RIGHT);
    char[] backFaceSection = this.back.getSection(TurnSection.LEFT);
    char[] rightFaceSection = this.right.getSection(TurnSection.TOP);

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

    this.left.setSection(leftFaceSection);
    this.front.setSection(frontFaceSection);
    this.back.setSection(backFaceSection);
    this.right.setSection(rightFaceSection);
    this.top.rotate(numSteps)
  }

  public String toString() {
    return "top: \n" + this.top.toString() + "left: \n" + this.left.toString() + "front: \n" + this.front.toString() + 
      "right: \n" + this.right.toString() + "back: \n" + this.back.toString() + "bottom: \n" + this.bottom.toString();
  }
}
