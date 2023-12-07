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
  void testEvaluate() throws BadTypeException, EmptyStackException, InvalidExpressionException {
    assertEquals(5f, testCalc.evaluate("0 5 +"), "Test 0 + 5 = 5");
  }
  
  //Test3
  @Test
  void testEvaluateMany() throws BadTypeException, EmptyStackException, InvalidExpressionException {
    assertEquals(5f, testCalc.evaluate("0 5 +"), "Test 0 + 5 = 5");
    assertEquals(7f, testCalc.evaluate("2 5 +"), "Test 2 + 5 = 7");
  }
  
  //Test4
  @Test
  void testEvaluateLargeNum() throws BadTypeException, EmptyStackException, InvalidExpressionException {
    assertEquals(30f, testCalc.evaluate("25 5 +"), "Test 25 + 5 = 30");
  }
  
  //Test5
  @Test
  void testEvaluateMinus() throws BadTypeException, EmptyStackException, InvalidExpressionException {
    assertEquals(20f, testCalc.evaluate("25 5 -"), "Test 25 - 5 = 20");
    assertEquals(25f, testCalc.evaluate("30 5 -"), "Test 25 - 5 = 25");
  }
  
  //Test6
  @Test
  void testEvaluateMinusPlus() throws BadTypeException, EmptyStackException, InvalidExpressionException {
    assertEquals(25f, testCalc.evaluate("25 5 - 5 +"), "Test 25 - 5 + 5 = 25");
  }
  
  //Test7
  @Test
  void testEvaluateMultiply() throws BadTypeException, EmptyStackException, InvalidExpressionException {
    assertEquals(20f, testCalc.evaluate("2 10 *"), "Test 2*10 = 20");
  }
  
  //Test8
  @Test
  void testMultiplyMany() throws BadTypeException, EmptyStackException, InvalidExpressionException {
    assertEquals(20f, testCalc.evaluate("2 10 *"), "Test 2*10 = 20");
    assertEquals(25f, testCalc.evaluate("5 5 *"), "Test 5*5 = 25");
    assertEquals(12f, testCalc.evaluate("3 4 *"), "Test 3*4 = 24");
  }
  
  //Test9 
  @Test
  void testDivide() throws BadTypeException, EmptyStackException, InvalidExpressionException {
    assertEquals(2f, testCalc.evaluate("8 4 /"), "Test 8/4 = 2");
  }

  //Test10 
  @Test
  void testDivideMany() throws BadTypeException, EmptyStackException, InvalidExpressionException {
    assertEquals(4f, testCalc.evaluate("8 2 /"), "Test 8/2 = 4");
    assertEquals(3f, testCalc.evaluate("12 4 /"), "Test 12/4 = 3");
  }
  
  //Test11
  @Test
  void testComplexEvaluate() throws BadTypeException, EmptyStackException, InvalidExpressionException {
    assertEquals(11f, testCalc.evaluate("9 6 3 / +"), "Test 9 + (6/3) = 11");
    assertEquals(29f, testCalc.evaluate("3 7 + 2 / 5 * 6 8 - 2 * -"), "Test (5((3+7)/2)) - 2(6-8) = 29");
  }
  
  //Test12
  @Test
  void testEmptyExpression() {
    InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate(""));
    e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate(" 3  3 +"));
    assertEquals("Error: Current input contains too many empty spaces, "
        + "please leave one space between numbers and symbols", e.getMessage()); 
  }
  
  //Test13
  @Test
  void testSymbolWordedExpression() {
    InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate("Hello"));
    e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate("InvalidExpressionHere"));
    e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate("Hello&"));
    e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate("3 3 + 4r +"));

    assertEquals("Error: Current input contains invalid characters, please only use *,/,+,-", e.getMessage()); 

  }
  
  //Test14
  @Test
  void testNullExpression() {
    InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate(null));
    assertEquals( "Error: Current input is null", e.getMessage()); 
  }
  
  //Test15
  @Test
  void testStandardFormExpressionInvalid() {
    EmptyStackException e = assertThrows(EmptyStackException.class, () -> testCalc.evaluate("2 + 2"), "Test a standard form expression throws an error");
    assertEquals(e.getMessage(), "Error: Not enough numbers to calculate with. Please check you are in the right calculation mode");
  }
  
  //Test16
  @Test
  void testDivideByZero() throws InvalidExpressionException, BadTypeException, EmptyStackException {
     InvalidExpressionException e = assertThrows(InvalidExpressionException.class, () -> testCalc.evaluate("2 0 /"));
  }

}
