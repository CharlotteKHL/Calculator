package application;

/**
 * Possible types for Entry.
 * 
 * @author Charlotte Lam
 */
public enum Type {
  STRING("String"), NUMBER("Number"), SYMBOL("Symbol"), INVALID("Invalid");

  private String type;

  private Type(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Type: " + type;
  }
}


