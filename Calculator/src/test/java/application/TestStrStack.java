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

}
