package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {
  
  StrStack testStack;
  
  @BeforeEach
  void initialise() {
    testStack = new StrStack();
  }

  //Test1
  @Test
  void testConstructor() {
    assertNotNull(testStack);
  }
  
  //Test2
  @Test
  void testEmptySize() {
    assertEquals(0, testStack.size(), "Test the size of an empty stack is 0");
  }
  
  //Test3
  @Test
  void testPush() {
    assertEquals(0, testStack.size(), "Test the size of an empty stack is 0");
    testStack.push("Hello World");
    assertEquals(1, testStack.size(), "Test the size of stack is 1 after a push");

  }
  
  //Test4
  @Test
  void testPushMultiple() {
    testStack.push("Hello");
    assertEquals(1, testStack.size(), "Test the size of stack is 1 after a push");
    testStack.push("World");
    assertEquals(2, testStack.size(), "Test the size of stack is 2 after a second push");
    testStack.push("!");
    assertEquals(3, testStack.size(), "Test the size of stack is 3 after a third push");
    
  }
  
  //Test5
  @Test
  void testPushAndPop() throws EmptyStackException, BadTypeException {
    testStack.push("Hello World!");
    assertEquals("Hello World!", testStack.pop(), "Test string popped off stack is the same as the string just pushed");
    assertEquals(0, testStack.size(), "Test size of stack is 0 after a push and pop");
  }
  
  //Test6
  @Test
  void testPushAndPopMultiple() throws EmptyStackException, BadTypeException {
    testStack.push("Hello");
    testStack.push("World");
    testStack.push("!");
    
    assertEquals("!", testStack.pop(), "Test string popped off stack is the same as the string pushed last");
    assertEquals(2, testStack.size(), "Test the size of stack is 2 after 3 push and 1 pop");

    
    assertEquals("World", testStack.pop(), "Test string popped off stack is the same as the string pushed second");
    assertEquals(1, testStack.size(), "Test the size of stack is 1 after 3 push and 2 pop");

    
    assertEquals("Hello", testStack.pop(), "Test string popped off stack is the same as the string pushed first");
    assertEquals(0, testStack.size(), "Test the size of stack is 0 after 3 push and 3 pop");


  }
  
  //Test7
  @Test
  void testEmptyPop() throws EmptyStackException, BadTypeException {
    EmptyStackException e = assertThrows(EmptyStackException.class, () -> testStack.pop());
    assertEquals("Error: Not enough numbers to calculate with. "
        + "Please check you are in the right calculation mode", e.getMessage(),"Test exception thrown when empty stack popped");
  }
  
  //Test8
  @Test
  void testTop() {
    testStack.push("Hello");
    assertEquals("Hello", testStack.top(), "Test top of stack is the string most recently pushed");
    assertEquals(1, testStack.size(), "Test that size of stack remains unchanged");
  }

}
