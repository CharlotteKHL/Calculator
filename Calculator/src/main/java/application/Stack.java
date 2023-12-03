package application;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack object class implementing a list of Entry objects.
 * 
 * @author Charlotte Lam
 */
public class Stack {

  private int size = 0;
  private List<Entry> entries = new ArrayList<Entry>();
  private static final String EMPTY_STACK_MSG = "Error: Not enough numbers to calculate with. "
      + "Please check you are in the right calculation mode";

  /**
   * Use to retrieve the current size of the stack.
   * 
   * @return the current size of the stack as an integer
   */
  public int size() {
    return size;
  }

  /**
   * Adds an entry onto the stack and increases size of the stack by 1.
   * 
   * @param entry is the Entry object to be added to the stack
   */
  public void push(Entry entry) {
    entries.add(entry);
    size++;
  }

  /**
   * Removes Entry off the top of stack and returns it. Reduces size of stack by 1.
   * 
   * @return Entry popped off the top of the stack
   * @throws EmptyStackException if size of stack is 0
   */
  public Entry pop() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException(EMPTY_STACK_MSG);
    }
    size--;
    // Store entry to be removed in a temporary value to return
    Entry returnValue = entries.get(size); 
    entries.remove(size);
    return returnValue;
  }

  /**
   * Retrieves Entry at the top of the stack without removing it.
   * 
   * @return Entry at the top of the stack without removing it
   * @throws EmptyStackException if stack is empty
   */
  public Entry top() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException(EMPTY_STACK_MSG);
    }
    return entries.get(size - 1);
  } 

}