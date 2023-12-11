package application;

/**
 * Exception class to be thrown when pop or top called on an Empty stack.
 * 
 * @author Charlotte Lam
 */
public class EmptyStackException extends Exception {

  public EmptyStackException(String message) {
    super(message);
  }
}
