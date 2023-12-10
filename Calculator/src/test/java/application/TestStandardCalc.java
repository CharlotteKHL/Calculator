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
  void testEvaluateSimple() throws EmptyStackException, BadTypeException, InvalidExpressionException  {
    assertEquals(4f, testCalc.evaluate("2 + 2"), "Test that 2 + 2 = 4");
  }
  
  //Test3
  @Test
  void testEvaluateAddMutliple() throws EmptyStackException, BadTypeException, InvalidExpressionException  {
    assertEquals(2f, testCalc.evaluate("1 + 1"), "Test that 1 + 1 = 2");
    assertEquals(25f, testCalc.evaluate("10 + 15"), "Test that 10 + 15 = 25");
    assertEquals(30f, testCalc.evaluate("10 + 10 + 10"), "Test that 10 + 10 + 10 = 30");
    
  }
  
  //Test4
  @Test
  void testEvaluateMinusMultiple() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    assertEquals(4f, testCalc.evaluate("8 - 4"), "Test 8 - 4 = 4");
    assertEquals(15f, testCalc.evaluate("20 - 5"), "Test 20 - 5 = 15");
    assertEquals(12f, testCalc.evaluate("18 - 1 - 5"), "Test 18 - 1 - 5 = 12");
    assertEquals(9f, testCalc.evaluate("15 - 3 - 2 - 1"), "Test 15 - 3 - 2 - 1 = 9");

  }

}
