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
    assertEquals(testStack.size(), 0, "Test the size of an empty stack is 0");
  }

}
