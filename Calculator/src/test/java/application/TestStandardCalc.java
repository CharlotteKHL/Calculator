package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {
  
  private StandardCalc testCalc;

  @BeforeEach
  void initialise() {
    testCalc = new StandardCalc();
  }
  
  //Test1
  @Test
  void testConstructor() {
    testCalc = new StandardCalc();
    assertNotNull(testCalc);
  }
  
  //Test2
  @Test
  void testEvaluateSimple() {
    assertEquals(4f, testCalc.evaluate("2 + 2"), "Test that 2 + 2 = 4");
  }

}
