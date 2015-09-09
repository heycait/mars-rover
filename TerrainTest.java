import static org.junit.Assert.assertEquals;
import org.junit.*;

public class TerrainTest {
  Terrain mars;

  @Before
  public void initialize() {
    mars = new Terrain(5,5);
  }

  @Test
  public void getsCoordinates(){
    assertEquals(5, mars.getX());
    assertEquals(5, mars.getY());
  }

  @Test
  public void setsCoordinates(){
    mars.setX(3);
    mars.setY(2);
    assertEquals(3, mars.getX());
    assertEquals(2, mars.getY());
  }

}