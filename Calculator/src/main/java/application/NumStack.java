package application;

/**
 * NumStack class contains a stack specialised for floats.
 */
public class NumStack {
  private Stack numStack;
  
  /**
   * Constructor initialises numStack field.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Use to obtain current size of NumStack.
   * 
   * @return current size of stack
   */
  public float size() {
    return numStack.size();
  }

  /**
   * Use to add a value to the top of the stack.
   * 
   * @param value the float value to be added
   */
  public void push(float value) {
    Entry newEntry = new Entry(value);
    numStack.push(newEntry);
  }
  
  /**
   * Retrieves and removes the value at the top of the stack.
   * 
   * @return Float value popped off the top of the stack
   * @throws EmptyStackException thrown if stack is empty
   * @throws BadTypeException thrown if getter for entry called does not match float
   */
  public float pop() throws EmptyStackException, BadTypeException {
    Entry returnPop = numStack.pop();
    return returnPop.getValue();
  }

  /**
   * Returns value of item at the top of the stack without removing it.
   * 
   * @return Float value of item at the top of the stack
   * @throws EmptyStackException thrown if called on an empty stack
   * @throws BadTypeException thrown if getter for entry called does not match float
   */
  public float top() throws EmptyStackException, BadTypeException {
    Entry returnTop = numStack.top();
    return returnTop.getValue();
  }
  
}
