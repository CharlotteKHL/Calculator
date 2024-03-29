package application;

/**
 * Specialised stack class to store String values.
 * 
 * @author Charlotte Lam
 */
public class StrStack {

  private Stack strStack = new Stack();

  public int size() {
    return strStack.size();
  }

  /**
   * Adds a new string entry on the top of the stack, increments size of stack by 1.
   * 
   * @param string is the new string to be added to the top of the stack.
   */
  public void push(String string) {
    Entry newEntry = new Entry(string);
    strStack.push(newEntry);
  }

  /**
   * Retrieves and removes the string on the top of the stack, decrements size of stack by 1.
   * 
   * @return the string on the top of the stack
   * @throws EmptyStackException if called on an empty stack
   * @throws BadTypeException if the type of the getter for an Entry does not match its type
   */
  public String pop() throws EmptyStackException, BadTypeException {
    Entry returnString = strStack.pop();
    return returnString.getString();
  }

  /**
   * Retrieves string from the top of the stack without removing it.
   * 
   * @return the value of the string on the top of the stack
   * @throws EmptyStackException if called on an empty stack
   * @throws BadTypeException if the type of the getter for an Entry does not match its type
   */
  public String top() throws EmptyStackException, BadTypeException {
    Entry topString = strStack.top();
    return topString.getString();
  }

}
