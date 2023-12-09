package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestStrStack {

  //Test
  @Test
  void testConstructor() {
    StrStack testStack = new StrStack();
    assertNotNull(testStack);
  }

}
