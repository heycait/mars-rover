public class Terrain {
  private int mX;
  private int mY;

  public Terrain(int x, int y) {
    mX = x;
    mY = y;
  }

  // Setter methods in case there are changes in the landscape after initialization
  public void setX(int num) {
    mX = num;
  }

  public int getX() {
    return mX;
  }

  public int getY() {
    return mY;
  }

  public void setY(int num) {
    mY = num;
  }
}

// Need Terrain class to monitor what's on it and where. Have rover check this info first to see if space is empty before moving.
// Write a method that keeps track of where obstacles (i.e. rovers) are so the rovers don't run into themselves or anything else