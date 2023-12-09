package application;

/**
 * Specialised stack class to store operators in a mathematical expression.
 */
public class OpStack {

  int size = 0;

  /**
   * Retrieves the current size of the OpStack.
   * 
   * @return integer value of the current size of the stack
   */
  public int size() {
    return size;
  }

  public void push(Symbol plus) {
    size = size + 1;
  }

}
