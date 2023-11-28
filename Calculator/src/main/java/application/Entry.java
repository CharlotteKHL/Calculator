package application;

import java.util.Objects;

/**
 * Entry class to define symbols written in the calculator.
 * 
 * @author Charlotte Lam
 */

public class Entry {
  private String str;
  private float number;
  private Symbol other;
  private Type type;
  private static final String BAD_TYPE_MSG = "Error: The entry is not of this type";

  /**
   * Constructor for String Entry.
   * 
   * @param str is string value of the entry
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  /**
   * Constructor for number Entry.
   * 
   * @param number is the float value of the entry
   */
  public Entry(float number) {
    this.number = number;
    this.type = Type.NUMBER;
  }

  /**
   * Constructor for Symbol Entry.
   * 
   * @param other is the symbol value of the entry
   */
  public Entry(Symbol other) {
    this.other = other;
    this.type = Type.SYMBOL;
  }

  /**
   * Getter for possible number value of Entry.
   * 
   * @return Number value held 
   * @throws BadTypeException if type does not match Number
   */ 
  public float getValue() throws BadTypeException {
    if (this.type == Type.NUMBER) {
      return this.number;
    } else {
      throw new BadTypeException(BAD_TYPE_MSG);
    }
  }

  /**
   * Getter for possible string value of Entry.
   * 
   * @return String value held
   * @throws BadTypeException if type does not match String
   */
  public String getString() throws BadTypeException {
    if (this.type == Type.STRING) {
      return this.str;
    } else {
      throw new BadTypeException(BAD_TYPE_MSG);
    }
  }

  /**
   * Getter for possible symbol value of Entry.
   * 
   * @return Symbol value held
   * @throws BadTypeException if type does not match Symbol
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.type == Type.SYMBOL) {
      return this.other;
    } else {
      throw new BadTypeException(BAD_TYPE_MSG);
    }
  }

  /**
   * Returns type of Entry.
   * 
   * @return type of Entry
   */
  public Type getType() {
    return this.type;
  }


  /**
   * Hash an Entry using number, other, str and type values.
   */
  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }


  /**
   * Determines equality between Entrys by comparing number, other, str and type values.
   * 
   * @return true if equal and false if not under the above conditions
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        // Check if Entry objects are equal only if their value and type are equal
        && this.other == other.other && Objects.equals(str, other.str) && type == other.type; 
  }

  /**
   * Formats an Entry when printed.
   */
  @Override
  public String toString() {
    switch(this.type) {  // Checks type and returns corresponding message
      case STRING:
        return this.type + ", String: " + this.str;
      default:
        if (this.type == Type.NUMBER) {
          return this.type + ", Value: " + this.number;
        }
    }
    return this.type + ", " + this.other;

  }



}