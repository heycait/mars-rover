import static org.junit.Assert.assertEquals;
import org.junit.*;

public class RotateTest {
  Rotate obj;
  String[] testArray = new String[5];

  @Before
  public void initialize() {
    testArray[0] = "1";
    testArray[1] = "2";
    testArray[2] = "3";
    testArray[3] = "4";
    testArray[4] = "5";
  }

  @Test
  public void rotatesArray(){
    obj.rotate(testArray, 1);
    assertEquals("2", testArray[0]);
    assertEquals("3", testArray[1]);
    assertEquals("4", testArray[2]);
    assertEquals("5", testArray[3]);
    assertEquals("1", testArray[4]);
  }

  @Test
  public void reverseRotatesArray(){
    obj.rotate(testArray, 4);
    assertEquals("5", testArray[0]);
    assertEquals("1", testArray[1]);
    assertEquals("2", testArray[2]);
    assertEquals("3", testArray[3]);
    assertEquals("4", testArray[4]);
  }
}