public class Rotate {

  public static void main(String[] args) {
  }

  public static String[] rotate(String[] array, int number) {
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

}


// Wanted to put rotate method in it's own class for separation of concerns and single responsibility methods
// Need to figure out best way to call this method in the Rover file. Possible solution: Create empty Rotate object and then call the rotate method on it taking in the rover's cardinal directions array.
