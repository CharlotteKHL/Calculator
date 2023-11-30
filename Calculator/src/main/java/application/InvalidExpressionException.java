package application;

/**
 * An expression was passed to a method that could not be evaluated.
 */

public class InvalidExpressionException extends Exception {
  
  public InvalidExpressionException(String message) {
    super(message);
  }
}
