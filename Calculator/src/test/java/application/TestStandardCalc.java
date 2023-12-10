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
  
  //Test5
  @Test 
  void testEvaluateMultiplyMultiple() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    assertEquals(40f, testCalc.evaluate("8 * 5"), "Test 8*5 = 40");
    assertEquals(0f, testCalc.evaluate("2 * 0"), "Test 2*0");
    assertEquals(24f, testCalc.evaluate("3 * 2 * 4"), "Test 3*2*4 = 24");
    assertEquals(300f, testCalc.evaluate("2 * 5 * 10 * 3"), "Test 2*5*10*3 = 300");

  }
  
  //Test6
  @Test 
  void testEvaluateDivideMultiple() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    assertEquals(2f, testCalc.evaluate("8 / 4"), "Test 8/4 = 2");
    assertEquals(4f, testCalc.evaluate("20 / 5"), "Test 20/5 = 4");
    assertEquals(5f, testCalc.evaluate("100 / 10 / 2"), "Test 100/10/2 = 5");
    assertEquals(0.5f, testCalc.evaluate("30 / 5 / 6 / 2"), "Test 30/5/6/2 = 1/2");
  }
  
  //Test7
  @Test
  void testMultiplyOverAdd() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    assertEquals(10f, testCalc.evaluate("2 * 4 + 2"), "Test that multiplication has precedence over addition");
    assertEquals(83f , testCalc.evaluate("2 * 5 * 8 + 1 * 3"), "Test that multiplication has precedence over addition in longer expressions");
  }

  //Test8
  @Test
  void testMultiplyOverMinus() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    assertEquals(6f, testCalc.evaluate("2 * 4 - 2"), "Test that multiplication has precedence over subtraction");
    assertEquals(20f , testCalc.evaluate("5 * 8 - 2 * 7 - 2 * 3"), "Test that multiplication has precedence over subtraction in longer expressions");

  }
  
  //Test9
  @Test
  void testDivideOverAdd() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    assertEquals(6f, testCalc.evaluate("8 / 2 + 2"), "Test that division has precedence over addition");
    assertEquals(7.5f , testCalc.evaluate("10 / 2 + 20 / 2 / 5 + 1 / 2"), "Test that division has precedence over addition in longer expressions");
  }
  
  //Test10
  @Test
  void testDivideOverMinus() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    assertEquals(2f, testCalc.evaluate("8 / 2 - 2"), "Test that division has precedence over subtraction");
    assertEquals(6f , testCalc.evaluate("30 / 3 - 40 / 10 / 2 - 8 / 4"), "Test that division has precedence over subtraction in longer expressions");
  }

}
