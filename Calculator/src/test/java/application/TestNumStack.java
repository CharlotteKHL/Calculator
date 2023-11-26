package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {

  @BeforeEach
  void intialise() {
    Stack stack = new Stack();
  }
  
  //Test1
  @Test
  void testConstructor() {
    NumStack numStack = new NumStack();
    assertNotNull(numStack, "Constructor test");
  }

}
