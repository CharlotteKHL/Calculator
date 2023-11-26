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
  

}
