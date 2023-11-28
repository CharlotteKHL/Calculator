package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  private RevPolishCalc testCalc;

  //Test1
  @BeforeEach
  void testConstructor() {
    testCalc = new RevPolishCalc();
    assertNotNull(testCalc, "Constructor test");
  }
  
  //Test2
  @Test
  void testEvaluate() {
    assertEquals(5, testCalc.evaluate("0 5 +"), "Test 0 + 5 = 5");
  }
  
  //Test3
  @Test
  void testEvaluateMany() {
    assertEquals(5, testCalc.evaluate("0 5 +"), "Test 0 + 5 = 5");
    assertEquals(7, testCalc.evaluate("2 5 +"), "Test 2 + 5 = 7");
  }

}
