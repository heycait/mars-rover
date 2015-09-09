public class Rover {

  int[] mPosition = new int[2];
  String mDirection;
  String[] mCardinalDirections = { "N", "E", "S", "W" };
  String mInstructions;
  Terrain mTerrain;

  public Rover(int x, int y, String letter) {
    mPosition[0] = x;
    mPosition[1] = y;
    mDirection = letter;
    setCardinal(letter);
  }

  public void setTerrain(Terrain terrain){
    mTerrain = terrain;
  }

  public int[] getPosition() {
    return mPosition;
  }

  public String getDirection() {
    return mDirection;
  }

  public String[] getCardinal() {
    return mCardinalDirections;
  }

  // Pull it out into Rotate.java file.
  public String[] rotate(String[] array, int number) {
    int increment = 0;
    String[] newArray = array;
    while (increment < number) {
      String firstElement = newArray[0];

      for (int i = 0; i < newArray.length - 1; i++) {
        newArray[i] = newArray[i + 1];
      }

      newArray[newArray.length - 1] = firstElement;
      increment++;
    }
    return newArray;
  }

  public String[] setCardinal(String letter) {
    while (!mCardinalDirections[0].equals(letter)) {
      // System.out.println(">>>>>>>>>>>>>>>>>");
      // System.out.println(mCardinalDirections[0]);
      // System.out.println(letter);
      // System.out.println(mCardinalDirections[0].equals(letter));
      // System.out.println("<<<<<<<<<<<<<<<<<");
      rotateCardinal(1);
    }

    return mCardinalDirections;
  }

  public String[] rotateCardinal(int num) {
    mCardinalDirections = rotate(mCardinalDirections, num);
    return mCardinalDirections;
  }

  public String updateDirection() {
    mDirection = mCardinalDirections[0];
    return mDirection;
  }

  public void turnLeft() {
    rotateCardinal(3);
    updateDirection();
  }

  public void turnRight() {
    rotateCardinal(1);
    updateDirection();
  }

  // Add error messages/error note if rover can't move in that direction
  // Give reason why such as obstacle/other rover in the way or end of landscape
  public void moveForward() {
    switch (mDirection) {
      case "N": if (mPosition[1] < mTerrain.getY()) {
                  mPosition[1] += 1;
                }
                break;
      case "E": if (mPosition[0] < mTerrain.getX()) {
                  mPosition[0] += 1;
                }
                break;
      case "S": if (mPosition[1] > 0) {
                  mPosition[1] -= 1;
                }
                break;
      case "W": if (mPosition[0] > 0) {
                  mPosition[0] -= 1;
                }
                break;
      default: System.out.println("Invalid direction");
               // Replace default with actual error message
               break;
    }
  }

  public void executeInstructions(String instructions) {
    for (int i = 0; i < instructions.length(); i++) {
      switch(instructions.charAt(i)) {
        case 'L': turnLeft();
                  break;
        case 'R': turnRight();
                  break;
        case 'M': moveForward();
                  break;
        default: System.out.println("Invalid command. L - left, R - right, or M - move.");
                 // Replace default with actual error message
                 break;
      }
    }
  }

}