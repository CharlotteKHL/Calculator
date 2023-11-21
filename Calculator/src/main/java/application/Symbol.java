package application;

/**
 * Possible non-number tokens in an expression.
 * 
 * @author Charlotte Lam
 */
public enum Symbol {
  LEFT_BRACKET("Left bracket"), RIGHT_BRACKET("Right bracket"), TIME("Multiply"), DIVIDE(
      "Divide"), PLUS("Plus"), MINUS("Minus"), INVALID("Invalid");

  private String symbol;

  private Symbol(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return "Symbol: " + symbol;
  }


}
