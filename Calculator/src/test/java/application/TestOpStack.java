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
  void testPushAndPop() {
    testStack.push(plus);
    Symbol pop = testStack.pop();
    assertEquals(0, testStack.size(), "Test stack size is 0 after a push and pop");
    assertEquals(Symbol.PLUS, pop, "Test value popped off top of stack is the value pushed on");
    
  }
  
}
