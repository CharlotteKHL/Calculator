package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {
  private NumStack numStack;
  
  @BeforeEach
  void initialise() {
    numStack = new NumStack();
  }
  
  //Test1
  @Test
  void testConstructor() {
    assertNotNull(numStack, "Constructor test");
  }
  
  //Test2
  @Test
  void testSize() {
    assertEquals(0, numStack.size(), "Test size method returns 0 in an empty stack");
  }
  
  //Test3
  @Test
  void testPush() {
    numStack.push(2.3f);
    assertEquals(1, numStack.size());
  }
  
  //Test4
  @Test
  void testMultiplePush() {
    numStack.push(2.3f);
    numStack.push(2.4f);
    assertEquals(2, numStack.size(), "Test size increase to 2");
    numStack.push(2.5f);
    assertEquals(3, numStack.size(), "Test size increase to 3");
  }
  
  //Test5
  @Test
  void testPushAndPop() throws EmptyStackException, BadTypeException{
    numStack.push(2.3f);
    assertEquals(2.3f, numStack.pop(), "Test pop returns the value pushed");
    assertEquals(0, numStack.size());
  }
  
  //Test6
  @Test
  void testPushAndPopMultiple() throws EmptyStackException, BadTypeException{
    numStack.push(2.3f);
    numStack.push(2.4f);
    numStack.push(2.5f);
    assertEquals(2.5f, numStack.pop(), "Test pop returns the 3rd value pushed");
    assertEquals(2, numStack.size(), "Test size descrease to 2");
    assertEquals(2.4f, numStack.pop(), "Test pop returns the 2nd value pushed");
    assertEquals(1, numStack.size(), "Test size decrease to 1");
    assertEquals(2.3f, numStack.pop(), "Test pop returns the 1st value pushed");
  }
  
  //Test7
  @Test
  void testEmptyPop() {
    EmptyStackException e = assertThrows(EmptyStackException.class, () -> numStack.pop());
    assertEquals("Error: Not enough numbers to calculate with. "
        + "Please check you are in the right calculation mode", e.getMessage(),"Test exception thrown when empty stack popped");
  }
  
  //Test8
  @Test
  void testTopMethod() throws EmptyStackException, BadTypeException {
    numStack.push(2.3f);
    assertEquals(2.3f, numStack.top(), "Test returns value on top");
    assertEquals(1, numStack.size(), "Test size remains the same");
    assertEquals(2.3f, numStack.pop(), "Test can still pop the value on top");
  }
  
  //Test9
  @Test
  void testTopAfterPushAndPop() throws EmptyStackException, BadTypeException {
    numStack.push(2.3f);
    numStack.push(2.4f);
    assertEquals(2.4f, numStack.top(), "Test returns value on top");
    numStack.pop();
    assertEquals(2.3f, numStack.top(), "Test returns new value on top after pop");
  }
  
  //Test10
  @Test
  void testTopWithEmptyStack() {
    EmptyStackException e = assertThrows(EmptyStackException.class, () -> numStack.top());
    assertEquals("Error: Not enough numbers to calculate with. "
        + "Please check you are in the right calculation mode", e.getMessage(),"Test exception thrown when top called on empty stack");
  }
}
