package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {

  OpStack testStack;
  Symbol plus;

  @BeforeEach
  void initialise() {
    testStack = new OpStack();
    plus = Symbol.PLUS;
    
  }

  // Test1
  @Test
  void testConstructor() {
    assertNotNull(testStack);
  }

  // Test2
  @Test
  void testSize() {
    assertEquals(0, testStack.size(), "Test an empty stack has size 0");
  }

  // Test3
  @Test
  void testPush() {
    testStack.push(plus);
    assertEquals(1, testStack.size(), "Test stack size is 1 after a push");
  }

  // Test4
  @Test
  void testPushMany() {
    
    testStack.push(plus);
    assertEquals(1, testStack.size(), "Test stack size is 1 after a push");
    testStack.push(plus);
    assertEquals(2, testStack.size(), "Test stack size is 2 after a second push");
    testStack.push(plus);
    assertEquals(3, testStack.size(), "Test stack size is 3 after a third push");

  }
  
  //Test5
  @Test
  void testPushAndPop() throws EmptyStackException, BadTypeException {
    testStack.push(plus);
    Symbol pop = testStack.pop();
    assertEquals(0, testStack.size(), "Test stack size is 0 after a push and pop");
    assertEquals(Symbol.PLUS, pop, "Test value popped off top of stack is the value pushed on");
    
  }
  
  //Test6
  @Test
  void testPushAndPopMany() throws EmptyStackException, BadTypeException {
    testStack.push(Symbol.DIVIDE);
    testStack.push(Symbol.PLUS);
    testStack.push(Symbol.TIME);
    
    Symbol pop = testStack.pop();
    assertEquals(Symbol.TIME, pop, "Test pop value is equal to value pushed last");
    assertEquals(2, testStack.size(), "Test stack size is 2 after 3 push and pop");
    
    pop = testStack.pop();
    assertEquals(Symbol.PLUS, pop, "Test pop value is equal to value pushed second");
    assertEquals(1, testStack.size(), "Test stack size is 1 after 3 push 2 pop");

    pop = testStack.pop();
    assertEquals(Symbol.DIVIDE, pop, "Test pop value is equal to value pushed first");
    assertEquals(0, testStack.size(), "Test stack size is 0 after 3 push 3 pop");

  }
  
  //Test7
  @Test
  void testEmptyPop() {
    EmptyStackException e = assertThrows(EmptyStackException.class, () -> testStack.pop());
    assertEquals("Error: Not enough numbers to calculate with. "
        + "Please check you are in the right calculation mode", e.getMessage(),"Test exception thrown when empty stack popped");
  }
  
  //Test8
  @Test
  void testTop() throws EmptyStackException, BadTypeException {
    testStack.push(Symbol.TIME);
    Symbol top = testStack.top();
    assertEquals(1, testStack.size(), "Test size remains as 1 after top() called");
    assertEquals(Symbol.TIME, top, "Test top value returns value pushed");
    
  }
  
  //Test9
  @Test
  void testTopOfMany() throws EmptyStackException, BadTypeException {
    testStack.push(Symbol.DIVIDE);
    
    Symbol top = testStack.top();
    assertEquals(1, testStack.size(), "Test size remains as 1 after top() called");
    assertEquals(Symbol.DIVIDE, top, "Test top value returns value pushed");
    
    testStack.push(Symbol.MINUS);
    
    top = testStack.top();
    assertEquals(2, testStack.size(), "Test size remains as 2 after top() called");
    assertEquals(Symbol.MINUS, top, "Test top value returns value pushed second");
    
    assertEquals(Symbol.MINUS, testStack.pop(), "Test that top does not remove the top value");

  }
  
}
