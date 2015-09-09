import static org.junit.Assert.assertEquals;
import org.junit.*;

public class RoverTest {
  Rover rover1;
  Rover rover2;
  Terrain mars;

  @Before
  public void initialize() {
    mars = new Terrain(5, 5);
    rover1 = new Rover(1, 2, "N");
    rover2 = new Rover(3, 3, "E");
    rover1.setTerrain(mars);
    rover2.setTerrain(mars);
  }

  @Test
  public void getsPosition(){
    assertEquals(1, rover1.getPosition()[0]);
    assertEquals(2, rover1.getPosition()[1]);

    assertEquals(3, rover2.getPosition()[0]);
    assertEquals(3, rover2.getPosition()[1]);
  }

  @Test
  public void getsDirection(){
    assertEquals("N", rover1.getDirection());
    assertEquals("E", rover2.getDirection());
  }

  @Test
  public void getsCardinal(){
    assertEquals("N", rover1.getCardinal()[0]);
    assertEquals("E", rover1.getCardinal()[1]);
    assertEquals("S", rover1.getCardinal()[2]);
    assertEquals("W", rover1.getCardinal()[3]);

    assertEquals("E", rover2.getCardinal()[0]);
    assertEquals("S", rover2.getCardinal()[1]);
    assertEquals("W", rover2.getCardinal()[2]);
    assertEquals("N", rover2.getCardinal()[3]);
  }

  @Test
  public void setsCardinal(){
    assertEquals(rover1.getDirection(), rover1.getCardinal()[0]);

    assertEquals(rover2.getDirection(), rover2.getCardinal()[0]);
  }

  @Test
  public void rotatesCardinalDirection(){
    rover1.rotateCardinal(1);
    String[] rover1cardinals = rover1.getCardinal();
    assertEquals("E", rover1cardinals[0]);
    assertEquals("S", rover1cardinals[1]);
    assertEquals("W", rover1cardinals[2]);
    assertEquals("N", rover1cardinals[3]);

    rover2.rotateCardinal(3);
    String[] rover2cardinals = rover2.getCardinal();
    assertEquals("N", rover2cardinals[0]);
    assertEquals("E", rover2cardinals[1]);
    assertEquals("S", rover2cardinals[2]);
    assertEquals("W", rover2cardinals[3]);
  }

  @Test
  public void changesDirection(){
    rover1.updateDirection();
    rover2.updateDirection();
  }

  @Test
  public void turnsLeft(){
    rover1.turnLeft();
    assertEquals("W", rover1.getDirection());

    rover2.turnLeft();
    assertEquals("N", rover2.getDirection());
  }

  @Test
  public void turnsRight(){
    rover1.turnRight();
    assertEquals("E", rover1.getDirection());

    rover2.turnRight();
    assertEquals("S", rover2.getDirection());
  }

  @Test
  public void movesForward(){
    rover1.moveForward();
    assertEquals(3, rover1.getPosition()[1]);
    assertEquals(1, rover1.getPosition()[0]);

    rover2.moveForward();
    assertEquals(4, rover2.getPosition()[0]);
    assertEquals(3, rover2.getPosition()[1]);
  }

  @Test
  public void executesInstructions(){
    rover1.executeInstructions("LMLMLMLMM");
    assertEquals(1, rover1.getPosition()[0]);

    assertEquals(3, rover1.getPosition()[1]);

    assertEquals("N", rover1.getDirection());

    rover2.executeInstructions("MMRMMRMRRMM");
    assertEquals(5, rover2.getPosition()[0]);
    assertEquals(1, rover2.getPosition()[1]);
    assertEquals("E", rover2.getDirection());
  }

}

// Need to write tests to check that error is raised for error messages/invalid input