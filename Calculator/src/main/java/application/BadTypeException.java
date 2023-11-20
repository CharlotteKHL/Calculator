package application;

/**
 * Exception thrown if type is not matched when calling a get method.
 * 
 * @author Charlotte Lam
 */
public class BadTypeException extends Exception {

  public BadTypeException(String message) {
    super(message);
  }

}