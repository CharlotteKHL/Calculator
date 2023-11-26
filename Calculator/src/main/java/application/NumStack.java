package application;

/**
 * NumStack class contains a stack specialised for floats.
 */
public class NumStack {
  private int size = 0;
  private Stack numStack;
  
  public NumStack() {
    numStack = new Stack();
  }

  public float size() {
    return size;
  }

  public void push(float value) {
    size = size + 1;
    Entry newEntry = new Entry(value);
    numStack.push(newEntry);
  }
  
  public float pop() throws EmptyStackException, BadTypeException{
    size = size - 1;
    Entry returnPop = numStack.pop();
    return returnPop.getValue();
  }
  
}
