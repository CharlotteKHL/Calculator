package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test class for Stack object.
 * 
 * @author Charlotte Lam
 */
class TestStack {

  private Stack stack;
  private Entry add = new Entry(Symbol.PLUS);
  private Entry number = new Entry(2.12f);
  private Entry string = new Entry("Hello");

  /*
   * Test1 - Test8 structure referenced from TDD panopto video demo Author: Dave Cohen Origin:
   * https://rhul.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=32530776-f852-4740-8589-
   * b07c00c72842
   */

  /*
   * Test1 makes a new stack. Modified to initialise stack for following tests Stack class created.
   */
  @BeforeEach
  public void testStack() {
    stack = new Stack();
  }

  /*
   * Test2 test size method Create size() method in Stack class, always return 0.
   */
  @Test
  void testSize() {
    assertEquals(0, stack.size());
  }

  /*
   * Test3 test push method. Modified to use an entry object instead of an integer. 
   * Create push() method in Stack class, always return 1.
   */
  @Test
  void testPush() {
    stack.push(add);
    assertEquals(1, stack.size());
  }

  /*
   * Test4 test empty pop throws an EmptyStackException.
   * Create new class EmptyStackException, with message "Stack is empty".
   * Size field created and initialised to 0, changed pop() to check if size is 0. 
   * Throws new EmptyStackException in pop if size is 0.
   */

  @Test
  void testEmptyPop() {
    EmptyStackException e = assertThrows(EmptyStackException.class, () -> stack.pop());
    assertEquals("Error: Stack is empty", e.getMessage());
  }

  /* 
   * Test5 tests push then pop. Modified to use an entry object instead of an integer.
   * Added a value field that held the value of first push, pop can then return this value.
   * Push sets size to 1 and pop sets size to 0.
   */

  @Test
  void testPushAndPop() throws EmptyStackException {
    stack.push(add);
    assertEquals(add, stack.pop());
    assertEquals(0, stack.size());
  }

  /* 
   * Test6 tests a push twice then pop in twice in the same order. Modified to use an entry
   * object instead of an integer.
   * Array field added to store values, up to 10 values. 
   * Size used as an index to place and access values.
   * In push, initialise value with input and size increased by 1.
   * In pop, size decreased by 1 and return value at size index.
   */ 

  @Test
  void pushTwice() throws EmptyStackException {
    stack.push(add);
    stack.push(number);
    assertEquals(2, stack.size());;
    assertEquals(number, stack.pop());
    assertEquals(add, stack.pop());
    assertEquals(0, stack.size());
  }

  /* 
   * Test7 push a lot. Modified to use an entry object instead of an integer.
   * Changed index of Array to 50 when initialised.
   */

  @Test
  void pushLoop() {
    for (int index = 0; index < 50; index++) {
      stack.push(string);
    }
  }

  /* 
   * Test8 push a random number above 50. Modified to use an entry object instead of an integer.
   * Change Array to ArrayList field. 
   * Changed push to add to list, and pop to remove from list at size index.
   */

  @Test
  void pushLoopRandom() {
    Random rd = new Random();
    int rdMax = (50 + rd.nextInt(1000));
    for (int index = 0; index < (50 + rdMax); index++) {
      stack.push(string);
    }
    assertEquals(50 + rdMax, stack.size());
  }

  // Test9 top throws a BadTypeException when stack is empty

  @Test
  void testTop() {
    EmptyStackException e = assertThrows(EmptyStackException.class, () -> stack.top());
    assertEquals("Error: Stack is empty", e.getMessage());
  }

  // Test10 top returns value expected

  @Test
  void testTopReturn() throws EmptyStackException {
    stack.push(add);
    assertEquals(add, stack.top());
    stack.push(number);
    assertEquals(number, stack.top());
  }

}
