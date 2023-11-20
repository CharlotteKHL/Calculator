package application;

/**
 * Exception class to be thrown when an empty stack has been popped or top entry requested.
 * 
 * @author Charlotte Lam
 */
public class EmptyStackException extends Exception {

  public EmptyStackException(String message) {
    super(message);
  }
}
