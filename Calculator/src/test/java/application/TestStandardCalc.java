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
  
  //Test11
  @Test
  void testAddAndMinus() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    assertEquals(13f, testCalc.evaluate("10 - 2 + 5"), "Test simple subtraction and addition");
    assertEquals(7f, testCalc.evaluate("8 + 2 - 2 + 4 + 8 - 9 - 4"), "Test complex subtraction and addition");
    
  }
  
  //Test12
  @Test
  void testMultiplyAndDivide() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    assertEquals(6f, testCalc.evaluate("10 * 3 / 5"), "Test simple division and multiplication");
    assertEquals(15f, testCalc.evaluate("80 / 2 * 5 / 8 / 5 * 3"), "Test complex division and multiplication");
  
  }
  
  //Test13
  @Test
  void testAllOperators() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    assertEquals((8f * 3f - 5f / 2f + 1f / 2f), testCalc.evaluate("8 * 3 - 5 / 2 + 1 / 2"), "Test simple expression evaluation");
    assertEquals((90f / 3f * 1f / 2f + 4f - 6f * 4f / 20f - 3f), testCalc.evaluate("90 / 3 * 1 / 2 + 4 - 6 * 4 / 20 - 3"), "Test complex expression evaluation");
  
  }
  
  //Test14
  @Test
  void testInvalidInput() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate("Hello"));
    assertEquals("Error: Current input contains invalid characters, please only use *,/,+,-", e.getMessage(), "Test error thrown if invalid symbols are inputed");
    
    e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate("3 +  4"));
    assertEquals("Error: Current input contains too many empty spaces, "
        + "please leave one space between numbers and symbols", e.getMessage(), "Test error thrown if input does not leave one space between numbers and symbols");

    assertEquals(2f, testCalc.evaluate("1 + 1"), "Test normal expression evaluates right after error");
    
    e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate("3 / 0"));
    assertEquals("Error: Current input divides by 0", e.getMessage(), "Test error thrown if input attempts a division by 0");
  }
  
  //Test15
  @Test
  void testNullInput() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate(null));
    assertEquals("Error: Current input is null", e.getMessage(), "Test error thrown if input is null");

  }
  
  //Test16
  @Test
  void testRevPolishForm() throws EmptyStackException, BadTypeException, InvalidExpressionException {
    InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate("8 4 /"));
    assertEquals("Error: Current input is in Reverse polish form, please check you are in the right calculation mode", e.getMessage(), "Test error thrown if input is in wrong form");
  
  }
}
