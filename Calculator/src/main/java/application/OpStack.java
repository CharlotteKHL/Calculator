package application;

/**
 * Specialised stack class to store operators in a mathematical expression.
 * 
 * @author Charlotte Lam
 */
public class OpStack {

  private Stack opStack = new Stack();

  /**
   * Retrieves the current size of the OpStack.
   * 
   * @return integer value of the current size of the stack
   */
  public int size() {
    return opStack.size();
  }

  /**
   * Pushes a new operator onto the stack and increments size of the stack by 1.
   * 
   * @param operator is the new operator to be added to the stack
   */
  public void push(Symbol operator) {
    Entry newEntry = new Entry(operator);
    opStack.push(newEntry);
  }

  /**
   * Retrieves and removes the operator on top of the stack and decrements size of stack by 1.
   * 
   * @return value of operator on top of the stack
   * @throws EmptyStackException if called on an empty OpStack
   * @throws BadTypeException if getter for entry value does not match the type of the value
   */
  public Symbol pop() throws EmptyStackException, BadTypeException {
    Entry returnEntry = opStack.pop();
    return returnEntry.getSymbol();
  }

  /**
   * Retrieves the value of the operator on the top of the stack without removing it.
   * 
   * @return Value of operator on the top of the stack
   * @throws EmptyStackException if called on an empty OpStack
   * @throws BadTypeException if getter for entry value does not match the type of the value
   */
  public Symbol top() throws EmptyStackException, BadTypeException {
    Entry top = opStack.top();
    return top.getSymbol();
  }

}
